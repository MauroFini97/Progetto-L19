public interface WorkerInterface {
    /*
    il metodo seguente, quando setta lo stato su libero, farà il controllo sulle prenotazioni se sono
    finite o no, e se sono finite allora cambia automaticamente il servizio da offrire in base alle prenotazioni del momento
     */
    void setStato();
}
