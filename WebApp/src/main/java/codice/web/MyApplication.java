package codice.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyApplication extends HttpServlet {

    private List<String> names = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*if(names.isEmpty()) {
            write(resp, "empty");
        }
        else {
            write(resp, String.join(",", names));
        }*/

        write(resp,"<!DOCTYPE html>\n" +
                "<html>\n" +
                "\n" +
                "<head>\n" +
                "\t<style>\n" +
                "\t\n" +
                "\t<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n" +
                "\t\n" +
                "\t\n" +
                "\tinput[type=text], select {\n" +
                "  width: 100%;\n" +
                "  padding: 12px 20px;\n" +
                "  margin: 8px 0;\n" +
                "  display: inline-block;\n" +
                "  border: 1px solid #ccc;\n" +
                "  border-radius: 4px;\n" +
                "  box-sizing: border-box;\n" +
                "}\n" +
                "\n" +
                "input[type=submit] {\n" +
                "  width: 100%;\n" +
                "  background-color: #4CAF50;\n" +
                "  color: white;\n" +
                "  padding: 14px 20px;\n" +
                "  margin: 8px 0;\n" +
                "  border: none;\n" +
                "  border-radius: 4px;\n" +
                "  cursor: pointer;\n" +
                "}\n" +
                "\n" +
                "input[type=submit]:hover {\n" +
                "  background-color: #45a049;\n" +
                "}\n" +
                "\n" +
                "div {\n" +
                "  border-radius: 10px;\n" +
                "  background-color: #f2f2f2;\n" +
                "  padding: 20px;\n" +
                "}\n" +
                "\t\n" +
                "\t</style>\n" +
                "\n" +
                "\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "<h2>My Pizza</h2>\n" +
                "\n" +
                "<div>\n" +
                "\n" +
                "<form method=\"post\" action=\"/save\">\n" +
                "\n" +
                "  Nome completo:<br>\n" +
                "  <input type=\"text\" name=\"nome\">\n" +
                "  <br>\n" +
                "  Orario:<br>\n" +
                "  <input type=\"text\" name=\"ora\">\n" +
                "  <br>\n" +
                "  Pizza:<br>\n" +
                "   <select id=\"pizza\" name=\"pizza\">\n" +
                "      <option value=\"margherita\">Margherita</option>\n" +
                "      <option value=\"americana\">Americana</option>\n" +
                "      <option value=\"napoli\">Napoli</option>\n" +
                "    </select>\n" +
                "  <br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "  \n" +
                "</form>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>");

    }

    private String leggiFileHtml(String nomeFile) throws IOException{
        BufferedReader in= new BufferedReader(new FileReader(nomeFile));
        String completa=null;
        String file=null;

        while((completa=completa+in.readLine())!=null){
            //completa=completa+file;
        }
        in.close();
        return completa;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nome=req.getParameter("nome");
        String orario = req.getParameter("ora");
        String pizza = req.getParameter("pizza");
        //names.add(req.getParameter("nome"));

        write(resp, nome + "ha ordinato la pizza "+ pizza +" per le ore: "+ orario);
    }

    private void write(HttpServletResponse resp, String message) throws IOException {
        resp.getWriter().write(message);
    }
}
