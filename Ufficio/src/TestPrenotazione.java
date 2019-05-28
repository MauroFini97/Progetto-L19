public class TestPrenotazione {
    public static void main(String[] args) {

        Ufficio posta = new Ufficio();

        posta.prenota(IdServizio.OCP);
        posta.prenota(IdServizio.OCP);




        System.out.println(posta);
    }
}
