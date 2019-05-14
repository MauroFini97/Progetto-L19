package sportelli;

import coda.Coda;
import sportelli.Sportello;

public class SportelloVariabile extends Sportello {

    public SportelloVariabile(String ID) {
        super(ID);
    }


    /*
    acquisisce la prenotazione dalla coda principale, setta lo stato dello sportello a OCCUPATO
    e rimuove la prenotazione dalla coda principale
     */
    @Override
    public void riceviPrenotazione(Coda codaPrincipale) {
        this.setClienteInServizio(codaPrincipale.getFirstPrenotazione());
        this.setStato(StatusWindow.OCCUPATO);
        codaPrincipale.rmvPrenotazione(this.getClienteInServizio());
    }

    public void clienteServito(){
        this.setStato(StatusWindow.LIBERO);
        this.setClienteInServizio(null);
    }
}
