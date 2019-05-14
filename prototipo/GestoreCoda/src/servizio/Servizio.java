package servizio;

import coda.CodaServizio;
import servizio.Prenotazione;

public class Servizio {
    private String nome;
    private ServicesList ID;
    private CodaServizio coda;


    public Servizio(String nome,ServicesList id) {
        this.nome = nome;
        this.ID = id;
        this.coda = new CodaServizio(this);
    }

    public ServicesList getID() {
        return ID;
    }

    /*
    metodo non usato in V1.0.....Come gestire la coda? i servizi hanno la coda oppure i vari sportelli?
     */
    public void addPrenotazione(Prenotazione prenotazione){
        coda.addPrenotazione(prenotazione);
    }


    @Override
    public String toString() {
        return " "+" "+ ID;
    }
}
