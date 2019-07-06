public class MonitorUtente implements TerminaleUtente {


    /**
     *
     * @param idServizio
     * @return il numero di prenotazione del servizio scelto tramite l'id come parametro
     */
    @Override
    public int prenota(IdServizio idServizio) {
        return ListaServizi.getInstance().prenota(idServizio);
    }
}
