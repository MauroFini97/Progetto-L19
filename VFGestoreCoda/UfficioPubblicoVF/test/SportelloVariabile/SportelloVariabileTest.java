package SportelloVariabile;

import codice.database.ServizioDAO;
import codice.dominio.sportello.StatoSportello;
import codice.dominio.ufficio.IdServizio;
import codice.dominio.ufficio.ListaServizi;
import codice.dominio.ufficio.Ufficio;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import codice.*;

/**
 *
 *  Unità di test della classe SportelloVariabile
 *  *
 *  Test che verifica la funzionalità dello SportelloVariabile, una volta serviti tutti i suoi clienti, di cambiare
 *  servizio offerto in quello con il maggior numero di prenotazioni
 *
 */

public class SportelloVariabileTest {
    @BeforeClass
    public static void init(){
        ServizioDAO sdb = new ServizioDAO();
    }

    @Test
    public void TestSportelloVar(){
        Ufficio uff = new Ufficio();
        uff.inizializzaServizi();

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < 40){
            uff.prenota(IdServizio.PB);
            i++;
        }

        while (j < 25){
            uff.prenota(IdServizio.CV);
            j++;
        }

        while (k < 14){
            uff.prenota(IdServizio.RPC);
            k++;
        }

        uff.creaSportello(2, IdServizio.PB);
        uff.creaSportello(3, IdServizio.CV);
        uff.creaSportello(4, IdServizio.RPC);

        uff.changeStato(2, StatoSportello.LIBERO);
        uff.changeStato(3, StatoSportello.LIBERO);
        uff.changeStato(4, StatoSportello.LIBERO);

        if(uff.getPrenotazioniInCoda(IdServizio.RPC)== 0 && uff.getPrenotazioniInCoda(IdServizio.PB)>uff.getPrenotazioniInCoda(IdServizio.CV)){
            assertEquals(IdServizio.PB, uff.getIdServizioOffertoSportelloPerServer(4));
        }
    }
}
