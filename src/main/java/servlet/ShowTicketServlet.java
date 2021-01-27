package servlet;

import service.TicketDao;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ShowTicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        TicketDao ticketDao = new TicketDao(entityManager);
        String ticketId = req.getParameter("value");

        //PrintWriter out = resp.getWriter();
        List<Tuple> list = ticketDao.getDetailsOfTicket(ticketId);
        req.setAttribute("list", list);
        req.getRequestDispatcher("detailTicket.jsp").forward(req, resp);

    }
}
