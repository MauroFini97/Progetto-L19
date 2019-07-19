package codice.database;

import codice.dominio.ufficio.IdServizio;
import codice.dominio.ufficio.Servizio;

import java.sql.*;

public class ServizioDAO implements IServizioMapper{
    private String nomeTabella = "LISTASERVIZI";
    private Connection con;
    private Statement stmt=null;

    public ServizioDAO() {
        this.con= connettiAlDB("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7299043", "sql7299043", "liGVKrjUG5");
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
            String sql = "SELECT * FROM " + nomeTabella + " WHERE IdServizio= " + idServizio.toString();
            ResultSet rs=  stmt.executeQuery(sql);
            con.close();

            Servizio n=null;
            while (rs.next()){
                String id=rs.getString("idServizio");
                int numProg = rs.getInt("numProg");
                n = new Servizio(IdServizio.valueOf(id));
                n.setnumProg(numProg);
            }
            return n;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(IdServizio idServizio) {
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE " + nomeTabella + " SET numProg=numProg+1 WHERE IdServizio= " + idServizio.toString();
            stmt.executeQuery(sql);
            con.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
