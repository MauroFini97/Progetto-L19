package servizio;

public class Prenotazione {
    private int numeroProgressivo;
    private ServicesList idServizio;

    public Prenotazione(ServicesList idServizio) {
        this.idServizio=idServizio;
    }

    public void setNumeroProgressivo(int numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
    }


    public ServicesList getIdServizio() {
        return idServizio;
    }

    @Override
    public String toString() {
        return "numero prenotazione = "+numeroProgressivo+" || Servizio scelto = "+idServizio+"\n";
    }
}
