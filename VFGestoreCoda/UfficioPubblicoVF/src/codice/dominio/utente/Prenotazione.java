package codice.dominio.utente;

public class Prenotazione {
    private int numero;

    public Prenotazione(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "codice.dominio.utente.Prenotazione numero= "+ numero;
    }
}
