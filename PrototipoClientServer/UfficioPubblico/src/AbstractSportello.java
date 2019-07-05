/**
 * Classe astratta che rappresenta il comportamento comune dei tipi di sportelli possibili
 */

public abstract class AbstractSportello{//Applicare pattern template perche riceviprenot dello sportello variabile è simile all'altra
    //chiedere al prof
    /**
     * attributi
     * numeroSportello: rappresenta il numero identificativo dello sportello
     * stato: rappresenta lo stato dello sportello riferendosi all'enum StatoSportello
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
     * Metodo astratto che sarà definito nei tipi di sportelli in cui varia il modo di ricevere la prenotazione
     * @return
     */
    public Prenotazione riceviPrenotazione(){
        stato=StatoSportello.OCCUPATO;
        try {
            return servizioOfferto.prossimoCliente();
        }catch (CodaVuotaException c){
            return codaVuota();
        }
    }
    //public abstract Prenotazione riceviPrenotazione(IdServizio idServizio);

    public abstract Prenotazione codaVuota();

    /**
     * Cambia lo stato dello sportello, e, se LIBERO, chiamerà il metodo riceviPrenotazione()
     * @param stato
     */
    public String changeStato(StatoSportello stato){
        this.stato=stato;

        try {
        if(this.stato.equals(StatoSportello.LIBERO))
            clienteInServizio=riceviPrenotazione();

            return datiPerServer();
            //ritorna una stringa con [stato sportello] [spazio] [id Servizio offerto] [spazio] [numero cliente in servizio]
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

    public StatoSportello getStato() {
        return stato;
    }

    public Servizio getServizioOfferto() {
        return servizioOfferto;
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
