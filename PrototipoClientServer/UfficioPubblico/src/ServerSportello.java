import java.rmi.RemoteException;

public class ServerSportello extends Server implements TerminaleSportello {

    public ServerSportello() throws RemoteException {
    }

    @Override
    public String changeStato(int numeroSportello, StatoSportello statoSportello) throws RemoteException {
        return ufficioPubblico.changeStato(numeroSportello,statoSportello);
    }

    @Override
    public String creaSportello() throws RemoteException {
        return ufficioPubblico.creaSportello();
    }
}
