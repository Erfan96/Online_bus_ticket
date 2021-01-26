package servlet;

import entities.User;
import service.TicketDao;
import util.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("use");

        TicketDao ticketDao = new TicketDao(entityManager);
        List<Tuple> list = ticketDao.getDateAndId(user);

        req.setAttribute("list", list);
        req.getRequestDispatcher("ticket.jsp").forward(req, resp);
    }
}
