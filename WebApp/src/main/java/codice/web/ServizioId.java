package codice.web;

import codice.dominio.ufficio.IdServizio;

import java.util.ArrayList;

/**
 * Utilizzando il template engine, L'enum IdServizio non era riconosciuto come tipo
 * dal template engine, perciò questa classe si occupa di iterare l'enum IdServizio e castare ogni elemento
 * in un tipo String
 */
public class ServizioId {

    private ArrayList<String> idstringservizi;

    public ServizioId() {
        this.idstringservizi=new ArrayList<>();

        for (IdServizio s:IdServizio.values()
             ) {
            idstringservizi.add(s.toString());
        };
    }

    public ArrayList<String> getIdstringservizi() {
        return idstringservizi;
    }
}
