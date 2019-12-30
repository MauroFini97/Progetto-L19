package codice.grafica;

import codice.client.UserClient;
import codice.dominio.ufficio.IdServizio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PannelloPrincipale extends JPanel {

    private JLabel tutorial;                    // Label Tutorial
    private JButton pbButton;                   // Pagamento Bollettini
    private JButton rpcButton;                  // Ricarica Postepay e Cellulari
    private JButton ocpButton;                  // Operazioni su Conto Postale
    private JButton cvButtom;                   // Cambio Valuta
    private JButton srpButton;                  // Spedizione e Ritiro Pacchi

    private UserClient client;
    private FinestraConferma conferma;

    public PannelloPrincipale(UserClient client) {
        this.client = client;
        GridLayout p = new GridLayout(6,1);
        setLayout(p);
        setPreferredSize(new Dimension(500, 100));
        Font fontFinestra = new Font("Gotham", Font.BOLD, 24);
        Font fontLabel = new Font("Futura", Font.BOLD, 16);

        this.tutorial = new JLabel("Seleziona il servizio cliccando sull'apposito bottone.");
        tutorial.setFont(fontLabel);
        tutorial.setBackground(Color.decode("#f2f2f2"));
        add(tutorial);

        pbButton = new JButton("PAGA UN BOLLETTINO");
        pbButton.addActionListener(pbButtonListener);
        pbButton.setFont(fontFinestra);
        pbButton.setBackground(Color.decode("#99ff99"));
        add(pbButton);

        rpcButton = new JButton("RICARICA POSTEPAY O CELLULARE");
        rpcButton.addActionListener(rpcButtonListener);
        rpcButton.setFont(fontFinestra);
        rpcButton.setBackground(Color.decode("#99ff99"));
        add(rpcButton);

        ocpButton = new JButton("CONTO POSTALE");
        ocpButton.addActionListener(ocpButtonListener);
        ocpButton.setFont(fontFinestra);
        ocpButton.setBackground(Color.decode("#99ff99"));
        add(ocpButton);

        cvButtom = new JButton("CAMBIO VALUTA");
        cvButtom.addActionListener(cvButtonListener);
        cvButtom.setFont(fontFinestra);
        cvButtom.setBackground(Color.decode("#99ff99"));
        add(cvButtom);

        srpButton = new JButton("SPEDISCI O RITIRA UN PACCO");
        srpButton.addActionListener(srpButtonListener);
        srpButton.setFont(fontFinestra);
        srpButton.setBackground(Color.decode("#99ff99"));
        add(srpButton);
    }

    ActionListener pbButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nP = client.prenotaNum(IdServizio.PB);
            conferma = new FinestraConferma("SERVIZIO: paga un bollettino", "N° PRENOTAZIONE: " + nP);
        }
    };
    ActionListener rpcButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nP = client.prenotaNum(IdServizio.RPC);
            conferma = new FinestraConferma("SERVIZIO: ricarica postepay o cellulare", "N° PRENOTAZIONE: " + nP);
        }
    };
    ActionListener ocpButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nP = client.prenotaNum(IdServizio.OCP);
            conferma = new FinestraConferma("SERVIZIO: opera sul conto postale", "N° PRENOTAZIONE: " + nP);
        }
    };
    ActionListener cvButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nP = client.prenotaNum(IdServizio.CV);
            conferma = new FinestraConferma("SERVIZIO: cambio valuta", "N° PRENOTAZIONE: " + nP);
        }
    };
    ActionListener srpButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nP = client.prenotaNum(IdServizio.SRP);
            conferma = new FinestraConferma("SERVIZIO: spedisci o ritira un pacco", "N° PRENOTAZIONE: " + nP);
        }
    };
}
