package codice.sharedInterface;

import codice.dominio.sportello.StatoSportello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TerminaleSportello extends Remote {
    String changeStato(int numeroSportello, StatoSportello statoSportello) throws RemoteException;
    String creaSportello(int numeroSportello,String tipo) throws RemoteException;
}