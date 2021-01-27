package servlet;


import entities.City;
import entities.User;
import service.CityDao;
import service.UserDao;
import util.JpaUtil;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        CityDao cityDao = new CityDao(entityManager);

        String userName = null;
        String pass = null;

        Cookie[] cookie = req.getCookies();
        for (Cookie cookies : cookie) {
            if (cookies.getName().equals("user")) {
                userName = cookies.getValue();
            }
            else if(cookies.getName().equals("pass")) {
                pass = cookies.getValue();
            }
        }

        UserDao userDao = new UserDao(entityManager);
        User user = userDao.getUserWithUsernameAndPassword(userName, pass);
        HttpSession session = req.getSession();
        session.setAttribute("use", user);

        List<City> cityList = cityDao.getAllCities();
        req.setAttribute("list", cityList);
        req.getRequestDispatcher("search.jsp").forward(req, resp);
    }
}
