package codice.dominio.ufficio;
//FACADE CONTROLLER

import codice.dominio.utente.MonitorUtente;
import codice.dominio.sportello.MonitorSportellii;
import codice.dominio.sportello.StatoSportello;
import codice.sharedInterface.TerminaleUfficio;

/**
 * Classe che rappresenta il facade controller dell'applicazione, quindi richiamerà metodi di altre classi(non viene implementato
 * nulla)
 * pattern: Facade Controller
 */
public class Ufficio implements TerminaleUfficio {
    private MonitorSportellii monitorSportellii;
    private MonitorUtente monitorUtente;

    /**
     * il numero degli sportelli e il numero di sportelli variabili/fissi è inizializzato
     * dalla classe MonitorSportelli,vedere quella
     */
    public Ufficio() {
        this.monitorUtente=new MonitorUtente();
        this.monitorSportellii=new MonitorSportellii();
    }

    public void setServizioOffertoSportello(int numSportello, IdServizio idServizio){
        monitorSportellii.setServizioOffertoSportello(numSportello,idServizio);
    }

    public String changeStato(int numeroSportello, StatoSportello statoSportello){
        return monitorSportellii.changeStato(numeroSportello,statoSportello);
    }

    public String creaSportello(int numeroSportello,String tipo){
        return monitorSportellii.creaSportello(numeroSportello,tipo);
    }


    public int prenota(IdServizio idServizio) { // Aggiungere eccezione!
        return monitorUtente.prenota(idServizio);
    }

    @Override
    public String visualizzaStato() {
        return "Stato ufficio\n" +
                ListaServizi.getInstance()+ "\n" +
                monitorSportellii;
    }

    @Override
    public String toString() {
        return "codice.dominio.ufficio.Ufficio{" +
                "servizi=" + ListaServizi.getInstance() +
                ", monitorSportellii=" + monitorSportellii +
                '}';
    }
}
