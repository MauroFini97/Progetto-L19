
//FACADE CONTROLLER

/**
 * Classe che rappresenta il facade controller dell'applicazione, quindi richiamerà metodi di altre classi(non viene implementato
 * nulla)
 * pattern: Facade Controller
 */
public class Ufficio implements TerminaleUfficio{
    private MonitorSportellii monitorSportellii;
    private MonitorUtente monitorUtente;
    //private ListaServizi listaServizi;

    /**
     * il numero degli sportelli e il numero di sportelli variabili/fissi è inizializzato
     * dalla classe MonitorSportelli,vedere quella
     */
    public Ufficio() {
        this.monitorUtente=new MonitorUtente();
        this.monitorSportellii=new MonitorSportellii();
        //inizializzaServizi();
        //inizializzaSportelli();
    }

    /*private void inizializzaServizi(){
       listaServizi=new ListaServizi();
    }*/
    /*private void inizializzaSportelli(){
        monitorSportellii=new MonitorSportellii(1,1);
        monitorSportellii.setServizi(this.listaServizi);
    }*/


    public void setServizioOffertoSportello(int numSportello, IdServizio idServizio){
        monitorSportellii.setServizioOffertoSportello(numSportello,idServizio);
    }

    public void changeStato(int numeroSportello,StatoSportello statoSportello){
        monitorSportellii.changeStato(numeroSportello,statoSportello);
    }


    public int prenota(IdServizio idServizio) { // Aggiungere eccezione!
        return monitorUtente.prenota(idServizio);
    }

    @Override
    public String visualizzaStato() {
        return "Stato ufficio\n" +
                ListaServizi.getInstance();
    }

    @Override
    public String toString() {
        return "Ufficio{" +
                "servizi=" + ListaServizi.getInstance() +
                ", monitorSportellii=" + monitorSportellii +
                '}';
    }
}
