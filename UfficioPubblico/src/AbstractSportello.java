public abstract class AbstractSportello implements TerminaleSportello{
    private int numeroSportello;

    protected StatoSportello stato;
    protected Servizio servizioOfferto;

    public AbstractSportello(int numeroSportello) {
        this.numeroSportello = numeroSportello;
    }

    public void setServizioOfferto(Servizio servizioOfferto) {
        this.servizioOfferto = servizioOfferto;
    }

    public abstract Prenotazione riceviPrenotazione();
    //public abstract Prenotazione riceviPrenotazione(IdServizio idServizio);

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
