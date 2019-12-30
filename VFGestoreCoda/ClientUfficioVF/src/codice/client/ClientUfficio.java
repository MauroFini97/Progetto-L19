/*package codice.client;

import codice.dominio.ufficio.IdServizio;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientUfficio {
    public static void main(String[] args) {

        String host = "192.168.43.234";

        UfficioClient ufficioClient=new UfficioClient(host);

        Scanner tastiera = new Scanner(System.in);

        while(true){
            String comando = tastiera.nextLine();
            String statoUfficio= "blank";
            try {

                if(comando.equals("YES")){
                    for (IdServizio i: IdServizio.values()
                         ) {
                        System.out.println(i);
                        System.out.println(ufficioClient.getServizioNumProgr(i));
                        System.out.println(ufficioClient.getPrenotazioniInCoda(i));
                    }
                    System.err.println("AGGIORNATI SERVIZI");

                    for(int i =0;i<5;i++){
                        System.out.println(i);
                        System.out.println(ufficioClient.getStatoSportelloPerServer(i));
                        System.out.println(ufficioClient.getIdServizioOffertoSportelloPerServer(i));
                        System.out.println(ufficioClient.getNumeroClienteSportelloPerServer(i));
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }


}*/
