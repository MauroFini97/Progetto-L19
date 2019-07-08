package codice.client;

import codice.dominio.ufficio.IdServizio;
import codice.sharedInterface.TerminaleUtente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UserClient{
    private int numeroPrenotato;

    private String host;

    public UserClient(String host) {
        this.host = host;
    }


    public void prenota(IdServizio idServizio) {
        try {
            Registry registry = LocateRegistry.getRegistry(host);

            TerminaleUtente stubUtente = (TerminaleUtente) registry.lookup("utente");

            numeroPrenotato = stubUtente.prenota(idServizio);

            System.out.println("prenotazione effettuata: "+numeroPrenotato);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
