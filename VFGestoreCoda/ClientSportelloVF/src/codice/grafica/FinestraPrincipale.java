package codice.grafica;

import codice.client.SportelloClient;

import javax.swing.*;
import java.awt.*;

public class FinestraPrincipale extends JFrame {

    private PannelloPrincipale p;
    private SportelloClient sportello;

    public FinestraPrincipale(SportelloClient sportello) {
        this.sportello = sportello;

        // PROPRIETA' GENERALI DELLA FINESTRA
        setTitle("Ufficio Postale - Sportello");
        setSize(600, 300);
        setResizable(false);
        BorderLayout layout = new BorderLayout();
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.decode("#f2f2f2"));
        Font fontFinestra = new Font("Gotham", Font.BOLD, 42);

        // PANNELLO PRINCIPALE
        p = new PannelloPrincipale(sportello);
        add(p);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
