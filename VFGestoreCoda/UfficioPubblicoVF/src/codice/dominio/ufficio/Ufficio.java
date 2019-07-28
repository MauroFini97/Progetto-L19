package codice.dominio.ufficio;
//FACADE CONTROLLER

import codice.dominio.utente.MonitorUtente;
import codice.dominio.sportello.MonitorSportellii;
import codice.dominio.sportello.StatoSportello;


/**
 * Classe che rappresenta il facade controller dell'applicazione, quindi richiamerà metodi di altre classi(non viene implementato
 * nulla)
 * pattern: Facade Controller
 */
public class Ufficio {
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


    public boolean changeStato(int numeroSportello, StatoSportello statoSportello){
        return monitorSportellii.changeStato(numeroSportello,statoSportello);
    }

    public String creaSportello(int numeroSportello,IdServizio idServizio){
        return monitorSportellii.collegaSportello(numeroSportello,idServizio);
    }


    public int prenota(IdServizio idServizio) { // Aggiungere eccezione!
        return monitorUtente.prenota(idServizio);
    }



    public StatoSportello getStatoSportelloPerServer(int numeroSportello){
        return monitorSportellii.getStatoSportello(numeroSportello);
    }

    public int getNumeroClienteSportelloPerServer(int numeroSportello){
        return monitorSportellii.getNumeroClienteSportello(numeroSportello);
    }

    public IdServizio getIdServizioOffertoSportelloPerServer(int numeroSportello){
        return monitorSportellii.getIdServizioOffertoSportello(numeroSportello);
    }

    public void restoreServizi(){
        ListaServizi.getInstance().restoreServizi();
    }

    public void inizializzaServizi(){
        ListaServizi.getInstance().inizializzaServizi();
    }



    public int getServizioNumProgr(IdServizio idServizio){
        return ListaServizi.getInstance().getServizio(idServizio).getCodaServizio().getNumeroProgressivo();
    }

    public int getPrenotazioniInCoda(IdServizio idServizio){
        return ListaServizi.getInstance().getServizio(idServizio).getCodaServizio().prenotazioniInCoda();
    }

    @Override
    public String toString() {
        return "codice.dominio.ufficio.Ufficio{" +
                "servizi=" + ListaServizi.getInstance() +
                ", monitorSportellii=" + monitorSportellii +
                '}';
    }
}
