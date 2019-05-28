public class TestSportelli {
    public static void main(String[] args) {
        Ufficio ufficio=new Ufficio();

        ufficio.setServizioOffertoSportello(0,IdServizio.SRP);
        ufficio.setServizioOffertoSportello(1,IdServizio.CV);
        ufficio.prenota(IdServizio.SRP);
        ufficio.prenota(IdServizio.SRP);
        ufficio.prenota(IdServizio.SRP);

        ufficio.prenota(IdServizio.CV);
        ufficio.prenota(IdServizio.CV);


        ufficio.changeStato(1,StatoSportello.LIBERO);
        ufficio.changeStato(0,StatoSportello.LIBERO);
        ufficio.changeStato(1,StatoSportello.LIBERO);



        System.out.println(ufficio);

    }
}
