package codice.grafica;

import codice.client.SportelloClient;
import codice.dominio.sportello.StatoSportello;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PannelloPrincipale extends JPanel {

    private JLabel lblVuota;                                        // Label vuote di appoggio
    private JLabel lblTitolo;                                       // Label numero sportello
    private JLabel lblStato1, lblStato2;                            // Label stato sportello
    private JLabel lblServizio1, lblServizio2;                      // Label servizio offerto dallo sportello
    private JLabel lblClienteServito1, lblClienteServito2;          // Labelo cliente servito dallo sportello

    private JButton btnProssimo;          // Settaggio stato sportello --> LIBERO
    private JButton btnInPausa;         // Settaggio stato sportello --> INPAUSA

    private SportelloClient sportello;

    public PannelloPrincipale(SportelloClient sportello) {
        this.sportello = sportello;
        GridLayout p = new GridLayout(5,2);
        setLayout(p);
        setPreferredSize(new Dimension(600, 300));
        Font fontFinestra = new Font("Gotham", Font.BOLD, 24);
        Font fontLabel = new Font("Futura", Font.BOLD, 16);
        Font fontTitolo = new Font("Futura", Font.BOLD, 24);

        // TITOLO DELLA FINESTRA
        this.lblTitolo = new JLabel("SPORTELLO " + sportello.getNumeroSportello(), JLabel.CENTER);
        lblTitolo.setFont(fontTitolo);
        lblTitolo.setBackground(Color.decode("#f2f2f2"));
        add(lblTitolo);

        this.lblVuota = new JLabel();
        add(lblVuota);

        // BOTTONI STATO SPORTELLO
        btnProssimo = new JButton("PROSSIMO");
        btnProssimo.addActionListener(btnProssimoListener);
        btnProssimo.setFont(fontFinestra);
        btnProssimo.setBackground(Color.decode("#99ff99"));
        add(btnProssimo);

        btnInPausa = new JButton("IN PAUSA");
        btnInPausa.addActionListener(btnInPausaListener);
        btnInPausa.setFont(fontFinestra);
        btnInPausa.setBackground(Color.decode("#99ff99"));
        add(btnInPausa);

        // INFORMAZIONI SULLO STATO
        this.lblStato1 = new JLabel("STATO: ");
        lblStato1.setFont(fontLabel);
        lblStato1.setBackground(Color.decode("#f2f2f2"));
        add(lblStato1);

        this.lblStato2 = new JLabel("LIBERO");
        lblStato2.setFont(fontLabel);
        lblStato2.setForeground(Color.decode("#e60000"));
        lblStato2.setBackground(Color.decode("#f2f2f2"));
        add(lblStato2);

        // INFORMAZIONI SUL SERVIZIO OFFERTO
        this.lblServizio1 = new JLabel("SERVIZIO OFFERTO: ");
        lblServizio1.setFont(fontLabel);
        lblServizio1.setBackground(Color.decode("#f2f2f2"));
        add(lblServizio1);

        this.lblServizio2 = new JLabel("-");
        lblServizio2.setFont(fontLabel);
        lblServizio2.setForeground(Color.decode("#e60000"));
        lblServizio2.setBackground(Color.decode("#f2f2f2"));
        add(lblServizio2);

        // INFORMAZIONI SUL CLIENTE SERVITO
        this.lblClienteServito1 = new JLabel("CLIENTE SERVITO: ");
        lblClienteServito1.setFont(fontLabel);
        lblClienteServito1.setBackground(Color.decode("#f2f2f2"));
        add(lblClienteServito1);

        this.lblClienteServito2 = new JLabel("-");
        lblClienteServito2.setFont(fontLabel);
        lblClienteServito2.setForeground(Color.decode("#e60000"));
        lblClienteServito2.setBackground(Color.decode("#f2f2f2"));
        add(lblClienteServito2);
    }

    ActionListener btnProssimoListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            sportello.cambiaStato(StatoSportello.LIBERO);
            lblStato2.setText(""+ sportello.getStato());
            lblServizio2.setText(""+ sportello.getServizioOfferto());
            lblClienteServito2.setText(""+ sportello.getNumeroClienteInServizio());
        }
    };

    ActionListener btnInPausaListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            sportello.cambiaStato(StatoSportello.INPAUSA);
            lblStato2.setText("IN PAUSA");
            lblServizio2.setText("-");
            lblClienteServito2.setText("-");
        }
    };

}

/*String stato = "" + sportello.getStato();

            if(stato == "LIBERO") {
                lblStato2.setText("LIBERO");
                lblServizio2.setText("-");
                lblClienteServito2.setText("-");
            }

            if(stato == "OCCUPATO") {
                lblStato2.setText("OCCUPATO");
                lblServizio2.setText(""+ sportello.getServizioOfferto());
                lblClienteServito2.setText(""+ sportello.getNumeroClienteInServizio());
            }*/
