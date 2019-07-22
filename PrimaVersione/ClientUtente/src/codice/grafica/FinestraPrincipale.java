package codice.grafica;

import codice.client.UserClient;

import javax.swing.*;
import java.awt.*;

public class FinestraPrincipale extends JFrame {

    private JLabel titoloPrincipale;
    private PannelloPrincipale p;
    private UserClient client;

    public FinestraPrincipale(UserClient client) {
        this.client = client;

        // PROPRIETA' GENERALI DELLA FINESTRA
        setTitle("Ufficio Postale - Utente");
        setSize(500, 500);
        setResizable(false);
        BorderLayout layout = new BorderLayout();
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.decode("#f2f2f2"));
        Font fontFinestra = new Font("Gotham", Font.BOLD, 42);

        // TITOLO DELLA FINESTRA
        this.titoloPrincipale = new JLabel("UFFICIO POSTALE", JLabel.CENTER);
        getContentPane().add(titoloPrincipale, BorderLayout.NORTH);
        titoloPrincipale.setFont(fontFinestra);
        titoloPrincipale.setForeground(Color.decode("#000000"));

        // PANNELLO PRINCIPALE
        this.p = new PannelloPrincipale(client);
        add(p);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
