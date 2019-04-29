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

    public void setClienteInServizio(Prenotazione clienteInServizio) {
        this.clienteInServizio = clienteInServizio;
    }

    public Prenotazione getClienteInServizio() {
        return clienteInServizio;
    }

    public void setStato(StatusWindow stato) {
        this.stato = stato;
    }

    public abstract void riceviPrenotazione(Coda codaPrincipale);


    @Override
    public String toString() {
        return "sportelli.Sportello "+ ID + "\n" +
                stato+"\n" +
                clienteInServizio+"\n";
    }
}
