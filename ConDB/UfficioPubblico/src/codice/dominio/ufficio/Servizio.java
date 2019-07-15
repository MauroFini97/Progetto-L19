package codice.dominio.ufficio;

import codice.dominio.utente.Prenotazione;
import codice.dominio.eccezioni.CodaVuotaException;

public class Servizio {
    private IdServizio id;
    private Coda codaServizio;

    public Servizio(IdServizio id) {
        this.id = id;
        this.codaServizio = new Coda();
    }

    public IdServizio getId() {
        return id;
    }

    public int getNumeroProgressivo(){
        return codaServizio.getNumeroProgressivo();
    }

    public Coda getCodaServizio() {
        return codaServizio;
    }

    public int prenota(){
        return codaServizio.prenota();
    }

    public Prenotazione prossimoCliente(){
        try {
            return codaServizio.prossimoDaServire();
        }catch (CodaVuotaException c){
            throw c;
        }
    }

    @Override
    public String toString() {
        return "------------------------\n"+
               "codice.dominio.ufficio.Servizio id: " +id +"\n"+
                codaServizio;
    }
}
