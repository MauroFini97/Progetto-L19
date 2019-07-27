package codice.sharedInterface;

import codice.dominio.ufficio.IdServizio;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TerminaleUtente extends Remote {
   int getServizioNumProgr(IdServizio idServizio) throws RemoteException;
   int getPrenotazioniInCoda(IdServizio idServizio) throws RemoteException;
   int prenota(IdServizio idServizio) throws RemoteException;

   int minutiMediDiAttesa(IdServizio idServizio) throws RemoteException;
}
