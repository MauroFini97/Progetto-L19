import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiziServer extends Remote {
    void changeStato(int numeroSportello,StatoSportello statoSportello) throws RemoteException;
    String visualizzaStato() throws RemoteException;
    int prenota(IdServizio idServizio) throws RemoteException;
}
