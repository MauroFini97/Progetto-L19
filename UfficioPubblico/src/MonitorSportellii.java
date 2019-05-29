import java.util.ArrayList;

public class MonitorSportellii { //Applicare singleton
    //private ListaServizi listaServizi;
    private ArrayList<AbstractSportello> sportelli;
    //private int NUMERO_SPORTELLI_FISSI,NUMERO_SPORTELLI_VARIABILI;

    public MonitorSportellii() {
        inizializzaSportelli(1,1);
    }

    private void inizializzaSportelli(int numSportellifissi,int numSportelliVariabili){
        //this.NUMERO_SPORTELLI_FISSI=numSportellifissi;
        //this.NUMERO_SPORTELLI_VARIABILI=numSportelliVariabili;
        this.sportelli=new ArrayList<>();

        for (int i=0;i<numSportellifissi;i++){
            sportelli.add(new SportelloFisso(sportelli.size()));
        }

        for (int i=0;i<numSportelliVariabili;i++){
            sportelli.add(new SportelloVariabile(sportelli.size()));
        }
    }

    /*public void setServizi(ListaServizi listaServizi) {
        this.listaServizi=listaServizi;
    }*/

    public void setServizioOffertoSportello(int numSportello,IdServizio idServizio){
        sportelli.get(numSportello).setServizioOfferto(ListaServizi.getInstance().getServizio(idServizio));
    }

    public void changeStato(int numeroSportello,StatoSportello statoSportello){
        sportelli.get(numeroSportello).changeStato(statoSportello);
    }


    @Override
    public String toString() {
        return "MonitorSportellii{" +
                "sportelli=" + sportelli +
                '}';
    }
}
