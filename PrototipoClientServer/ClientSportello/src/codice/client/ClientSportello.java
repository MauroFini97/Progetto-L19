package codice.client;

import codice.dominio.sportello.StatoSportello;
import codice.dominio.ufficio.IdServizio;
import codice.sharedInterface.TerminaleSportello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * bisogna inizializzare il numero sportello e il tipo;
 * NOTA: nel server, 2 sono gli sportelli fissi: il numero 0 (offre SRP)
 *                                               il numero 1 (offre OCP)
 * se si setta con 0, allora il tipo è FISSO,idServizio=SRP
 * se si setta con 1, allora il tipo è FISSO,idServizio=OCP
 * se si setta con altri numeri fino al 5, il tipo è VARIABILE,idServizio=null
 */

public class ClientSportello {

    public static void main(String[] args) {

        String host = "192.168.1.152";

        SportelloClient sportello = new SportelloClient(0);

        System.out.println(sportello.collegaAlServer(host));

        Scanner tastieraSportello = new Scanner(System.in);

        while(true) {
            String comando= tastieraSportello.nextLine();

            sportello.cambiaStato(StatoSportello.valueOf(comando));

            System.out.println(sportello);


        }


    }


}