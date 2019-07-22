import java.io.*;
import java.net.*;
import java.util.*;

public class Server extends Thread
{
    private ServerSocket Server;
    public static void main(String argv[]) throws Exception
    {
        new Server();
    }
    public Server() throws Exception
    {
        Server = new ServerSocket(4000);
        System.out.println("Il Server è in attesa sulla porta 4000.");
        this.start();
    }
    public void run()
    {
        while(true)
        {
            try {
                System.out.println("In attesa di Connessione.");
                Socket client = Server.accept();
                System.out.println("Connessione accettata da: "+
                        client.getInetAddress());
                Connect c = new Connect(client);
            }
            catch(Exception e) {}
        }
    }
}

class Connect extends Thread
{
    private Socket client = null;
    BufferedReader in = null;
    PrintStream out = null;
    public Connect() {}
    public Connect(Socket clientSocket)
    {
        client = clientSocket;
        try
        {
            in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            out = new PrintStream(client.getOutputStream(), true);
        }
        catch(Exception e1)
        {
            try { client.close(); }
            catch(Exception e) { System.out.println(e.getMessage());}
            return;
        }
        this.start();
    }
    public void run()
    {
        try
        {
            out.println("Pronto a ricevere messaggi");
            out.flush();
            String m;
            while(true){
                if((m=in.readLine()).equals("exit")){
                    out.println(client.getInetAddress()+ " stai per uscire dalla connessione");
                    break;
                }
                System.out.println("Messaggio dal client "+client.getInetAddress() +": "+m);

                out.println("Mandami un altro messaggio");

            }

            System.out.println("Connessione interrotta con il client: "+client.getInetAddress());

// chiude gli stream e le connessioni
            out.close();
            in.close();
            client.close();
        }
        catch(Exception e) {}
    }
}