import java.util.ArrayList;

public class MonitorSportellii { //Applicare singleton
    private ArrayList<Servizio> servizi;
    private ArrayList<AbstractSportello> sportelli;
    private int NUMERO_SPORTELLI;

    public MonitorSportellii(int numSportelli) {
        this.NUMERO_SPORTELLI=numSportelli;
        this.sportelli=new ArrayList<>();

        for (int i=0;i<NUMERO_SPORTELLI;i++){
            sportelli.add(new SportelloFisso(i));

        }

    }

    public void setServizi(ArrayList<Servizio> servizi) {
        this.servizi = servizi;
    }

    public void setServizioOffertoSportello(int numSportello,IdServizio idServizio){
        Servizio servizioDaOffrire=null;
        for (Servizio s: servizi
             ) {
            if(s.getId()==idServizio)
                servizioDaOffrire=s;
        }

        sportelli.get(numSportello).setServizioOfferto(servizioDaOffrire);
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
