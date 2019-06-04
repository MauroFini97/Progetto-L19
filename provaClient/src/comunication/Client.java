package comunication;


import java.io.*;
import java.net.*;
import java.util.*;

public class Client
{
    public static void main(String argv[])
    {
        BufferedReader in = null;
        PrintStream out = null;
        Socket socket = null;
        String message, m;
        String server = "192.168.6.29";
        try
        {
            // open a socket connection
            socket = new Socket(server, 4000);
            // Apre i canali I/O
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            m = "a";
            while(true) {
                if(m.equals("exit")) {
                    break;
                }
                // Scrivo al server
                System.out.println("\nMessaggio Inviato: ");
                m = sc.nextLine();
                out.println(m);
                out.flush();
                // Legge dal server
                message = in.readLine();
                System.out.print(server + " ha inviato un messaggio: " + message);
            }
            out.close();
            in.close();
        }
        catch(Exception e) { System.out.println(e.getMessage());}
    }
}
