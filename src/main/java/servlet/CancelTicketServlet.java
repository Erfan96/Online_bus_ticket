package servlet;

import service.TicketDao;
import util.JpaUtil;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CancelTicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String ticketId = req.getParameter("value");
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        TicketDao ticketDao = new TicketDao(entityManager);
        ticketDao.removeTicket(ticketId);
        req.getRequestDispatcher("/ticket").forward(req, resp);
    }
}
