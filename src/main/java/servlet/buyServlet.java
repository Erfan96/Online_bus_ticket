package servlet;

import entities.Travel;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class buyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        List<Travel> list = (List<Travel>) session.getAttribute("travels");

        for (Travel travel : list) {
            if (req.getParameter(travel.getTravelId()) != null) {
                session.setAttribute("chosen", travel);
                req.getRequestDispatcher("buy.jsp").forward(req, resp);
            }
        }

    }
}
