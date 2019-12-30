package codice.grafica;

import codice.client.UfficioClient;

import javax.swing.*;
import java.awt.*;

public class FinestraPrincipale extends JFrame {

    private PannelloPrincipale p;
    private UfficioClient ufficio;

    public FinestraPrincipale(UfficioClient ufficio) {
        this.ufficio = ufficio;

        // PROPRIETA' GENERALI DELLA FINESTRA
        setTitle("Ufficio Postale - Generale");
        setSize(800, 600);
        setResizable(false);
        BorderLayout layout = new BorderLayout();
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.decode("#f2f2f2"));
        Font fontFinestra = new Font("Gotham", Font.BOLD, 42);

        // PANNELLO PRINCIPALE
        p = new PannelloPrincipale(ufficio);
        add(p);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
