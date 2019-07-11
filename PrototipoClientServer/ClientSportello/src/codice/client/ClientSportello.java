package codice.client;

import codice.dominio.sportello.StatoSportello;
import codice.sharedInterface.TerminaleSportello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * bisogna inizializzare il numero sportello e il tipo;
 * NOTA: nel server, 2 sono gli sportelli fissi: il numero 0 (offre SRP)
 *                                               il numero 1 (offre OCP)
 * se si setta con 0, allora il tipo è FISSOSRP
 * se si setta con 1, allora il tipo è FISSOOCP
 * se si setta con altri numeri fino al 5, il tipo è VARIABILE
 */

public class ClientSportello {

    static int numeroSportello;
    static String tipo;
    static String stato;
    static String servizioOfferto;
    static String numeroClienteInServizio;

    public static void settaAttributi(String datiDaServer){
        StringTokenizer st = new StringTokenizer(datiDaServer);

        stato =  st.nextToken();
        servizioOfferto =  st.nextToken();
        numeroClienteInServizio = st.nextToken();

    }

    public static void main(String[] args) {

        String host = "192.168.1.152";

        numeroSportello=0;
        tipo="FISSOSRP";

        try {
            Registry registry = LocateRegistry.getRegistry(host);
            TerminaleSportello stubSportello = (TerminaleSportello) registry.lookup("sportello");

            String messaggioServer= stubSportello.collegaSportello(numeroSportello,tipo);

            System.out.println(messaggioServer);
        }catch (Exception e){
            e.printStackTrace();
        }

        Scanner tastieraSportello = new Scanner(System.in);

        while(true) {
            String comando= tastieraSportello.nextLine();
            try {

                String datiDaServer="blank";

                if(comando.equals("LIBERO")) {
                    Registry registry = LocateRegistry.getRegistry(host);
                    TerminaleSportello stubSportello = (TerminaleSportello) registry.lookup("sportello");

                    datiDaServer = stubSportello.changeStato(numeroSportello, StatoSportello.LIBERO);

                    if(datiDaServer.equals("blank")){
                        break;
                    }
                    settaAttributi(datiDaServer);
                    System.out.println(stato+"\n" +
                            servizioOfferto+"\n" +
                            numeroClienteInServizio);

                }else{
                    System.err.println("errore comando: ripetere");
                }

            }catch (Exception e){
                e.printStackTrace();
            }


        }


    }


}