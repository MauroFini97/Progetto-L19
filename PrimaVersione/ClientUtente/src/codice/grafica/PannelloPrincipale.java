package codice.grafica;

import codice.client.ClientUtente;
import codice.client.UserClient;
import codice.dominio.ufficio.IdServizio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PannelloPrincipale extends JPanel {

    private JTextArea tutorial;                 // Label Tutorial
    private JLabel selezione;                   // Label Selezione
    private JLabel numPrenotazione;             // Label Prenotazione
    private JButton reset;                      // Button Reset
    private JButton pbButton;                   // Pagamento Bollettini
    private JButton rpcButton;                  // Ricarica Postepay e Cellulari
    private JButton ocpButton;                  // Operazioni su Conto Postale
    private JButton cvButtom;                   // Cambio Valuta
    private JButton srpButton;                  // Spedizione e Ritiro Pacchi

    private UserClient c1;

    public PannelloPrincipale(UserClient client) {
        this.c1 = client;
        GridLayout p = new GridLayout(9,1);
        setLayout(p);
        setPreferredSize(new Dimension(500, 100));
        Font fontFinestra = new Font("Gotham", Font.BOLD, 24);
        Font fontLabel = new Font("Futura", Font.BOLD, 16);

        this.tutorial = new JTextArea("BENVENUTO !! Seleziona il servizio che desideri.");
        tutorial.setFont(fontLabel);
        tutorial.setBackground(Color.decode("#f2f2f2"));
        tutorial.setEditable(false);
        add(tutorial);

        this.selezione = new JLabel("SERVIZIO SCELTO: ");
        selezione.setFont(fontLabel);
        selezione.setBackground(Color.decode("#f2f2f2"));
        add(selezione);

        this.numPrenotazione = new JLabel("N° PRENOTAZIONE: ");
        numPrenotazione.setFont(fontLabel);
        numPrenotazione.setBackground(Color.decode("#f2f2f2"));
        add(numPrenotazione);

        this.reset = new JButton("FINE OPERAZIONI --> Prossimo cliente");
        reset.addActionListener(resetButtonListener);
        reset.setFont(fontLabel);
        reset.setBackground(Color.decode("#ff3333"));
        add(reset);

        this.pbButton = new JButton("PAGA UN BOLLETTINO");
        pbButton.addActionListener(pbButtonListener);
        pbButton.setFont(fontFinestra);
        pbButton.setBackground(Color.decode("#99ff99"));
        add(pbButton);

        this.rpcButton = new JButton("RICARICA POSTEPAY O CELLULARE");
        rpcButton.addActionListener(rpcButtonListener);
        rpcButton.setFont(fontFinestra);
        rpcButton.setBackground(Color.decode("#99ff99"));
        add(rpcButton);

        this.ocpButton = new JButton("CONTO POSTALE");
        ocpButton.addActionListener(ocpButtonListener);
        ocpButton.setFont(fontFinestra);
        ocpButton.setBackground(Color.decode("#99ff99"));
        add(ocpButton);

        this.cvButtom = new JButton("CAMBIO VALUTA");
        cvButtom.addActionListener(cvButtonListener);
        cvButtom.setFont(fontFinestra);
        cvButtom.setBackground(Color.decode("#99ff99"));
        add(cvButtom);

        this.srpButton = new JButton("SPEDISCI O RITIRA UN PACCO");
        srpButton.addActionListener(srpButtonListener);
        srpButton.setFont(fontFinestra);
        srpButton.setBackground(Color.decode("#99ff99"));
        add(srpButton);
    }

    ActionListener pbButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            selezione.setText("SERVIZIO SCELTO: paga un bollettino");
            String nP = c1.prenotaNum(IdServizio.PB);
            numPrenotazione.setText("N° PRENOTAZIONE: " + nP);
        }
    };
    ActionListener rpcButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            selezione.setText("SERVIZIO SCELTO: ricarica postepay o cellulare");
            String nP = c1.prenotaNum(IdServizio.RPC);
            numPrenotazione.setText("N° PRENOTAZIONE: " + nP);
        }
    };
    ActionListener ocpButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            selezione.setText("SERVIZIO SCELTO: conto postale");
            String nP = c1.prenotaNum(IdServizio.OCP);
            numPrenotazione.setText("N° PRENOTAZIONE: " + nP);
        }
    };
    ActionListener cvButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            selezione.setText("SERVIZIO SCELTO: cambio valuta");
            String nP = c1.prenotaNum(IdServizio.CV);
            numPrenotazione.setText("N° PRENOTAZIONE: " + nP);
        }
    };
    ActionListener srpButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            selezione.setText("SERVIZIO SCELTO: spedisci o ritira un pacco");
            String nP = c1.prenotaNum(IdServizio.SRP);
            numPrenotazione.setText("N° PRENOTAZIONE: " + nP);
        }
    };
    ActionListener resetButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            selezione.setText("SERVIZIO SCELTO: ");
            numPrenotazione.setText("N° PRENOTAZIONE: ");
        }
    };
}
