package codice.dominio.ufficio;
//FACADE CONTROLLER

import codice.dominio.sportello.AbstractSportello;
import codice.dominio.utente.MonitorUtente;
import codice.dominio.sportello.MonitorSportellii;
import codice.dominio.sportello.StatoSportello;
import codice.sharedInterface.TerminaleUfficio;

import java.rmi.RemoteException;
import java.util.ArrayList;

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

    public boolean changeStato(int numeroSportello, StatoSportello statoSportello){
        return monitorSportellii.changeStato(numeroSportello,statoSportello);
    }

    public String creaSportello(int numeroSportello,IdServizio idServizio){
        return monitorSportellii.collegaSportello(numeroSportello,idServizio);
    }


    public int prenota(IdServizio idServizio) { // Aggiungere eccezione!
        return monitorUtente.prenota(idServizio);
    }

    public StatoSportello getStatoSportello(int numeroSportello){
        return monitorSportellii.getSportello(numeroSportello).getStato();
    }

    public IdServizio getServizioOfferto(int numeroSportello){
        return monitorSportellii.getSportello(numeroSportello).getServizioOfferto().getId();
    }

    public int getClienteInServizio(int numeroSportello){
        return monitorSportellii.getSportello(numeroSportello).getClienteInServizio().getNumero();
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


    @Override
    public String riceviAggiornameto() throws RemoteException {
        return null;
    }

    //@Override
    public String visualizzaStato() {
        return "Stato ufficio\n" +
                ListaServizi.getInstance()+ "\n" +
                monitorSportellii;
    }

    public ArrayList<IdServizio> idServiziOfferti(){
        ArrayList<IdServizio> idServizi=new ArrayList<>();

        for (Servizio s:ListaServizi.getInstance().getServizi()
             ) {
            idServizi.add(s.getId());
        }

        return idServizi;
    }

    public int getServizioNumProgr(IdServizio idServizio){
        return ListaServizi.getInstance().getServizio(idServizio).getCodaServizio().getNumeroProgressivo();
    }

    public int getPrenotazioniInCoda(IdServizio idServizio){
        return ListaServizi.getInstance().getServizio(idServizio).getCodaServizio().prenotazioniInCoda();
    }

    public ArrayList<AbstractSportello> getSportelli(){
        return monitorSportellii.getSportelli();
    }

    @Override
    public String toString() {
        return "codice.dominio.ufficio.Ufficio{" +
                "servizi=" + ListaServizi.getInstance() +
                ", monitorSportellii=" + monitorSportellii +
                '}';
    }
}
