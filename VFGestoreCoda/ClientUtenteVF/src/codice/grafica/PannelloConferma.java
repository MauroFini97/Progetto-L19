package codice.grafica;

import javax.swing.*;
import java.awt.*;

public class PannelloConferma extends JPanel {
    private JLabel lblTitoloPrincipale;         // Titolo intestazione della finestra
    private JLabel lblServizio;                 // Servizio selezionato
    private JLabel lblNumPrenotazione;          // Numero di prenotazione ricevuto
    private String servizio;                    // Servizio
    private String numPrenotazione;             // Numero di prenotazione

    public PannelloConferma(String servizio, String numPrenotazione) {
        this.servizio = servizio;
        this.numPrenotazione = numPrenotazione;

        // PANNELLO INFORMAZIONI
        GridLayout p = new GridLayout(3, 1);
        setLayout(p);
        setPreferredSize(new Dimension(500, 100));
        Font fontF1 = new Font("Gotham", Font.BOLD, 28);
        Font fontLabel = new Font("Futura", Font.BOLD, 16);

        // [Titolo della finestra]
        lblTitoloPrincipale = new JLabel("CONFERMA PRENOTAZIONE", JLabel.CENTER);
        lblTitoloPrincipale.setFont(fontF1);
        lblTitoloPrincipale.setForeground(Color.decode("#000000"));
        add(lblTitoloPrincipale);

        // [Servizio prenotato]
        lblServizio = new JLabel(this.servizio);
        lblServizio.setFont(fontLabel);
        lblServizio.setBackground(Color.decode("#f2f2f2"));
        add(lblServizio);

        // [Numero di prenotazione]
        lblNumPrenotazione = new JLabel(this.numPrenotazione);
        lblNumPrenotazione.setFont(fontLabel);
        lblNumPrenotazione.setBackground(Color.decode("#f2f2f2"));
        add(lblNumPrenotazione);
    }
}
