/**
 * Classe che rappresenta un tipo di sportello che non varia il servizioOfferto
 */
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
