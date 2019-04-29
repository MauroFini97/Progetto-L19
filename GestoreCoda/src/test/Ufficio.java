package test;

import coda.Coda;
import servizio.Prenotazione;
import servizio.Servizio;
import sportelli.Sportello;
import sportelli.SportelloVariabile;
import user.UserInterface;

import java.util.ArrayList;

/*
classe principale del software
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
        inizializzaSportelli();
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
    public void prenota(String idServizio) {
        codaPrincipale.addPrenotazione(new Prenotazione(idServizio));
    }


    @Override
    public String toString() {
        return "nomeUfficio: " + nomeUfficio +"\n" +
                "STATO CODA "+ "\n" +
                codaPrincipale;

    }
}
