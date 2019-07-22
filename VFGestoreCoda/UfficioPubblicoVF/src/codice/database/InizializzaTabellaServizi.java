package codice.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Classe utilizzata per inizializzare il database remoto; non la si cancella per avere subito
 * un riscontro dei nomi utilizzati per gli elementi nel database
 */
public class InizializzaTabellaServizi {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        int result=0;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7299043","sql7299043","liGVKrjUG5");


            if(con!= null)
                System.out.println("Connessione effettuata");
            else System.out.println("Problema con la connessione al database");

            stmt = con.createStatement();


            stmt.executeUpdate("ALTER TABLE LISTASERVIZI ADD prenotazioniInCoda INT;");


            /*result= stmt.executeUpdate("INSERT INTO LISTASERVIZI" +
                    " VALUES ('SRP',0)");

            stmt.executeUpdate("INSERT INTO LISTASERVIZI" +
                    " VALUES ('PB',0)");
            stmt.executeUpdate("INSERT INTO LISTASERVIZI" +
                    " VALUES ('RPC',0)");
            stmt.executeUpdate("INSERT INTO LISTASERVIZI" +
                    " VALUES ('OCP',0)");
            stmt.executeUpdate("INSERT INTO LISTASERVIZI" +
                    " VALUES ('CV',0)");


            System.out.println(result);*/


        }catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println(result+" rows effected");

    }
}
