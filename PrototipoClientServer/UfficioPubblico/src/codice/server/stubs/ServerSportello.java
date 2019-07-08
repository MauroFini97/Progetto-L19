package codice.server.stubs;

import codice.dominio.sportello.StatoSportello;
import codice.sharedInterface.TerminaleSportello;

import java.rmi.RemoteException;

public class ServerSportello extends Server implements TerminaleSportello {

    public ServerSportello() throws RemoteException {
    }

    @Override
    public String changeStato(int numeroSportello, StatoSportello statoSportello) throws RemoteException {
        return ufficioPubblico.changeStato(numeroSportello,statoSportello);
    }

    @Override
    public String creaSportello(int numeroSportello,String tipo) throws RemoteException {
        return ufficioPubblico.creaSportello(numeroSportello,tipo);
    }
}
