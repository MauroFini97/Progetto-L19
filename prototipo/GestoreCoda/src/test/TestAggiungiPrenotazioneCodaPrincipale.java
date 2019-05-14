package test;/*
per simulare il funzionamento si può creare un file in cui ogni riga sono prenotazioni
in cui c'è l'id del servizio scelto.
 */


import servizio.ServicesList;
import servizio.Servizio;
import test.Ufficio;

public class TestAggiungiPrenotazioneCodaPrincipale {
    public static void main(String[] args) {

        Ufficio posta = new Ufficio("Ufficio Postale",6);

        posta.prenota(ServicesList.RPC);
        posta.prenota(ServicesList.OCP);
        posta.prenota(ServicesList.RPC);

        System.out.println(posta);



    }
}
