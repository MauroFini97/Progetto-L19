package codice.client;

import codice.sharedInterface.TerminaleUfficio;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientUfficio {
    public static void main(String[] args) {

        String host = "192.168.1.4";
        Scanner tastiera = new Scanner(System.in);

        while(true){
            String comando = tastiera.nextLine();
            String statoUfficio= "blank";
            try {

                if(comando.equals("YES")){
                    Registry registry = LocateRegistry.getRegistry(host);

                    TerminaleUfficio stubUfficio = (TerminaleUfficio) registry.lookup("ufficio");

                    System.out.println(stubUfficio.visualizzaStato());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }


}
