package servlet;

import entities.Travel;
import service.TravelDao;
import util.JpaUtil;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TravelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");


        Integer origin = Integer.valueOf(req.getParameter("origin"));
        Integer destination = Integer.valueOf(req.getParameter("destination"));
        String date = req.getParameter("date");

        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        TravelDao travelDao = new TravelDao(entityManager);

        if (date.length() == 10) {
            List<Travel> travels = travelDao.getTravels(origin, destination, date);
            HttpSession session = req.getSession();
            session.setAttribute("travels", travels);
            req.setAttribute("list", travels);
            req.getRequestDispatcher("travel.jsp").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("/login").include(req, resp);
        }
    }
}
