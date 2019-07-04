import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientUtente {

    static int numeroPrenotato = 0;

    public static void main(String[] args) {

        String host = "192.168.1.152";
        Scanner tastieraUtente = new Scanner(System.in);

        while(true) {
            System.out.println("PRENOTARE SERVIZIO\n" +
                    "SRP:SPEDIZIONE E RITIRO PACCHI\n" +
                    "PB: PAGAMENTO BOLLETTINI\n" +
                    "RPC:RICARICA POSTEPAY E CELLULARI\n" +
                    "OCP:OPERAZIONI SUL CONTO POSTALE\n" +
                    "CV:CAMBIO VALUTA\n");
            String idServizio = tastieraUtente.nextLine();

            try {
                Registry registry = LocateRegistry.getRegistry(host);

                TerminaleUtente stubUtente = (TerminaleUtente) registry.lookup("utente");

                numeroPrenotato = stubUtente.prenota(IdServizio.valueOf(idServizio));

                System.out.println("prenotazione effettuata: "+numeroPrenotato);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


}
