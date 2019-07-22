/**
 * Classe astratta che rappresenta il comportamento comune dei tipi di sportelli possibili
 */

public abstract class AbstractSportello implements TerminaleSportello{//Applicare pattern template perche riceviprenot dello sportello variabile è simile all'altra
    //chiedere al prof
    /**
     * attributi
     * numeroSportello: rappresenta il numero identificativo dello sportello
     * stato: rappresenta lo stato dello sportello riferendosi all'enum StatoSportello
     * servizioOfferto: rappresenta il servizio che sta offrendo
     */
    private int numeroSportello;
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
     * Metodo astratto che sarà definito nei tipi di sportelli in cui varia il modo di ricevere la prenotazione
     * @return
     */
    public Prenotazione riceviPrenotazione(){
        changeStato(StatoSportello.OCCUPATO);
        return servizioOfferto.prossimoCliente();
    }
    //public abstract Prenotazione riceviPrenotazione(IdServizio idServizio);

    /**
     * Cambia lo stato dello sportello, e, se LIBERO, chiamerà il metodo riceviPrenotazione()
     * @param stato
     */
    public void changeStato(StatoSportello stato){
        this.stato=stato;

        if(this.stato==StatoSportello.LIBERO)
            riceviPrenotazione();
    }

    @Override
    public String toString() {
        return "numeroSportello=" + numeroSportello +
                ", stato=" + stato +
                ", servizioOfferto=" + servizioOfferto;
    }
}
