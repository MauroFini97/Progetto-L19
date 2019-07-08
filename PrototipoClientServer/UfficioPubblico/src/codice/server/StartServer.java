package codice.server;

import codice.server.stubs.ServerSportello;
import codice.server.stubs.ServerUfficio;
import codice.server.stubs.ServerUtente;
import codice.sharedInterface.TerminaleSportello;
import codice.sharedInterface.TerminaleUfficio;
import codice.sharedInterface.TerminaleUtente;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class StartServer {

    public static void main(String[] args) {
        try {
            TerminaleUtente serverUtente = new ServerUtente();
            TerminaleSportello serverSportello = new ServerSportello();
            TerminaleUfficio serverUfficio = new ServerUfficio();


            TerminaleUtente stubUtente = (TerminaleUtente) UnicastRemoteObject.exportObject(serverUtente,0);
            TerminaleSportello stubSportello = (TerminaleSportello) UnicastRemoteObject.exportObject(serverSportello,0);
            TerminaleUfficio stubUfficio = (TerminaleUfficio) UnicastRemoteObject.exportObject(serverUfficio,0);



            Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

            registry.bind("utente",stubUtente);
            registry.bind("sportello",stubSportello);
            registry.bind("ufficio",stubUfficio);

            System.err.println("codice.server.stubs.Server ready");

        }catch (RemoteException r){
            r.printStackTrace();
        }catch (AlreadyBoundException m){
            m.printStackTrace();
        }
    }
}
