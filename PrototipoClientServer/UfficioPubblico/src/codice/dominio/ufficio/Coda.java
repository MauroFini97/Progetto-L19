package codice.dominio.ufficio;

import codice.dominio.utente.Prenotazione;
import codice.dominio.eccezioni.CodaVuotaException;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Classe che rappresenta una coda di prenotazione, e gestisce queste prenotazioni
 */
public class Coda {
    /**
     * atttributi
     * prenotazioni:Un array di prenotazioni gestito tramite logica FIFO utilizzando l'interfaccia Deque
     * numeroProgressivo: numero che rappresenta il numero di prenotazioni aggiunte alla coda
     */
    private Deque<Prenotazione> prenotazioni;
    private int numeroProgressivo;

    /**
     * Costruttore inizializza gli attributi
     */
    public Coda() {
        this.prenotazioni = new LinkedList<>();
        this.numeroProgressivo=0;
    }

    /**
     * se non ci sono prenotazioni in coda, cattura l'eccezione e ritorna 0
     * @return il numero di prenotazioni in coda
     */
    public int prenotazioniInCoda(){
        try {
            return prenotazioni.size();
        }catch (NoSuchElementException n){
            return 0;
        }
    }

    /**
     * Metodo che rappresenta un azione di prenotazione, viene aggiunta all'array e viene fatto aumentare il numeroProgressivo
     * @return il numeroProgressivo, cioè che numero di prenotazione è stata aggiunta
     */
    public int prenota(){
        this.numeroProgressivo++;
        this.prenotazioni.add(new Prenotazione(numeroProgressivo));
        return numeroProgressivo;
    }

    /**
     * rimuove la prenotazione in testa alla coda
     * se non ci sonop prenotazione cattura l'eccezione e stampa il masseggio di nessuna prenotazione
     * @return la prenotazione in testa alla coda
     */
    public Prenotazione prossimoDaServire(){
        try {
            return prenotazioni.removeFirst();
        }catch (Exception e){
            throw new CodaVuotaException();
        }
    }

    public int getNumeroProgressivo() {
        return numeroProgressivo;
    }

    @Override
    public String toString() {
        try {
            return "Prossimo numero da servire =" + prenotazioni.getFirst().getNumero() +
                    "\nNumero di prenotazioni =" + numeroProgressivo+"\n";
        }catch (NoSuchElementException e){
            return "NESSUNA PRENOTAZIONE\n";
        }
    }
}
