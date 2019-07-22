package codice;

import codice.dominio.ufficio.Ufficio;
import codice.grafica.StartGrafica;
import codice.server.SettaServer;

public class StartApplication {
    public static void main(String[] args) {
        Ufficio ufficio = new Ufficio();

        SettaServer server = new SettaServer(ufficio);

        server.main(null);

        StartGrafica grafica = new StartGrafica(ufficio);

        grafica.main(null);

    }

}
