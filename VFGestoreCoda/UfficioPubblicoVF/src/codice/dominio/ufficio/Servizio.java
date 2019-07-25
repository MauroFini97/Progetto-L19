package codice.dominio.ufficio;

import codice.dominio.utente.Prenotazione;
import codice.dominio.eccezioni.CodaVuotaException;

public class Servizio {
    private IdServizio id;
    private Coda codaServizio;
    private int costanteDiAttesa;

    public Servizio(IdServizio id) {
        this.id = id;
        this.codaServizio = new Coda();
        settaCostanteMinuti(id);
    }

    public IdServizio getId() {
        return id;
    }

    public void setnumProg(int num){
        codaServizio.setNumeroProgressivo(num);
    }

    public void settaPrenotazioniInCoda(int numeroPrenInCoda){
        codaServizio.settaPrenotazioniInCoda(numeroPrenInCoda);
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

    private void settaCostanteMinuti(IdServizio idServizio){
            switch (idServizio){
                case SRP:this.costanteDiAttesa=15;
                    break;
                case CV:this.costanteDiAttesa=5;
                    break;
                case PB:this.costanteDiAttesa=7;
                    break;
                case OCP:this.costanteDiAttesa=5;
                    break;
                case RPC:this.costanteDiAttesa=10;
                    break;
                    default:this.costanteDiAttesa=15;
            }
    }

    public int minutiMediDiAttesa(){
        return this.costanteDiAttesa*codaServizio.prenotazioniInCoda();
    }


}
