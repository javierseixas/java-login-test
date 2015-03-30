package javierseixas.schibsted.infrastructure.controller;

import javierseixas.schibsted.application.service.LoginUser;
import javierseixas.schibsted.domain.model.user.User;
import javierseixas.schibsted.domain.model.user.UserNotFoundException;
import javierseixas.schibsted.domain.model.user.UserRepository;
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

        UserRepository userRepository = new InMemoryUserRepository();

        LoginUser loginUserService = new LoginUser(userRepository);

        User user = loginUserService.authenticate(username, password);

        if (user != null) {

            request.getSession().setAttribute("user", user);

            response.sendRedirect("/restricted/" + user.firstRole().roleName() + ".jsp");
            return;
        }

        request.setAttribute("loginError", "User not valid.");
        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // if authorized redirect to first role page NOT REQUIRED

        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }
}
