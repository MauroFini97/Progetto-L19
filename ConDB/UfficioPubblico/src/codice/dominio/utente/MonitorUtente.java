package codice.dominio.utente;

import codice.dominio.ufficio.IdServizio;
import codice.dominio.ufficio.ListaServizi;
import codice.sharedInterface.TerminaleUtente;

public class MonitorUtente implements TerminaleUtente {



    /**
     *
     * @param idServizio
     * @return il numero di prenotazione del servizio scelto tramite l'id come parametro
     */
    @Override
    public int prenota(IdServizio idServizio) {
        return ListaServizi.getInstance().prenota(idServizio);
    }
}
