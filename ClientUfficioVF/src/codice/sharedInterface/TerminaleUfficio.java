package codice.sharedInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TerminaleUfficio extends Remote {
    String visualizzaStato() throws RemoteException;
}
