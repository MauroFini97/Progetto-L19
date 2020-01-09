package codice;

import codice.client.UserClient;
import codice.grafica.FinestraPrincipale;

public class StartApplication {
    public static void main(String[] args) {
        String host = "";
        UserClient avviaClient = new UserClient(host);
        FinestraPrincipale grafica = new FinestraPrincipale(avviaClient);
    }
}
