package codice.dominio.ufficio;


import codice.database.IServizioDAO;
import codice.database.ServiziordbDao;

import java.util.ArrayList;

/**
 * Classe che rappresenta i servizi offerti dall'ufficio pubblico con le loro relative code
 * è una classe ad una sola istanza utilizzando il pattern singleton, così facendo le classi
 * che devono accedere a questa non devono necessariamente averla come attributo.
 * E in più,l'accesso a questa classe avviene da più punti del sistema, quindi risulta più funzionale l'uso del singleton
 */
public class ListaServizi {//si potrebbe applicare un pattern perchè questo oggetto sta in mezzo ad ufficio e monitor sportelli
    //pattern SINGLETON

    /**
     * attributi
     * istanza: rappresenta ò'unica istanza di questa classe(vedere pattern singleton)
     * servizi: array di servizi offerti dall'ufficio pubblico
     */
    private static ListaServizi istanza;

    private ArrayList<Servizio> servizi;

    /**
     * inizializza gli attributi
     */
    private ListaServizi() {
        this.servizi = new ArrayList<>();
        inizializzaServizi();
    }

    /**
     * Metodo che è necessario per poter accedere all'istanza
     * @return istanza
     */
    public static ListaServizi getInstance(){
        if(istanza==null) {
            istanza = new ListaServizi();
        }

        return istanza;
    }

    /**
     * Inizializza i servizi utilizzando la classe codice.dominio.ufficio.ServiceCreator
     */
    private void inizializzaServizi(){
        servizi= new ServiceCreator().getServiziOfferti();
    }


    /**
     * richiama il metodo della classe servizio
     * @param idServizio: Id del servizio scelto dall'utente per la prenotazione
     * @return
     */
    public int prenota(IdServizio idServizio) {
        new ServiziordbDao().updateNumeroProgServizio(idServizio);
        return this.getServizio(idServizio).prenota();
    }

    /**
     *
     * @param idServizio
     * @return il servizio che ha l'idServizio preso come parametro
     */
    public Servizio getServizio(IdServizio idServizio){
        for (Servizio s:servizi
             ) {
            if(s.getId().equals(idServizio))
                return s;
        }
        return null;
    }

    /**
     *
     * @return tutti i servizi
     */
    public ArrayList<Servizio> getServizi() {
        return servizi;
    }

    @Override
    public String toString() {
        return "codice.dominio.ufficio.ListaServizi\n"+
                servizi;
    }

    //inizio DATABASE








}
