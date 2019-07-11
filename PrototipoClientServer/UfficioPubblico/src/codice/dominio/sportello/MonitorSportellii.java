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
        inizializzaSportelli(2,3);
    }

    /**
     * NOTA: LO sportello fisso numero 0 offre SRP
     * Lo sportello fisso numero 1 offre OCP
     *
     * @param numSportellifissi
     * @param numSportelliVariabili
     */
    private void inizializzaSportelli(int numSportellifissi,int numSportelliVariabili){
        this.sportelli=new ArrayList<>();

        for (int i=0;i<numSportellifissi;i++){
            sportelli.add(new SportelloFisso(sportelli.size()));
        }

        for (int i=0;i<numSportelliVariabili;i++){
            sportelli.add(new SportelloVariabile(sportelli.size()));
        }
    }



    /**
     * metodo che collega uno sportello al server da un client
     * all'inizio c'è un controllo che setterà le caratteristiche a seconda di un "tipo"
     *
     * @param numeroSportello: numero identificativo dello sportello
     * @param tipo: variabile o fissosrp o fissoocp
     * @return messaggio per il client
     */
    public String collegaSportello(int numeroSportello,String tipo){

        switch (tipo){
            case "VARIABILE":
            break;
            case "FISSOSRP":getSportello(numeroSportello).setServizioOfferto(ListaServizi.getInstance().getServizio(IdServizio.SRP));
            break;
            case "FISSOOCP":getSportello(numeroSportello).setServizioOfferto(ListaServizi.getInstance().getServizio(IdServizio.OCP));
        }

        //getSportello(numeroSportello).setServizioOfferto(ListaServizi.getInstance().getServizio(IdServizio.SRP));

        //getSportello(numeroSportello).setStato(StatoSportello.LIBERO);

        return "sportello numero "+numeroSportello+" di tipo "+tipo+" collegato";

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

    public static ArrayList<AbstractSportello> getSportelli() {
        return sportelli;
    }

    @Override
    public String toString() {
        return "codice.dominio.sportello.MonitorSportellii{" +
                "sportelli=" + this.sportelli +
                '}';
    }
}
