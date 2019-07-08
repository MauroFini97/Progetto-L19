package codice.server.stubs;

import codice.dominio.ufficio.IdServizio;
import codice.sharedInterface.TerminaleUtente;

import java.rmi.RemoteException;

public class ServerUtente extends Server implements TerminaleUtente {

    public ServerUtente() throws RemoteException {
    }

    @Override
    public int prenota(IdServizio idServizio) throws RemoteException {
        return ufficioPubblico.prenota(idServizio);
    }
}
