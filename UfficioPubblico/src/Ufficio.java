import java.util.ArrayList;

public class Ufficio implements TerminaleUtente{ //Applicare singleton
    private ArrayList<Servizio> servizi;
    private MonitorSportellii monitorSportellii;

    public Ufficio() {
        inizializzaServizi();
        inizializzaSportelli();
    }

    private void inizializzaServizi(){
       servizi= new ServiceCreator().getServiziOfferti();
    }
    private void inizializzaSportelli(){
        monitorSportellii=new MonitorSportellii(2);
        monitorSportellii.setServizi(this.servizi);
    }

    public void setServizioOffertoSportello(int numSportello,IdServizio idServizio){
        monitorSportellii.setServizioOffertoSportello(numSportello,idServizio);
    }

    public void changeStato(int numeroSportello,StatoSportello statoSportello){
        monitorSportellii.changeStato(numeroSportello,statoSportello);
    }

    @Override
    public int prenota(IdServizio idServizio) { // Aggiungere eccezione!
        for (Servizio s:servizi
             ) {
            if(s.getId().equals(idServizio))
                return s.prenota();
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Ufficio{" +
                "servizi=" + servizi +
                ", monitorSportellii=" + monitorSportellii +
                '}';
    }
}
