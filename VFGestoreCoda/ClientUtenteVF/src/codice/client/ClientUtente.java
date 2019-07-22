package codice.client;

import codice.dominio.ufficio.IdServizio;
import codice.sharedInterface.TerminaleUtente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientUtente {

    private int numeroPrenotato;
    private String host;

    public ClientUtente() {
        String host = "10.65.27.186";
        numeroPrenotato = 0;
    }

    public String prenotaNum(String idServizio) {
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            TerminaleUtente stubUtente = (TerminaleUtente) registry.lookup("utente");
            numeroPrenotato = stubUtente.prenota(IdServizio.valueOf(idServizio));
            System.out.println("prenotazione effettuata: "+numeroPrenotato);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String num = String.valueOf(numeroPrenotato);
        return num;
    }
}
