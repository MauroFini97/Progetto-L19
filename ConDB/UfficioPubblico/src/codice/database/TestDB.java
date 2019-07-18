package codice.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) {
        Connection con=null;

        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con= DriverManager.getConnection("jdbc:hsqldb:file:db/testdb","SA","");

            if(con!= null)
                System.out.println("Connessione effettuata");
            else System.out.println("Problema con la connessione al database");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
