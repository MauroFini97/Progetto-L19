package codice.web;

import codice.dominio.ufficio.IdServizio;
import codice.sharedInterface.TerminaleUtente;
import org.rythmengine.Rythm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RythmApplication extends HttpServlet
{
    private String host;

    public RythmApplication(String host) {
        this.host = host;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException {
        //String name = request.getParameter("name");

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        if(request.getRequestURI().startsWith("/home")){
            write(response,Rythm.render("ufficio.html"));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().startsWith("/prenota")) {

            try {
                Registry registry = LocateRegistry.getRegistry(host);

                TerminaleUtente stubUtente = (TerminaleUtente) registry.lookup("utente");

                String idServizioPrenotato = req.getParameter("idservizio");
                IdServizio servizioPrenotato = IdServizio.valueOf(idServizioPrenotato);

                int numero = stubUtente.prenota(servizioPrenotato);
                int minutiDiAttesa = stubUtente.minutiMediDiAttesa(servizioPrenotato);


                write(resp,"Hai prenotato "+servizioPrenotato+"\n" +
                        "Numero: "+numero+"\n" +
                        "Tempo stimato di attesa: "+minutiDiAttesa+" minuti"+"\n" +
                        "Scarica la versione pdf del biglietto e mostrala all'addetto quando è il tuo turno");

            }catch (ConnectException e){
                write(resp,"L'ufficio è chiuso");
            }catch (NotBoundException n){
                n.printStackTrace();
            }

        }



    }

    private void write(HttpServletResponse resp, String message) throws IOException {
        resp.getWriter().write(message);
    }
}
