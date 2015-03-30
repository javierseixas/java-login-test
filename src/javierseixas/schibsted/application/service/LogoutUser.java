package javierseixas.schibsted.application.service;

import javax.servlet.http.HttpSession;

public class LogoutUser {
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
