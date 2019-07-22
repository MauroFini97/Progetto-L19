package codice.sharedInterface;

import codice.dominio.ufficio.IdServizio;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TerminaleUtente extends Remote {

    int prenota(IdServizio idServizio) throws RemoteException;
}
