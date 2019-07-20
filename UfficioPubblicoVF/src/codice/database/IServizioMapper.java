package codice.database;

import codice.dominio.ufficio.IdServizio;
import codice.dominio.ufficio.Servizio;

import java.util.ArrayList;

public interface IServizioMapper {
    Servizio get(IdServizio idServizio);
    boolean update(IdServizio idServizio);

    ArrayList<Servizio> restore();
    void refresh();
}
