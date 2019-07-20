package codice.sharedInterface;

import codice.dominio.ufficio.Ufficio;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TerminaleUfficio extends Remote {
    String riceviAggiornameto() throws RemoteException;
}
