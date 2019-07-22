package codice.client;

import codice.dominio.sportello.StatoSportello;
import codice.dominio.ufficio.IdServizio;
import codice.sharedInterface.TerminaleSportello;
import codice.sharedInterface.TerminaleUtente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UfficioClient{

    private String host;

    public UfficioClient(String host) {
        this.host = host;
    }


    public int getServizioNumProgr(IdServizio idServizio) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(host);

            TerminaleUtente stubUtente = (TerminaleUtente) registry.lookup("utente");

            return stubUtente.getServizioNumProgr(idServizio);

        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }

    }



    public int getPrenotazioniInCoda(IdServizio idServizio) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(host);

            TerminaleUtente stubUtente = (TerminaleUtente) registry.lookup("utente");

            return stubUtente.getPrenotazioniInCoda(idServizio);

        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }


    public StatoSportello getStatoSportelloPerServer(int numeroSportello) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(host);

            TerminaleSportello stubSportello = (TerminaleSportello) registry.lookup("sportello");

            return stubSportello.getStatoSportelloPerServer(numeroSportello);

        }catch (Exception e){
            System.err.println("CHIUSO");
            //e.printStackTrace();
            return null;
        }

    }


    public IdServizio getIdServizioOffertoSportelloPerServer(int numeroSportello) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(host);

            TerminaleSportello stubSportello = (TerminaleSportello) registry.lookup("sportello");

            return stubSportello.getIdServizioOffertoSportelloPerServer(numeroSportello);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



    public int getNumeroClienteSportelloPerServer(int numeroSportello) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(host);

            TerminaleSportello stubSportello = (TerminaleSportello) registry.lookup("sportello");

            return stubSportello.getNumeroClienteSportelloPerServer(numeroSportello);

        }catch (Exception e){
            //e.printStackTrace();
            return -2;
        }
    }
}
