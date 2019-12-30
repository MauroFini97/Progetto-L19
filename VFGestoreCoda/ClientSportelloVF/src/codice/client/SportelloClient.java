package codice.client;

import codice.dominio.sportello.StatoSportello;
import codice.dominio.ufficio.IdServizio;
import codice.sharedInterface.TerminaleSportello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SportelloClient {

    private String host;
    private int numeroSportello;
    //private String tipo;

    private StatoSportello stato;
    private IdServizio servizioOfferto;
    private int numeroClienteInServizio;

    public SportelloClient(int numeroSportello) {
        this.numeroSportello = numeroSportello;

        //settaTipo(numeroSportello);

    }

    public int getNumeroSportello() {
        return numeroSportello;
    }

    public StatoSportello getStato() {
        return stato;
    }

    public IdServizio getServizioOfferto() {
        return servizioOfferto;
    }

    public int getNumeroClienteInServizio() {
        return numeroClienteInServizio;
    }

    /*private void settaTipo(int numeroSportello){
        switch (numeroSportello){
            case 0:case 1:this.tipo="FISSO";
                break;
            case 2:case 3:case 4:case 5:this.tipo="VARIABILE";
                break;
        }
    }*/

    public String collegaAlServer(String hostServer){
        this.host=hostServer;

        System.err.println("ATTENDI LA CONNESSIONE AL SERVER");

        try {
            Registry registry = LocateRegistry.getRegistry(host);
            TerminaleSportello stubSportello = (TerminaleSportello) registry.lookup("sportello");
            String messaggioServer=null;

            switch(numeroSportello){
                case 0: messaggioServer= stubSportello.collegaSportello(numeroSportello, IdServizio.SRP);
                break;
                case 1: messaggioServer= stubSportello.collegaSportello(numeroSportello,IdServizio.OCP);
                break;
                case 2: case 3: case 4: case 5:messaggioServer= stubSportello.collegaSportello(numeroSportello,IdServizio.RPC);
                break;
            }

            return messaggioServer;
            //return "NUMERO SPORTELLO NON TROVATO";

        }catch (Exception e){
            e.printStackTrace();
            return "NON COLLEGATO:RIAVVIARE";
        }
    }


    public void cambiaStato(StatoSportello stato){
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            TerminaleSportello stubSportello = (TerminaleSportello) registry.lookup("sportello");

            if(stubSportello.changeStato(numeroSportello, stato))
                riceviDati();
            else numeroClienteInServizio=-1;


        }catch (Exception e){
            //e.printStackTrace();
            System.err.println("NON COLLEGATO AL SERVER, RICOLLEGAMENTO IN CORSO..");
            System.err.println(collegaAlServer(host));
        }
    }

    private void riceviDati(){
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            TerminaleSportello stubSportello = (TerminaleSportello) registry.lookup("sportello");

            stato=stubSportello.getStatoSportelloPerServer(numeroSportello);
            servizioOfferto=stubSportello.getIdServizioOffertoSportelloPerServer(numeroSportello);
            numeroClienteInServizio=stubSportello.getNumeroClienteSportelloPerServer(numeroSportello);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "SportelloClient{" +
                "numeroSportello=" + numeroSportello +
                ", stato=" + stato +
                ", servizioOfferto=" + servizioOfferto +
                ", numeroClienteInServizio=" + numeroClienteInServizio +
                '}';
    }
}
