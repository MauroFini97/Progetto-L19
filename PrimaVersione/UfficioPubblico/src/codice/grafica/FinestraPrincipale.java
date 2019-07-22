package codice.grafica;

import codice.dominio.ufficio.Ufficio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FinestraPrincipale extends JFrame {


    private JButton aggiorna;
    private JLabel dataAggiornamento;
    private PannelloServizi servizi;
    private PannelloSportelli sportelli;

    private Ufficio ufficio;

    public FinestraPrincipale(Ufficio ufficio) {

        this.ufficio=ufficio;

        setTitle("Ufficio");

        setSize(1000,500);

        BorderLayout layout = new BorderLayout();
        getContentPane().setLayout(layout);



        this.aggiorna=new JButton("AGGIORNA");
        aggiorna.addActionListener(listener1);
        getContentPane().add(aggiorna,BorderLayout.NORTH);

        this.dataAggiornamento=new JLabel();
        getContentPane().add(dataAggiornamento,BorderLayout.SOUTH);

        this.servizi= new PannelloServizi();
        getContentPane().add(servizi,BorderLayout.WEST);
        servizi.settaListaServizi(ufficio);

        this.sportelli=new PannelloSportelli();
        getContentPane().add(sportelli,BorderLayout.EAST);
        sportelli.settaListaSportelli(ufficio);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    ActionListener listener1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            servizi.aggiorna(ufficio);
            sportelli.aggiorna(ufficio);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            dataAggiornamento.setText("Ultimo aggiornamento: "+dtf.format(now));
        }
    };

}
