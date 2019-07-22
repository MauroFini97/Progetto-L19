package codice.grafica;

import codice.dominio.ufficio.Ufficio;
import codice.server.ServerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FinestraPrincipale extends JFrame {


    private JButton avvia;
    private JButton restore;
    private JLabel dataAggiornamento;
    private JLabel istruzioni;

    private ServerController serverController;

    public FinestraPrincipale(ServerController server) {

        this.serverController=server;

        setTitle("Server Ufficio");

        setSize(300,200);

        //BorderLayout layout = new BorderLayout();
        //getContentPane().setLayout(layout);
        FlowLayout layout = new FlowLayout();
        getContentPane().setLayout(layout);



        this.avvia=new JButton("AVVIA SERVER");
        avvia.addActionListener(avviaserver);
        getContentPane().add(avvia);

        this.restore= new JButton("RESTORE SERVER");
        restore.addActionListener(restoreserver);
        getContentPane().add(restore);

        this.dataAggiornamento=new JLabel();
        getContentPane().add(dataAggiornamento);




        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    ActionListener avviaserver = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            serverController.avviaServer();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            dataAggiornamento.setText("Server avviato: "+dtf.format(now));
        }
    };

    ActionListener restoreserver = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            serverController.restoreSever();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            dataAggiornamento.setText("Server riavviato: "+dtf.format(now));
        }
    };

}
