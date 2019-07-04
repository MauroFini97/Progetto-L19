import java.util.ArrayList;

public class SportelloVariabile extends AbstractSportello {
/*
questo tipo di sportello deve accedere alla lista servizi(che quindi forse dovrà essere una
sorta di database o una classe realizzata con il singleton), altrimenti bisognerebbe mettere
come attributo una lista servizi e ricavarla con un metodo get dal monitor sportelli e quindi creare un associazione
in piu
 */

    public SportelloVariabile(int numeroSportello) {
        super(numeroSportello);
    }


    /**
     * Algoritmo che, se il servizio che sta offrendo lo sportello ha ancora una coda di prenotazioni serve il prossimo
     * cliente di quel servizio, altrimenti, implementa un algoritmo che itera tutte le code prenotazioni dei
     * servizi in quel momento e setta il servizio che offre in base a quello che ha più prenotazioni in coda
     * e lo setta
     * @return il metodo di riceviprenotazione() della classe madre
     */
    @Override
    public Prenotazione codaVuota() {
        Servizio servizioScelto;
        ArrayList<Servizio> serviziPossibili;
        serviziPossibili=ListaServizi.getInstance().getServizi();
        servizioScelto=serviziPossibili.get(0);

        for (Servizio s:serviziPossibili
             ) {
            if(s.getCodaServizio().prenotazioniInCoda() >
            servizioScelto.getCodaServizio().prenotazioniInCoda()){
                servizioScelto=s;
            }
        }

        this.setServizioOfferto(servizioScelto);

        return servizioScelto.prossimoCliente();
    }
}
