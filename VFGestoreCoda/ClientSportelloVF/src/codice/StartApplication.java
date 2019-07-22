package codice;

import codice.client.SportelloClient;
import codice.dominio.sportello.StatoSportello;

import java.util.Scanner;

public class StartApplication {
    public static void main(String[] args) {
        String host = "192.168.43.234";

        SportelloClient sportello = new SportelloClient(3);

        System.err.println(sportello.collegaAlServer(host));

        Scanner tastieraSportello = new Scanner(System.in);

        while(true) {
            String comando= tastieraSportello.nextLine();

            sportello.cambiaStato(StatoSportello.valueOf(comando));

            System.out.println(sportello);


        }
    }
}
