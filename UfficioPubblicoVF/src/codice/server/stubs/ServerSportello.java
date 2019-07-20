package codice.server.stubs;

import codice.dominio.sportello.StatoSportello;
import codice.dominio.ufficio.IdServizio;
import codice.dominio.ufficio.Ufficio;
import codice.sharedInterface.TerminaleSportello;

import java.rmi.RemoteException;

public class ServerSportello extends Server implements TerminaleSportello {

    public ServerSportello(Ufficio ufficio) throws RemoteException {
        super(ufficio);
    }

    @Override
    public boolean changeStato(int numeroSportello, StatoSportello statoSportello) throws RemoteException {
        return ufficioPubblico.changeStato(numeroSportello,statoSportello);
    }

    @Override
    public String collegaSportello(int numeroSportello, IdServizio idServizio) throws RemoteException {
        return ufficioPubblico.creaSportello(numeroSportello,idServizio);
    }

    @Override
    public StatoSportello getStatoSportelloPerServer(int numeroSportello) throws RemoteException {
        return ufficioPubblico.getStatoSportelloPerServer(numeroSportello);
    }


    @Override
    public IdServizio getIdServizioOffertoSportelloPerServer(int numeroSportello) throws RemoteException {
        return ufficioPubblico.getIdServizioOffertoSportelloPerServer(numeroSportello);
    }


    @Override
    public int getNumeroClienteSportelloPerServer(int numeroSportello) throws RemoteException {
        return ufficioPubblico.getNumeroClienteSportelloPerServer(numeroSportello);
    }
}
