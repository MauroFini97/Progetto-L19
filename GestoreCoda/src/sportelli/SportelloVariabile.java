package sportelli;

import coda.Coda;
import sportelli.Sportello;

public class SportelloVariabile extends Sportello {

    public SportelloVariabile(String ID) {
        super(ID);
    }

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
