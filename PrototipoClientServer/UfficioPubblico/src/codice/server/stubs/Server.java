package codice.server.stubs;

import codice.dominio.ufficio.Ufficio;

import java.rmi.RemoteException;

/**
 * Classe server che crea l'ufficio. le classi che estendono questa avranno i vari metodi remoti che saranno
 * invocati dai diversi client che si interfacciano con questo server. Si utilizza la tecnologia RMI(Remote Method Invocation)
 * ...vedere la documentazione ufficiale della java rmi per maggiori informazioni sull'implementazione di questo server
 */

public class Server {
    protected Ufficio ufficioPubblico;

    public Server() throws RemoteException {
        this.ufficioPubblico = new Ufficio();
    }


}
