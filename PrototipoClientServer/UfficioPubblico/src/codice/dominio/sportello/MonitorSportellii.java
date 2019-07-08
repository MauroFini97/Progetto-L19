package codice.dominio.sportello;

import codice.dominio.ufficio.IdServizio;
import codice.dominio.ufficio.ListaServizi;
import codice.sharedInterface.TerminaleSportello;

import java.util.ArrayList;

/**
 * Classe che rappresenta il monitoraggio e la gestione degli sportelli dell'ufficio pubblico
 */

public class MonitorSportellii implements TerminaleSportello {

    private static ArrayList<AbstractSportello> sportelli;

    public MonitorSportellii() {
        this.sportelli=new ArrayList<>();
    }

    /**
     * metodo che crea uno sportello a lo aggiunge alla lista degli sportelli
     * @param numeroSportello: numero identificativo dello sportello
     * @param tipo: variabile o fisso
     * @return numero dello sportello
     */
    public String creaSportello(int numeroSportello,String tipo){
        AbstractSportello sportello=null;

        switch (tipo){
            case "VARIABILE":sportello=new SportelloVariabile(numeroSportello);
            break;
            case "FISSO":sportello=new SportelloFisso(numeroSportello);
            break;
        }

        sportello.setServizioOfferto(ListaServizi.getInstance().getServizio(IdServizio.SRP));

        sportello.setStato(StatoSportello.LIBERO);

        sportelli.add(sportello);

        return "" + numeroSportello;

    }

    public void setServizioOffertoSportello(int numSportello,IdServizio idServizio){
        sportelli.get(numSportello).setServizioOfferto(ListaServizi.getInstance().getServizio(idServizio));
    }

    public String changeStato(int numeroSportello,StatoSportello statoSportello){
       return getSportello(numeroSportello).changeStato(statoSportello);
    }


    /**
     *
     * @param numeroSportello
     * @return lo sportello che ha come numero il parametro oppure "null" se non esiste lo sportello con qel numero
     */
    public AbstractSportello getSportello(int numeroSportello) {
        try {
            for (AbstractSportello s : sportelli
            ) {
                if (s.getNumeroSportello() == numeroSportello)
                    return s;
            }
        }catch(Exception e){
            System.err.println("Nessuno sportello con il numero: "+numeroSportello);
        }
        return null;
    }

    @Override
    public String toString() {
        return "codice.dominio.sportello.MonitorSportellii{" +
                "sportelli=" + this.sportelli +
                '}';
    }
}
