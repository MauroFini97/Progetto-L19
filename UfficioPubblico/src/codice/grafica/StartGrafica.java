package codice.grafica;

import codice.dominio.ufficio.Ufficio;

public class StartGrafica {
    private static Ufficio ufficio;

    public StartGrafica(Ufficio ufficio) {
        this.ufficio=ufficio;
    }

    public static void main(String[] args) {
        FinestraPrincipale finestraPrincipale = new FinestraPrincipale(ufficio);
    }


}
