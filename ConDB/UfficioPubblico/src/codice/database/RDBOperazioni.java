package codice.database;

import codice.dominio.ufficio.IdServizio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RDBOperazioni {

    private Connection con;

    public RDBOperazioni() {
        connect("blank","blank");
    }

    private void connect(String username, String password){
        try {
            con = DriverManager.getConnection("URL", username, password);
        }catch (SQLException s){
            s.getErrorCode();
        }
    }


    public void updateNumeroProgServizio(IdServizio idServizio){
        try {
            Statement stmt = con.createStatement();
            stmt.executeQuery("UPDATE LISTA_SERVIZI SET numeroProgressivo=numeroProgressivo+1 WHERE IdServizio="+idServizio);
        }catch (SQLException s){
            s.getErrorCode();
        }
    }

}
