package servizio;

public class Prenotazione {
    private int numeroProgressivo;
    private String idServizio;

    public Prenotazione(String id) {
        this.idServizio=id;
    }

    public void setNumeroProgressivo(int numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
    }


    public String getIdServizio() {
        return idServizio;
    }

    @Override
    public String toString() {
        return "numero prenotazione = "+numeroProgressivo+" || ID servizio.Servizio scelto = "+idServizio+"\n";
    }
}
