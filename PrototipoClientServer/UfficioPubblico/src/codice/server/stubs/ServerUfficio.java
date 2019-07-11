package codice.server.stubs;

import codice.dominio.ufficio.Ufficio;
import codice.sharedInterface.TerminaleUfficio;

import java.rmi.RemoteException;

public class ServerUfficio extends Server implements TerminaleUfficio {

    public ServerUfficio(Ufficio ufficio) throws RemoteException {
        super(ufficio);
    }

    @Override
    public Ufficio riceviAggiornameto() throws RemoteException {
        return ufficioPubblico.riceviAggiornameto();
    }
}
