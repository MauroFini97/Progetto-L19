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


        ufficio.changeStato(0,StatoSportello.LIBERO);




        System.out.println(ufficio.visualizzaStato());

    }
}
