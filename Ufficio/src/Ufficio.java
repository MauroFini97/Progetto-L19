import java.util.ArrayList;

public class Ufficio implements TerminaleUtente{
    private ArrayList<Servizio> servizi;

    public Ufficio() {
        inizializzaServizi();
    }

    private void inizializzaServizi(){
       servizi= new ServiceCreator().getServiziOfferti();
    }

    @Override
    public int prenota(IdServizio idServizio) { // Aggiungere eccezione!
        for (Servizio s:servizi
             ) {
            if(s.getId().equals(idServizio))
                return s.prenota();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Ufficio{" +
                "servizi=" + servizi +
                '}';
    }
}
