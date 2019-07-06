import java.util.ArrayList;

/**
 * Classe che rappresenta il monitoraggio e la gestione degli sportelli dell'ufficio pubblico
 */

public class MonitorSportellii implements TerminaleSportello{
    //private ListaServizi listaServizi;
    private static ArrayList<AbstractSportello> sportelli;
    //private int numSportelliAperti;
    //private int NUMERO_SPORTELLI_FISSI,NUMERO_SPORTELLI_VARIABILI;

    public MonitorSportellii() {
        this.sportelli=new ArrayList<>();
        //this.numSportelliAperti=0;
        //inizializzaSportelli(2,3);
    }

    /*/**
     * inizializza gli sportelli, prima quelli che hanno comportamento fisso, poi quelli che hanno comportamento variabile
     * tramite i parametri
     * @param numSportellifissi
     * @param numSportelliVariabili
     */
    /*private void inizializzaSportelli(int numSportellifissi,int numSportelliVariabili){
        //this.NUMERO_SPORTELLI_FISSI=numSportellifissi;
        //this.NUMERO_SPORTELLI_VARIABILI=numSportelliVariabili;
        this.sportelli=new ArrayList<>();

        for (int i=0;i<numSportellifissi;i++){
            sportelli.add(new SportelloFisso(sportelli.size()));
        }

        for (int i=0;i<numSportelliVariabili;i++){
            sportelli.add(new SportelloVariabile(sportelli.size()));
        }
    }*/

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

        //String numeroSportello = String.valueOf(numSportelliAperti);

        //numSportelliAperti++;

        return "" + numeroSportello;

    }

    /*public void setServizi(ListaServizi listaServizi) {
        this.listaServizi=listaServizi;
    }*/

    public void setServizioOffertoSportello(int numSportello,IdServizio idServizio){
        sportelli.get(numSportello).setServizioOfferto(ListaServizi.getInstance().getServizio(idServizio));
    }

    public String changeStato(int numeroSportello,StatoSportello statoSportello){
       return sportelli.get(numeroSportello).changeStato(statoSportello);
    }

    public ArrayList<AbstractSportello> getSportelli() {
        return sportelli;
    }

    @Override
    public String toString() {
        return "MonitorSportellii{" +
                "sportelli=" + this.sportelli +
                '}';
    }
}
