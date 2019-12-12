package codice.database;

import codice.dominio.ufficio.IdServizio;
import codice.dominio.ufficio.ListaServizi;
import codice.dominio.ufficio.Servizio;

import java.sql.*;
import java.util.ArrayList;

public class ServizioDAO implements IServizioMapper{
    private String nomeTabella = "LISTASERVIZI";
    private Connection con;
    private Statement stmt=null;

    private String provider = "jdbc:mysql://";
    private String routeDatabase = "remotemysql.com";
    private String host = provider+routeDatabase;
    private String user = "epH5zPeJsu";
    private String password = "uk4XtlxMat";

    public ServizioDAO() {
        this.con= connettiAlDB(host+user, user, password);
    }

    private Connection connettiAlDB(String host,String username,String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(host,username,password);


            if (con != null)
                System.out.println("Connessione effettuata");

            return connection;

        }catch (Exception e){
            System.err.println("PROBLEMA CONNESSIONE AL DATABASE");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Servizio get(IdServizio idServizio) {
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM " + nomeTabella + " WHERE IdServizio= '" + idServizio.toString()+"'";
            ResultSet rs=  stmt.executeQuery(sql);

            Servizio n=null;
            while (rs.next()){
                String id=rs.getString("idServizio");
                int numProg = rs.getInt("numProg");
                int numPren = rs.getInt("prenotazioniInCoda");
                n = new Servizio(IdServizio.valueOf(id));
                n.setnumProg(numProg);
                n.settaPrenotazioniInCoda(numPren);
            }

            con.close();
            return n;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(IdServizio idServizio) {
        int numPrenotazioniCoda = ListaServizi.getInstance().getServizio(idServizio).getCodaServizio().prenotazioniInCoda();
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE " + nomeTabella + " SET numProg=numProg+1, prenotazioniInCoda='"+numPrenotazioniCoda+"' WHERE IdServizio= '" + idServizio.toString()+"'";
            stmt.executeUpdate(sql);
            con.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void refresh() {
        try {
            Statement stmt = con.createStatement();

            for (IdServizio s:IdServizio.values()
                 ) {
                String sql = "UPDATE " + nomeTabella + " SET numProg=0,prenotazioniInCoda=0 WHERE IdServizio= '" + s.toString()+"'";
                stmt.executeUpdate(sql);
            }
            con.close();
            System.err.println("Database refreshato");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Servizio> restore(){
        ArrayList<Servizio> serviziDB= new ArrayList<>();

        for (IdServizio s: IdServizio.values()
        ) {
            Servizio servizioRestored= new ServizioDAO().get(s);
            serviziDB.add(servizioRestored);
        }


        System.err.println("Restore dal Database effettuato");
        return serviziDB;
    }



}
