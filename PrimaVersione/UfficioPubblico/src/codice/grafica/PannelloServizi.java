package codice.grafica;

import codice.dominio.ufficio.IdServizio;
import codice.dominio.ufficio.Ufficio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PannelloServizi extends JPanel {

    public PannelloServizi() {
        GridLayout layout = new GridLayout(6,1);
        setLayout(layout);
        //prima riga
        //add(new JLabel("ID servizio"),0,0);
        //add(new JLabel("Numero prenotazioni"),0,1);
        //add(new JLabel("Numero in sevizio"),0,2);


    }

    private ArrayList<PanService> graficaServizi;
    private JPanel titolo;

    public void settaListaServizi(Ufficio u){
        this.graficaServizi=new ArrayList<>();

        this.titolo=new JPanel();


        titolo.add(new JLabel("ID SERVIZIO"));titolo.add(new JLabel("NUMERO PRENOTAZIONI"));titolo.add(new JLabel("PERSONE IN CODA"));

        add(titolo);

        ArrayList<IdServizio> idServizi = u.idServiziOfferti();

        for (IdServizio id:idServizi
             ) {
            graficaServizi.add(new PanService(id));
        }

        for (PanService p:graficaServizi
             ) {
            add(p);
        }

    }

    public void aggiorna(Ufficio u){

        for (PanService p:graficaServizi
             ) {
            p.aggiorna(u);
        }
    }



}
