package codice;

import codice.web.ApplicationServer;
import codice.web.RythmApplication;

public class Main {
    public static void main(String[] args) throws Exception {
        String host = "192.168.1.152";
        new ApplicationServer(8282, new RythmApplication(host))
                .withRythm()
                .start();
    }
}