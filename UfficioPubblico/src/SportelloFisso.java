public class SportelloFisso extends AbstractSportello {


    public SportelloFisso(int numeroSportello) {
        super(numeroSportello);
    }

    @Override
    public Prenotazione riceviPrenotazione() {
        changeStato(StatoSportello.OCCUPATO);
       return servizioOfferto.prossimoCliente();
    }


}
