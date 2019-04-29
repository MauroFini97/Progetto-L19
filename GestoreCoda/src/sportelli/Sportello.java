package sportelli;

import coda.Coda;
import servizio.Prenotazione;

public abstract class Sportello {
    private String ID;
    private Prenotazione clienteInServizio;
    private StatusWindow stato;

    public Sportello(String ID) {
        this.ID = ID;
        this.stato = StatusWindow.LIBERO;
    }

    /*
    cliente in servizio rappresenta la prenotazione presa in carico dallo sportello
     */
    public void setClienteInServizio(Prenotazione clienteInServizio) {
        this.clienteInServizio = clienteInServizio;
    }

    public Prenotazione getClienteInServizio() {
        return clienteInServizio;
    }

    public void setStato(StatusWindow stato) {
        this.stato = stato;
    }

    /*
    acquisisce la prenotazione dalla coda principale dell'ufficio...è astratta perchè gli sportelli possono essere
    variabili o fissi e quindi questo metodo cambierebbe in base al tipo dello sportello
     */
    public abstract void riceviPrenotazione(Coda codaPrincipale);


    @Override
    public String toString() {
        return "sportelli.Sportello "+ ID + "\n" +
                stato+"\n" +
                clienteInServizio+"\n";
    }
}
