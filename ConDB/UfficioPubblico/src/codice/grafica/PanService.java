package codice.grafica;

import codice.dominio.ufficio.IdServizio;
import codice.dominio.ufficio.Ufficio;

import javax.swing.*;

public class PanService extends JPanel {
    private IdServizio idServizio;
    private JLabel prenotazioni;
    private JLabel prenotazioniInCoda;

    public PanService(IdServizio idServizio) {
        this.idServizio=idServizio;
        this.prenotazioni=new JLabel();
        this.prenotazioniInCoda=new JLabel();
        add(new JLabel(idServizio.toString())); add(prenotazioni); add(prenotazioniInCoda);
    }

    public void aggiorna(Ufficio u){
        prenotazioni.setText(String.valueOf(u.getServizioNumProgr(idServizio)));
        prenotazioniInCoda.setText(String.valueOf(u.getPrenotazioniInCoda(idServizio)));
    }


}
