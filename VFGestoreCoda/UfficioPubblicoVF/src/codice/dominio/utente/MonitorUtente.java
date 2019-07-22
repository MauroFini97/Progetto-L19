package codice.dominio.utente;

import codice.dominio.ufficio.IdServizio;
import codice.dominio.ufficio.ListaServizi;
import codice.sharedInterface.TerminaleUtente;

public class MonitorUtente{



    /**
     *
     * @param idServizio
     * @return il numero di prenotazione del servizio scelto tramite l'id come parametro
     */
    public int prenota(IdServizio idServizio) {
        return ListaServizi.getInstance().prenota(idServizio);
    }
}
