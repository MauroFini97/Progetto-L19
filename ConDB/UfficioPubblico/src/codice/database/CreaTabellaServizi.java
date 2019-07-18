package codice.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreaTabellaServizi {

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        int result=0;

        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con= DriverManager.getConnection("jdbc:hsqldb:file:db/testdb","SA","");


            if(con!= null)
                System.out.println("Connessione effettuata");
            else System.out.println("Problema con la connessione al database");

            stmt=con.createStatement();

            stmt.executeUpdate("CREATE TABLE ListaServizi (" +
                    "IdServizio VARCHAR(5) NOT NULL, numProg INT," +
                    "PRIMARY KEY (IdServizio) )");


        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
