package servlet;


import service.UserDao;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");

        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();

        try(PrintWriter out = servletResponse.getWriter()) {

            UserDao userDao = new UserDao(entityManager);
            String username = servletRequest.getParameter("userName");
            String password = servletRequest.getParameter("password");

            if (userDao.checkUser(username, password)) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
            else {
                out.println("Username or password is not correct!");
                servletRequest.getRequestDispatcher("login.jsp").include(servletRequest, servletResponse);
            }
        }
        finally {
            entityManager.close();
            JpaUtil.Shutdown();
        }
    }

    @Override
    public void destroy() {

    }
}
