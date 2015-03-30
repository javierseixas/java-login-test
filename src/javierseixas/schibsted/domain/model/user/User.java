package javierseixas.schibsted.domain.model.user;

import java.util.Arrays;
import java.util.List;

public class User {
    private String username, password;
    private Role[] roles;

    public User(String username, String password, Role[] roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public boolean hasRole(String role) {
        List<Role> rolesList = Arrays.asList(roles);
        for (int i = 0; i < rolesList.size(); i++) {
            if (rolesList.get(i).pageKey().equals(role)) {
                return true;
            }
        }

        return false;
    }

    public Role firstRole() {
        List<Role> rolesList = Arrays.asList(roles);
        return rolesList.get(0);
    }
}
