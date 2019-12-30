package codice.grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinestraConferma extends JFrame {

    private PannelloConferma pc;                // Pannello Conferma
    private JButton btnConferma;                // Bottone di conferma lettura della prenotazione
    private String servizio;                    // Servizio
    private String numPrenotazione;             // Numero di prenotazione

    public FinestraConferma(String servizio, String numPrenotazione) {

        this.servizio = servizio;
        this.numPrenotazione = numPrenotazione;

        // PROPRIETA' GENERALI DELLA FINESTRA
        setTitle("Ufficio Postale - Conferma prenotazione");
        setSize(500, 200);
        setResizable(false);
        setVisible(true);
        BorderLayout layout = new BorderLayout();
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.decode("#f2f2f2"));
        Font fontF2 = new Font("Gotham", Font.BOLD, 24);
        Font fontLabel = new Font("Futura", Font.BOLD, 16);

        // PANNELLO CONFERMA
        pc = new PannelloConferma(this.servizio, this.numPrenotazione);
        getContentPane().add(pc, BorderLayout.NORTH);

        // BOTTONE CONFERMA
        btnConferma = new JButton("CONFERMA");
        btnConferma.addActionListener(confermaBL);
        btnConferma.setFont(fontF2);
        btnConferma.setBackground(Color.decode("#e60000"));
        getContentPane().add(btnConferma, BorderLayout.SOUTH);
    }

    ActionListener confermaBL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    };
}
