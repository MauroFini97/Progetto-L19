import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientSportello {

    static int numeroSportello;
    static StatoSportello stato;

    public static void main(String[] args) {

        String host = "192.168.1.152";

        try {
            Registry registry = LocateRegistry.getRegistry(host);
            TerminaleSportello stubSportello = (TerminaleSportello) registry.lookup("sportello");

            numeroSportello = Integer.valueOf(stubSportello.creaSportello());

            System.out.println(numeroSportello);
        }catch (Exception e){
            e.printStackTrace();
        }

        Scanner tastieraSportello = new Scanner(System.in);

        while(true) {
            String comando= tastieraSportello.nextLine();
            String datiDaServer="blank";
            try {

                if(comando.equals("LIBERO")) {
                    Registry registry = LocateRegistry.getRegistry(host);
                    TerminaleSportello stubSportello = (TerminaleSportello) registry.lookup("sportello");

                    datiDaServer = stubSportello.changeStato(numeroSportello, StatoSportello.LIBERO);
                }

                System.out.println(datiDaServer);

            }catch (Exception e){
                e.printStackTrace();
            }


        }


    }


}