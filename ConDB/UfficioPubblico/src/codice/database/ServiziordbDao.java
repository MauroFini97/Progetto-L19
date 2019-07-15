package codice.database;

import codice.dominio.ufficio.IdServizio;

public class ServiziordbDao implements IServizioDAO {

    private RDBOperazioni operazioni;

    public ServiziordbDao() {
        this.operazioni = new RDBOperazioni();
    }

    @Override
    public void updateNumeroProgServizio(IdServizio idServizio) {
        operazioni.updateNumeroProgServizio(idServizio);
    }
}
