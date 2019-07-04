import java.rmi.RemoteException;

public class Server {
    protected Ufficio ufficioPubblico;

    public Server() throws RemoteException {
        this.ufficioPubblico = new Ufficio();
    }


}
