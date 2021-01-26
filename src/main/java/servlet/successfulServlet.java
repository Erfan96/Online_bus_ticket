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
import java.util.concurrent.atomic.AtomicLong;

public class successfulServlet extends HttpServlet {
    private static AtomicLong idCounter = new AtomicLong();

    static EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
    static TicketDao ticketDao = new TicketDao(entityManager);
    static Long count = ticketDao.countTickets();

    public static String createID()
    {
        return String.valueOf((idCounter.getAndIncrement()) + count + 1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String pName = req.getParameter("passengerName");
        String gender = req.getParameter("gender");
        Gender gen = Gender.valueOf(gender);
        HttpSession session = req.getSession();
        Travel travel = (Travel) session.getAttribute("chosen");

        String user = null;
        String pass = null;

        Cookie[] cookie = req.getCookies();
        for (Cookie cookies : cookie) {
            if (cookies.getName().equals("user")) {
                user = cookies.getValue();
            }
            else if(cookies.getName().equals("pass")) {
                pass = cookies.getValue();
            }
        }

        UserDao userDao = new UserDao(entityManager);
        User finalUser = userDao.getUserWithUsernameAndPassword(user, pass);

        String ticketId = createID();
        ticketDao.addTicket(pName, gen, travel, ticketId, finalUser);
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
