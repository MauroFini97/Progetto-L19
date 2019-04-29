package coda;

import servizio.Prenotazione;

import java.util.ArrayList;

public class Coda {
    private ArrayList<Prenotazione> codaPrenotazioni;
    private int numeroProgressivo;

    public Coda() {
        this.codaPrenotazioni= new ArrayList<>();
        this.numeroProgressivo=0;
    }

    public boolean addPrenotazione(Prenotazione prenotazione){
        prenotazione.setNumeroProgressivo(numeroProgressivo);
        numeroProgressivo++;
        return codaPrenotazioni.add(prenotazione);
    }

    public boolean rmvPrenotazione(Prenotazione prenotazione){
        return codaPrenotazioni.remove(prenotazione);
    }

    public Prenotazione getFirstPrenotazione(){
        return codaPrenotazioni.get(0);
    }

    @Override
    public String toString() {
        return "NUMERO = "+ numeroProgressivo+"\n" +
                "--------------------------\n" +
                codaPrenotazioni;
    }
}
