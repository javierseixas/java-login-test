package javierseixas.schibsted.infrastructure.security;

import javierseixas.schibsted.domain.model.user.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthorizationUser implements Filter {

    FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        User user = (User) request.getSession().getAttribute("user");

        if (guardOnNotLogged(response, user)) return;

        String page = extractCurrentPage(request);

        if (guardOnNotAuthorized(response, user, page)) return;

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String extractCurrentPage(HttpServletRequest request) {
        String uri = request.getRequestURI();
        Pattern pattern = Pattern.compile("^[a-z\\/]+(page[\\d])\\.jsp*");
        Matcher matcher = pattern.matcher(uri);
        String page = "";
        if (matcher.find()) {
            page = matcher.group(1);
        }
        return page;
    }

    private boolean guardOnNotAuthorized(HttpServletResponse response, User user, String page) throws IOException {
        if (!user.hasRole(page)) {
            response.setStatus(403); // Find way to solve it
            response.sendRedirect("/forbidden.jsp");
            return true;
        }
        return false;
    }

    private boolean guardOnNotLogged(HttpServletResponse response, User user) throws IOException {
        if ( user == null) {
            response.sendRedirect("/login.jsp");
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
