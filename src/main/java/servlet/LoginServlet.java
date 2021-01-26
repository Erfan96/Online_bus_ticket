package servlet;


import entities.City;
import service.CityDao;
import util.JpaUtil;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        CityDao cityDao = new CityDao(entityManager);

        List<City> cityList = cityDao.getAllCities();
        req.setAttribute("list", cityList);
        req.getRequestDispatcher("search.jsp").forward(req, resp);
    }
}
