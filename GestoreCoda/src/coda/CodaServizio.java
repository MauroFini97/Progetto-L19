package coda;

import coda.Coda;
import servizio.Prenotazione;
import servizio.Servizio;

public class CodaServizio extends Coda {
    private Servizio servizio;

    public CodaServizio(Servizio servizio) {
        this.servizio = servizio;
    }


    @Override
    public boolean addPrenotazione(Prenotazione prenotazione) {
        if(prenotazione.getIdServizio().equals(servizio.getID()))
            return super.addPrenotazione(prenotazione);
        else
            return false;
    }
}
