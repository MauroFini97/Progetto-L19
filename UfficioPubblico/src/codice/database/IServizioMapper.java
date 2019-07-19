package codice.database;

import codice.dominio.ufficio.IdServizio;
import codice.dominio.ufficio.Servizio;

public interface IServizioMapper {
    Servizio get(IdServizio idServizio);
    boolean update(IdServizio idServizio);
}
