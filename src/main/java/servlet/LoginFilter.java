package servlet;


import service.UserDao;
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

        try(PrintWriter out = servletResponse.getWriter()) {

            String username = servletRequest.getParameter("userName");
            String password = servletRequest.getParameter("password");

            if (UserDao.checkUser(username, password)) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
            else {
                out.println("Username or password is not correct!");
                servletRequest.getRequestDispatcher("login.jsp").include(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
