package codice;

import codice.client.SportelloClient;
import codice.dominio.sportello.StatoSportello;
import codice.grafica.FinestraPrincipale;

import java.util.Scanner;

public class StartApplication {
    public static void main(String[] args) {
        String host = "192.168.1.6";

        SportelloClient sportello = new SportelloClient(3);

        System.err.println(sportello.collegaAlServer(host));

        FinestraPrincipale grafica = new FinestraPrincipale(sportello);
    }
}
