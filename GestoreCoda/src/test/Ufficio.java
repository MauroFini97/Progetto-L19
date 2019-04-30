package test;

import coda.Coda;
import servizio.Prenotazione;
import servizio.ServicesCreator;
import servizio.ServicesList;
import servizio.Servizio;
import sportelli.Sportello;
import sportelli.SportelloVariabile;
import user.UserInterface;

import java.util.ArrayList;

/*
classe principale del software

quando creo l'ufficio vengono inizializzati gli sportelli e i servizi offerti(facendo riferimento all'enum ServicesList)

NOTA:per inizializzare i servizi si potrebbe creare una classe apposita(ad es. servicesCreator) in cui all'interno
si crea un vettore con tutti i servizi offerti già inizializzati e che poi si passa a questa classe
 */

public class Ufficio implements UserInterface {
    private String nomeUfficio;
    private Coda codaPrincipale;
    private int numSportelli;
    private ArrayList<Sportello> sportelli;
    private ArrayList<Servizio> servizi;


    public Ufficio(String nomeUfficio,int numSportelli) {
        this.nomeUfficio = nomeUfficio;
        this.numSportelli=numSportelli;
        this.codaPrincipale = new Coda();
        this.sportelli= new ArrayList<>();
        this.servizi=new ArrayList<>();
        inizializzaServiziOfferti();
        inizializzaSportelli();
    }

    private void inizializzaServiziOfferti(){
        ServicesCreator servicesCreator = new ServicesCreator();
        servizi=servicesCreator.getServiziOfferti();
    }

    private String stampaListaServiziOfferti(){
        return "LISTA SERVIZI OFFERTI\n" +
                "-------------------------------\n"+
                "SRP:SPEDIZIONE E RITIRO PACCHI\n" +
                "PB: PAGAMENTO BOLLETTINI\n" +
                "RPC:RICARICA POSTEPAY E CELLULARI\n" +
                "OCP:OPERAZIONI SUL CONTO POSTALE\n" +
                "CV:CAMBIO VALUTA\n" +
                "-------------------";
    }

    public void addServizioOfferto(Servizio servizio){
        servizi.add(servizio);
    }

    public Coda getCodaPrincipale() {
        return codaPrincipale;
    }

    private void inizializzaSportelli(){
        for(int i=0;i<numSportelli;i++){
            this.sportelli.add(new SportelloVariabile("i"));
        }
    }

    @Override
    public void prenota(ServicesList idServizio) {
        codaPrincipale.addPrenotazione(new Prenotazione(idServizio));
    }


    @Override
    public String toString() {
        return "nomeUfficio: " + nomeUfficio +"\n" +
                stampaListaServiziOfferti()+"\n" +
                "STATO CODA "+ "\n" +
                codaPrincipale;

    }
}
