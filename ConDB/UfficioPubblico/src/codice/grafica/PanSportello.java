package codice.grafica;

import codice.dominio.ufficio.Ufficio;

import javax.swing.*;

public class PanSportello extends JPanel {
    private int numeroSportello;
    private JLabel stato;
    private JLabel servizioOfferto;
    private JLabel numeroInServizio;

    public PanSportello(int numeroSportello) {
        this.numeroSportello = numeroSportello;
        this.stato=new JLabel();
        this.servizioOfferto=new JLabel();
        this.numeroInServizio=new JLabel();

        add(new JLabel(String.valueOf(numeroSportello)));add(stato);add(servizioOfferto);add(numeroInServizio);

    }

    public void aggiorna(Ufficio u){
        try {
            stato.setText(u.getStatoSportello(numeroSportello).toString());
            servizioOfferto.setText(u.getServizioOfferto(numeroSportello).toString());
            numeroInServizio.setText(String.valueOf(u.getClienteInServizio(numeroSportello)));
        }catch (NullPointerException n){
            stato.setText("Non sta offrendo servizio");
            servizioOfferto.setText(null);
            numeroInServizio.setText(null);
        }
    }

}
