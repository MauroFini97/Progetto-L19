import java.util.Deque;
import java.util.LinkedList;

public class Coda {
    private Deque<Prenotazione> prenotazioni;
    private int numeroProgressivo;

    public Coda() {
        this.prenotazioni = new LinkedList<>();
        this.numeroProgressivo=0;
    }

    public int prenota(){
        this.numeroProgressivo++;
        this.prenotazioni.add(new Prenotazione(numeroProgressivo));
        return numeroProgressivo;
    }

    @Override
    public String toString() {
        return "Coda{" +
                "prenotazioni=" + prenotazioni +
                ", numeroProgressivo=" + numeroProgressivo +
                '}';
    }
}
