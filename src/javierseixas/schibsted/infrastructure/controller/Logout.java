package javierseixas.schibsted.infrastructure.controller;

import javierseixas.schibsted.application.service.LogoutUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LogoutUser logoutUserService = new LogoutUser();

        logoutUserService.logout(request.getSession());

        response.sendRedirect("/login");
    }
}
