package codice;

import codice.client.UfficioClient;
import codice.grafica.FinestraPrincipale;

public class StartApplication {
    public static void main(String[] args) {
        String host = "";

        UfficioClient ufficioClient=new UfficioClient(host);

        FinestraPrincipale grafica = new FinestraPrincipale(ufficioClient);
    }
}
