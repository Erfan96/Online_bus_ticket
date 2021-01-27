package servlet;

import entities.Gender;
import entities.Travel;
import entities.User;
import service.TicketDao;
import service.UserDao;
import util.JpaUtil;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;


public class SuccessfulServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        TicketDao ticketDao = new TicketDao(entityManager);
        String pName = req.getParameter("passengerName");
        String gender = req.getParameter("gender");
        Gender gen = Gender.valueOf(gender);
        HttpSession session = req.getSession();
        Travel travel = (Travel) session.getAttribute("chosen");


        User user = (User) session.getAttribute("use");

        String ticketId = String.valueOf(UUID.randomUUID());
        ticketDao.addTicket(pName, gen, travel, ticketId, user);
        String type = maleOrFemale(gender);
        req.setAttribute("type", type);
        req.setAttribute("passenger", pName);
        req.setAttribute("id", ticketId);
        req.getRequestDispatcher("successful.jsp").forward(req, resp);
    }

    public String maleOrFemale(String gender) {
        if (gender.equals("MALE")) {
            return "Mr.";
        }
        return "Mrs.";
    }
}
