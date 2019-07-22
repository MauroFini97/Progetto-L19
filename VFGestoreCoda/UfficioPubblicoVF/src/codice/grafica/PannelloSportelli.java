package codice.grafica;

import codice.dominio.sportello.AbstractSportello;
import codice.dominio.ufficio.Ufficio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//non serve più
public class PannelloSportelli extends JPanel {

    private JPanel titolo;

    public PannelloSportelli() {
        GridLayout layout=new GridLayout(6,1);
        setLayout(layout);
    }


    private ArrayList<PanSportello> graficaSportelli;

    public void settaListaSportelli(Ufficio u){
        this.graficaSportelli=new ArrayList<>();

        this.titolo=new JPanel();


        titolo.add(new JLabel("Numero Sportello"));titolo.add(new JLabel("IdServizio offerto"));titolo.add(new JLabel("Num in servizio"));

        add(titolo);

        for (AbstractSportello s:u.getSportelli()
             ) {
            graficaSportelli.add(new PanSportello(s.getNumeroSportello()));
        }

        for (PanSportello p:graficaSportelli
             ) {
            add(p);
        }

    }

    public void aggiorna(Ufficio u){
        for (PanSportello p:graficaSportelli
             ) {
            p.aggiorna(u);
        }
    }


}
