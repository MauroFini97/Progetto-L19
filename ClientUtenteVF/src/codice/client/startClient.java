package codice.client;

import codice.dominio.ufficio.IdServizio;
import java.util.Scanner;

public class startClient {

    public static void main(String[] args) {

        String host = "10.65.27.186";

        UserClient user = new UserClient(host);

        while(true) {

            Scanner tastieraUtente = new Scanner(System.in);

            System.out.println("PRENOTARE SERVIZIO\n" +
                    "SRP:SPEDIZIONE E RITIRO PACCHI\n" +
                    "PB: PAGAMENTO BOLLETTINI\n" +
                    "RPC:RICARICA POSTEPAY E CELLULARI\n" +
                    "OCP:OPERAZIONI SUL CONTO POSTALE\n" +
                    "CV:CAMBIO VALUTA\n");
            String idServizio = tastieraUtente.nextLine();


            //user.prenota(IdServizio.valueOf(idServizio));

        }


    }


}
