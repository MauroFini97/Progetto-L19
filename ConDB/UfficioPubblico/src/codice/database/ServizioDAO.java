package codice.database;

import codice.dominio.ufficio.IdServizio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ServizioDAO implements IServizioMapper{
    private String nomeTabella;
    private Connection con;

    public ServizioDAO(String nomeTabella) {
        this.nomeTabella = nomeTabella;
        //this.con= DriverManager.getConnection(url,user,password);
    }


    @Override
    public void update(IdServizio idServizio) {
        //Statement stmt = con.createStatement();
        String sql= "UPDATE "+nomeTabella+" SET numProg=numProg+1 WHERE IdServizio= "+idServizio.toString();
        //stmt.executeQuery(sql);
    }
}
