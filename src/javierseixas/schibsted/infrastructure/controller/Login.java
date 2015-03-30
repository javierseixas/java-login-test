package javierseixas.schibsted.infrastructure.controller;

import javierseixas.schibsted.application.service.LoginUser;
import javierseixas.schibsted.infrastructure.persistence.InMemoryUserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username, password;

        username = request.getParameter("username");
        password = request.getParameter("password");

        LoginUser loginUserService = new LoginUser(new InMemoryUserRepository());

        boolean authenticationResult = loginUserService.authenticate(username, password);

        if (authenticationResult) {
            response.sendRedirect("authenticated.jsp");
            return;
        }

        response.sendRedirect("login.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
