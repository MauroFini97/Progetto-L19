public class Servizio {
    private IdServizio id;
    private Coda codaServizio;

    public Servizio(IdServizio id) {
        this.id = id;
        this.codaServizio = new Coda();
    }

    public IdServizio getId() {
        return id;
    }

    public int prenota(){
        return codaServizio.prenota();
    }

    @Override
    public String toString() {
        return "Servizio{" +
                "id=" + id +
                ", codaServizio=" + codaServizio +
                '}';
    }
}
