package codice.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InizializzaTabellaServizi {
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

            stmt.executeUpdate("CREATE TABLE LISTASERVIZI (" +
                    "IdServizio VARCHAR(5) NOT NULL, numProg INT," +
                    "PRIMARY KEY (IdServizio) )");

            stmt.executeUpdate("INSERT INTO LISTASERVIZI" +
                    " VALUES ('SRP',0)");
            stmt.executeUpdate("INSERT INTO LISTASERVIZI" +
                    " VALUES ('PB',0)");
            stmt.executeUpdate("INSERT INTO LISTASERVIZI" +
                    " VALUES ('RPC',0)");
            stmt.executeUpdate("INSERT INTO LISTASERVIZI" +
                    " VALUES ('OCP',0)");
            stmt.executeUpdate("INSERT INTO LISTASERVIZI" +
                    " VALUES ('CV',0)");
            con.commit();


        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(result+" rows effected");

    }
}
