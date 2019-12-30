package codice.database;

import codice.dominio.ufficio.IdServizio;
import codice.dominio.ufficio.ListaServizi;
import codice.dominio.ufficio.Servizio;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServizioDAO implements IServizioMapper{

    // Dati generali
    private String nomeTabella = "listaservizi";
    private Connection con;
    private Statement stmt=null;

    // Dati connessione al DataBase
    private String host = "jdbc:mysql://localhost:3306/ufficiopubblico-data?useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String password = "mysqlpassword";

    public ServizioDAO() {
        this.con= connettiAlDB(host, user, password);
    }

    private Connection connettiAlDB(String host, String user, String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(host, user, password);
            System.err.println("CONNESSIONE AL DATABASE EFFETTUATA");
            return connect;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServizioDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ServizioDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Servizio get(IdServizio idServizio) {
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM " + nomeTabella + " WHERE idServizio='" + idServizio.toString()+"'";
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
            String sql = "UPDATE " + nomeTabella + " SET numProg=numProg+1, prenotazioniInCoda='"+numPrenotazioniCoda+"' WHERE idServizio='" + idServizio.toString()+"'";
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
                String sql = "UPDATE " + nomeTabella + " SET numProg=0,prenotazioniInCoda=0 WHERE idServizio='" + s.toString()+"'";
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
