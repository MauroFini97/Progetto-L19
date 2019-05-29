import java.util.ArrayList;

public class ListaServizi {//si potrebbe applicare un pattern perchè questo oggetto sta in mezzo ad ufficio e monitor sportelli
    //pattern SINGLETON
    private static ListaServizi istanza;

    private ArrayList<Servizio> servizi;

    private ListaServizi() {
        this.servizi = new ArrayList<>();
        inizializzaServizi();
    }

    public static ListaServizi getInstance(){
        if(istanza==null) {
            istanza = new ListaServizi();
        }

        return istanza;
    }

    private void inizializzaServizi(){
        servizi= new ServiceCreator().getServiziOfferti();
    }


    public int prenota(IdServizio idServizio) { // Aggiungere eccezione!
        return this.getServizio(idServizio).prenota();
    }

    public Servizio getServizio(IdServizio idServizio){
        for (Servizio s:servizi
             ) {
            if(s.getId().equals(idServizio))
                return s;
        }
        return null;
    }

    public ArrayList<Servizio> getServizi() {
        return servizi;
    }

    @Override
    public String toString() {
        return "ListaServizi{" +
                "servizi=" + servizi +
                '}';
    }
}
