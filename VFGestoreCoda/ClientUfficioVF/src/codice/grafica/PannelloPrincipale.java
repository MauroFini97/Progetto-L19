package codice.grafica;

import codice.StartApplication;
import codice.client.UfficioClient;
import codice.dominio.ufficio.IdServizio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PannelloPrincipale extends JPanel {

    private JLabel lblTitoloServizi, lblTitoloSportelli;
    private JLabel lblServizio1, lblServizio2, lblServizio3, lblServizio4, lblServizio5;        // Dati servizi
    private JLabel lblSportello1, lblSportello2, lblSportello3, lblSportello4, lblSportello5;   // Dati sportelli
    private JButton btnAggiorna;            // Bottone aggiorna dati

    private UfficioClient ufficio;

    public PannelloPrincipale(UfficioClient ufficio){
        this.ufficio = ufficio;
        GridLayout p = new GridLayout(13,1);
        setLayout(p);
        setPreferredSize(new Dimension(800, 600));
        Font fontFinestra = new Font("Gotham", Font.BOLD, 24);
        Font fontLabel = new Font("Futura", Font.BOLD, 16);
        Font fontTitolo = new Font("Futura", Font.BOLD, 24);

        // TITOLO FINESTRA SERVIZI
        this.lblTitoloServizi = new JLabel("DATI GENERALI SERVIZI");
        lblTitoloServizi.setFont(fontTitolo);
        lblTitoloServizi.setForeground(Color.decode("#e60000"));
        lblTitoloServizi.setBackground(Color.decode("#f2f2f2"));
        add(lblTitoloServizi);

        // DATI SERVIZI
        this.lblServizio1 = new JLabel("");
        lblServizio1.setFont(fontLabel);
        lblServizio1.setBackground(Color.decode("#f2f2f2"));
        add(lblServizio1);

        this.lblServizio2 = new JLabel("");
        lblServizio2.setFont(fontLabel);
        lblServizio2.setBackground(Color.decode("#f2f2f2"));
        add(lblServizio2);

        this.lblServizio3 = new JLabel("");
        lblServizio3.setFont(fontLabel);
        lblServizio3.setBackground(Color.decode("#f2f2f2"));
        add(lblServizio3);

        this.lblServizio4 = new JLabel("");
        lblServizio4.setFont(fontLabel);
        lblServizio4.setBackground(Color.decode("#f2f2f2"));
        add(lblServizio4);

        this.lblServizio5 = new JLabel("");
        lblServizio5.setFont(fontLabel);
        lblServizio5.setBackground(Color.decode("#f2f2f2"));
        add(lblServizio5);

        // TITOLO FINESTRA SPORTELLI
        this.lblTitoloSportelli = new JLabel("DATI GENERALI SPORTELLI");
        lblTitoloSportelli.setFont(fontTitolo);
        lblTitoloSportelli.setForeground(Color.decode("#e60000"));
        lblTitoloSportelli.setBackground(Color.decode("#f2f2f2"));
        add(lblTitoloSportelli);

        // DATI SERVIZI
        this.lblSportello1 = new JLabel("");
        lblSportello1.setFont(fontLabel);
        lblSportello1.setBackground(Color.decode("#f2f2f2"));
        add(lblSportello1);

        this.lblSportello2 = new JLabel("");
        lblSportello2.setFont(fontLabel);
        lblSportello2.setBackground(Color.decode("#f2f2f2"));
        add(lblSportello2);

        this.lblSportello3 = new JLabel("");
        lblSportello3.setFont(fontLabel);
        lblSportello3.setBackground(Color.decode("#f2f2f2"));
        add(lblSportello3);

        this.lblSportello4 = new JLabel("");
        lblSportello4.setFont(fontLabel);
        lblSportello4.setBackground(Color.decode("#f2f2f2"));
        add(lblSportello4);

        this.lblSportello5 = new JLabel("");
        lblSportello5.setFont(fontLabel);
        lblSportello5.setBackground(Color.decode("#f2f2f2"));
        add(lblSportello5);

        this.btnAggiorna = new JButton("AGGIORNA");
        btnAggiorna.addActionListener(btnAggiornaListener);
        btnAggiorna.setFont(fontFinestra);
        btnAggiorna.setBackground(Color.decode("#99ff99"));
        add(btnAggiorna);

        aggiorna(ufficio);
    }

    ActionListener btnAggiornaListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            aggiorna(ufficio);
        }
    };

    public void aggiorna(UfficioClient ufficio) {
        try {
            lblServizio1.setText("SERVIZIO: "+IdServizio.PB+" | NUM-PROG: "+ufficio.getServizioNumProgr(IdServizio.PB)+" | PRENOTAZIONI IN CODA: "+ufficio.getPrenotazioniInCoda(IdServizio.PB));
            lblServizio2.setText("SERVIZIO: "+IdServizio.RPC+" | NUM-PROG: "+ufficio.getServizioNumProgr(IdServizio.RPC)+" | PRENOTAZIONI IN CODA: "+ufficio.getPrenotazioniInCoda(IdServizio.RPC));
            lblServizio3.setText("SERVIZIO: "+IdServizio.OCP+" | NUM-PROG: "+ufficio.getServizioNumProgr(IdServizio.OCP)+" | PRENOTAZIONI IN CODA: "+ufficio.getPrenotazioniInCoda(IdServizio.OCP));
            lblServizio4.setText("SERVIZIO: "+IdServizio.CV+" | NUM-PROG: "+ufficio.getServizioNumProgr(IdServizio.CV)+" | PRENOTAZIONI IN CODA: "+ufficio.getPrenotazioniInCoda(IdServizio.CV));
            lblServizio5.setText("SERVIZIO: "+IdServizio.SRP+" | NUM-PROG: "+ufficio.getServizioNumProgr(IdServizio.SRP)+" | PRENOTAZIONI IN CODA: "+ufficio.getPrenotazioniInCoda(IdServizio.SRP));

            if(ufficio.getStatoSportelloPerServer(1) == null) {
                lblSportello1.setText("SPORTELLO: 1 | STATO: CHIUSO | SERVIZIO OFFERTO: - | CLIENTE SERVITO: -");
            } else {
                lblSportello1.setText("SPORTELLO: 1 | STATO: "+ufficio.getStatoSportelloPerServer(1)+" | SERVIZIO OFFERTO: "+ufficio.getIdServizioOffertoSportelloPerServer(1)+" | CLIENTE SERVITO: "+ufficio.getNumeroClienteSportelloPerServer(1));
            }
            if(ufficio.getStatoSportelloPerServer(2) == null) {
                lblSportello2.setText("SPORTELLO: 2 | STATO: CHIUSO | SERVIZIO OFFERTO: - | CLIENTE SERVITO: -");
            } else {
                lblSportello2.setText("SPORTELLO: 2 | STATO: "+ufficio.getStatoSportelloPerServer(2)+" | SERVIZIO OFFERTO: "+ufficio.getIdServizioOffertoSportelloPerServer(2)+" | CLIENTE SERVITO: "+ufficio.getNumeroClienteSportelloPerServer(2));
            }
            if(ufficio.getStatoSportelloPerServer(3) == null) {
                lblSportello3.setText("SPORTELLO: 3 | STATO: CHIUSO | SERVIZIO OFFERTO: - | CLIENTE SERVITO: -");
            } else {
                lblSportello3.setText("SPORTELLO: 3 | STATO: "+ufficio.getStatoSportelloPerServer(3)+" | SERVIZIO OFFERTO: "+ufficio.getIdServizioOffertoSportelloPerServer(3)+" | CLIENTE SERVITO: "+ufficio.getNumeroClienteSportelloPerServer(3));
            }
            if(ufficio.getStatoSportelloPerServer(4) == null) {
                lblSportello4.setText("SPORTELLO: 4 | STATO: CHIUSO | SERVIZIO OFFERTO: - | CLIENTE SERVITO: -");
            } else {
                lblSportello4.setText("SPORTELLO: 4 | STATO: "+ufficio.getStatoSportelloPerServer(4)+" | SERVIZIO OFFERTO: "+ufficio.getIdServizioOffertoSportelloPerServer(4)+" | CLIENTE SERVITO: "+ufficio.getNumeroClienteSportelloPerServer(4));
            }
            if(ufficio.getStatoSportelloPerServer(5) == null) {
                lblSportello5.setText("SPORTELLO: 5 | STATO: CHIUSO | SERVIZIO OFFERTO: - | CLIENTE SERVITO: -");
            } else {
                lblSportello5.setText("SPORTELLO: 5 | STATO: "+ufficio.getStatoSportelloPerServer(5)+" | SERVIZIO OFFERTO: "+ufficio.getIdServizioOffertoSportelloPerServer(5)+" | CLIENTE SERVITO: "+ufficio.getNumeroClienteSportelloPerServer(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
