package codice;

import codice.dominio.ufficio.Ufficio;
import codice.grafica.FinestraPrincipale;
import codice.server.ServerController;

public class StartApplication {
    public static void main(String[] args) {
        Ufficio ufficio = new Ufficio();

        ServerController server = new ServerController(ufficio);

        FinestraPrincipale grafica = new FinestraPrincipale(server);

    }

}
