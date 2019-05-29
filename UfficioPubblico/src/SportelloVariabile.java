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

    @Override
    public Prenotazione riceviPrenotazione() {
        ArrayList<Servizio> serviziPossibili;
        serviziPossibili=ListaServizi.getInstance().getServizi();


        return null;
    }
}
