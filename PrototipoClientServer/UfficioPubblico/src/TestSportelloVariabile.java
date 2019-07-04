public class TestSportelloVariabile {
    public static void main(String[] args) {
        Ufficio ufficio=new Ufficio();

        ufficio.creaSportello();
        ufficio.creaSportello();

        //ufficio.setServizioOffertoSportello(0,IdServizio.SRP);//sportello fisso
        //ufficio.setServizioOffertoSportello(1,IdServizio.CV);//sportello variabile

        ufficio.prenota(IdServizio.SRP);//prenotazione 1
        ufficio.prenota(IdServizio.SRP);//prenotazione 2
        ufficio.prenota(IdServizio.SRP);//prenotazione 3
        ufficio.prenota(IdServizio.CV);//prenotazione 1

        ufficio.changeStato(0,StatoSportello.LIBERO);
        ufficio.changeStato(0,StatoSportello.LIBERO);
        ufficio.changeStato(0,StatoSportello.LIBERO);

        ufficio.changeStato(1,StatoSportello.LIBERO);
        ufficio.changeStato(1,StatoSportello.LIBERO);

        System.out.println(ufficio);

    }
}
