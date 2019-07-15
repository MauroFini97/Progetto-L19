package codice.sharedInterface;

import codice.dominio.sportello.StatoSportello;
import codice.dominio.ufficio.IdServizio;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TerminaleSportello extends Remote {
    boolean changeStato(int numeroSportello, StatoSportello statoSportello) throws RemoteException;
    String collegaSportello(int numeroSportello, String tipo, IdServizio idServizio) throws RemoteException;
    StatoSportello getStatoSportelloPerServer(int numeroSportello) throws RemoteException;
    int getNumeroClienteSportelloPerServer(int numeroSportello) throws RemoteException;
    IdServizio getIdServizioOffertoSportelloPerServer(int numeroSportello) throws RemoteException;
}
