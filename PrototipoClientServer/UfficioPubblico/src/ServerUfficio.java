import java.rmi.RemoteException;

public class ServerUfficio extends Server implements TerminaleUfficio{

    public ServerUfficio() throws RemoteException {
    }

    @Override
    public String visualizzaStato() {
        return ufficioPubblico.visualizzaStato();
    }
}
