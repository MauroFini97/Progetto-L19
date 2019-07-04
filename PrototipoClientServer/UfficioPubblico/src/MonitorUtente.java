public class MonitorUtente implements TerminaleUtente {

    @Override
    public int prenota(IdServizio idServizio) {
        return ListaServizi.getInstance().prenota(idServizio);
    }
}
