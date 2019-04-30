package servizio;

import java.util.ArrayList;

public class ServicesCreator {
    private ArrayList<Servizio> serviziOfferti;

    public ServicesCreator() {
        this.serviziOfferti= new ArrayList<>();
        inizializzaServizi();
    }

    private void inizializzaServizi(){
        serviziOfferti.add(new Servizio("Spedizioni e ritiro pacchi",ServicesList.SRP));
        serviziOfferti.add(new Servizio("Pagamento bollettini",ServicesList.PB));
        serviziOfferti.add(new Servizio("Ricarica postepay e cellulari",ServicesList.RPC));
        serviziOfferti.add(new Servizio("Operazioni sul conto postale",ServicesList.OCP));
        serviziOfferti.add(new Servizio("Cambio valuta",ServicesList.CV));
    }

    public ArrayList<Servizio> getServiziOfferti() {
        return serviziOfferti;
    }
}
