package codice.dominio.sportello;

import codice.dominio.utente.Prenotazione;
import codice.dominio.ufficio.Servizio;
import codice.dominio.eccezioni.CodaVuotaException;
import codice.dominio.eccezioni.NessunoDaServireException;

/**
 * Classe astratta che rappresenta il comportamento comune dei tipi di sportelli possibili
 */

public abstract class AbstractSportello{//pattern template
    /**
     * attributi
     * numeroSportello: rappresenta il numero identificativo dello sportello
     * clienteInServizio: rappresenta la prenotazione che si sta servendo
     * stato: rappresenta lo stato dello sportello riferendosi all'enum codice.dominio.sportello.StatoSportello
     * servizioOfferto: rappresenta il servizio che sta offrendo
     */
    private int numeroSportello;
    private Prenotazione clienteInServizio;
    private StatoSportello stato;

    protected Servizio servizioOfferto;

    /**
     * Costruisce lo sportello settando il suo numero identificativo
     * @param numeroSportello
     */
    public AbstractSportello(int numeroSportello) {
        this.numeroSportello = numeroSportello;
    }

    /**
     * Setta il servizio da offrire
     * @param servizioDaOffrire
     */
    public void setServizioOfferto(Servizio servizioDaOffrire) {
        this.servizioOfferto = servizioDaOffrire;
    }

    /**
     * Metodo che restituisce il prossimo cliente del servizio offerto in questo momento, e se non c'è nessuno, chiama
     * il metodo codaVuota che ha un implementazione diversa a seconda del tipo dello sportello
     * @return prossima prenotazione del servizio offerto
     */
    public Prenotazione riceviPrenotazione(){
        stato=StatoSportello.OCCUPATO;
        try {
            return servizioOfferto.prossimoCliente();
        }catch (CodaVuotaException c){
            return codaVuota();
        }
    }

    public abstract Prenotazione codaVuota();

    /**
     * Cambia lo stato dello sportello, e, se LIBERO, chiamerà il metodo riceviPrenotazione()
     * @param stato
     *
     * @return dati per i client che richiamano questo metodo con tutte le informazioni necessaria
     * ritorna una stringa con [stato sportello] [spazio] [id codice.dominio.ufficio.Servizio offerto] [spazio] [numero cliente in servizio]
     */
    public String changeStato(StatoSportello stato){
        this.stato=stato;

        try {
        if(this.stato.equals(StatoSportello.LIBERO))
            clienteInServizio=riceviPrenotazione();

            return datiPerServer();
            //ritorna una stringa con [stato sportello] [spazio] [id codice.dominio.ufficio.Servizio offerto] [spazio] [numero cliente in servizio]
        }catch (NessunoDaServireException n){
            return "NESSUNO IN CODA";
        }
    }

    public String datiPerServer(){
        return stato + " " + servizioOfferto.getId()+" "+clienteInServizio.getNumero();
    }


    public int getNumeroSportello() {
        return numeroSportello;
    }

    public void setStato(StatoSportello stato) {
        this.stato = stato;
    }



    @Override
    public String toString() {
        return "numeroSportello=" + numeroSportello +
                ", stato=" + stato +
                ", servizioOfferto=" + servizioOfferto;
    }
}
