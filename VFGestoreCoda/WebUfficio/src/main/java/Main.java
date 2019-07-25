

public class Main {
    public static void main(String[] args) throws Exception {
        String host="192.168.43.234";
        new ApplicationServer(8282, new RythmApplication())
                .withRythm()
                .start();
    }
}
