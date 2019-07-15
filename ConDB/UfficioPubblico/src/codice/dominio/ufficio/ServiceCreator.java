package codice.dominio.ufficio;

import java.util.ArrayList;

/**
 * Classe che è utilizzato una sola volta per creare i servizi offerti dall'ufficio pubblico
 * pattern: pure fabrication
 */
public class ServiceCreator {
    private ArrayList<Servizio> serviziOfferti;

    public ServiceCreator() {
        this.serviziOfferti= new ArrayList<>();
        inizializzaServizi();
    }

    private void inizializzaServizi(){
        serviziOfferti.add(new Servizio(IdServizio.SRP));
        serviziOfferti.add(new Servizio(IdServizio.PB));
        serviziOfferti.add(new Servizio(IdServizio.RPC));
        serviziOfferti.add(new Servizio(IdServizio.OCP));
        serviziOfferti.add(new Servizio(IdServizio.CV));
    }

    public ArrayList<Servizio> getServiziOfferti() {
        return serviziOfferti;
    }
}
