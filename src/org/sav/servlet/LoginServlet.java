package org.sav.servlet;

import org.sav.dao.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends GenericServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if(LoginDao.getInstance().login(name, password)){
            request.getSession().setAttribute("LogedUser", name);
            forward("main.jsp", request, response);
        } else {
            request.setAttribute("loginFailes", Boolean.TRUE);
            request.setAttribute("name", name);
            forward("login.jsp", request, response);
        }
    }

}
