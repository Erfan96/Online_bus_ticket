package servlet;

import entities.Gender;
import entities.Travel;
import service.TicketDao;
import util.JpaUtil;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

public class successfulServlet extends HttpServlet {
    private static AtomicLong idCounter = new AtomicLong();

    static EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
    static TicketDao ticketDao = new TicketDao(entityManager);
    static Long count = ticketDao.countTickets();

    public static String createID()
    {
        return String.valueOf((idCounter.getAndIncrement()) + count);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String pName = req.getParameter("passengerName");
        String gender = req.getParameter("gender");
        Gender gen = Gender.valueOf(gender);
        HttpSession session = req.getSession();
        Travel travel = (Travel) session.getAttribute("chosen");

        String ticketId = createID();
        ticketDao.addTicket(pName, gen, travel, ticketId);
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
