package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.sql.ordering.antlr.Factory;

import ServiceMetier.ServiceMetier;
import ServiceMetier.ServiceMetierImpl;
import jpa.JpaTest;
import domain.Utilisateur;

@WebServlet(name = "userinfo", urlPatterns = { "/UserInfo" })
public class UserInfo extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations</H1>\n" + "<UL>\n" + " <LI>Nom: "
                + request.getParameter("name") + "\n" + " <LI>Prenom: " + request.getParameter("firstname") + "\n"
                + " <LI>Age: " + request.getParameter("age") + "\n" + "</UL>\n" + "</BODY></HTML>");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding( "UTF-8" );
        PrintWriter out = resp.getWriter();

        //ServletOutputStream out = resp.getOutputStream();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();

        List<Utilisateur> users =  manager
                .createQuery("select u from User u", Utilisateur.class)
                .getResultList();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\" />");
        out.println("<title>Resultats</title>");
        out.println("</head>");
        out.println("<body>");

        for(Utilisateur use : users) {
            out.println(use.getNom());
            out.println(use.getEmail());
        }

        out.println("</body>");
        out.println("</html>");
        out.flush();
    }
}
