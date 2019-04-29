package test;

import sportelli.SportelloVariabile;
import test.Ufficio;


/*
testa il funzionamento dei singoli sportelli che si interfacciano con la coda principale dell'ufficio.
in V1.0 si segue semplicemente il numero progressivo delle prenotazioni e ogni sportello cambia il servizio in base alla
prenotazione che prende in carico
 */
public class TestRiceviEliminaPrenotazioniSportelli {
    public static void main(String[] args) {

        Ufficio posta = new Ufficio("posta",0);
        SportelloVariabile sp1=new SportelloVariabile("1");
        SportelloVariabile sp2 = new SportelloVariabile("2");

        posta.prenota("SRP");
        posta.prenota("SRP");
        posta.prenota("PB");
        posta.prenota("RPC");
        posta.prenota("PB");
        posta.prenota("SRP");

        sp1.riceviPrenotazione(posta.getCodaPrincipale());
        sp2.riceviPrenotazione(posta.getCodaPrincipale());

        //System.out.println(sp1);
        //System.out.println(sp2);
        //System.out.println(posta.getCodaPrincipale());

        sp2.clienteServito();

        //System.out.println(sp1);
        //System.out.println(sp2);
        //System.out.println(posta.getCodaPrincipale());

        sp2.riceviPrenotazione(posta.getCodaPrincipale());
        sp1.clienteServito();
        sp1.riceviPrenotazione(posta.getCodaPrincipale());

        System.out.println(sp1);
        System.out.println(sp2);
        System.out.println(posta.getCodaPrincipale());





    }


}
