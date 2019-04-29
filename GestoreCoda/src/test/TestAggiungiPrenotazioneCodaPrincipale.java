package test;/*
per simulare il funzionamento si può creare un file in cui ogni riga sono prenotazioni
in cui c'è l'id del servizio scelto.
 */


import servizio.Servizio;
import test.Ufficio;

public class TestAggiungiPrenotazioneCodaPrincipale {
    public static void main(String[] args) {

        Ufficio posta = new Ufficio("test.Ufficio Postale",6);
        Servizio rcp = new Servizio("ricarica","RCP");
        Servizio srp = new Servizio("spedizione","SRP");

        posta.addServizioOfferto(rcp);
        posta.addServizioOfferto(srp);

        posta.prenota("RCP");
        posta.prenota("RCP");
        posta.prenota("SRP");

        System.out.println(posta);



    }
}
