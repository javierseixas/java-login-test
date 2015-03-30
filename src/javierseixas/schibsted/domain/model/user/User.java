package javierseixas.schibsted.domain.model.user;

import java.util.Arrays;
import java.util.Iterator;
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
        Iterator<Role> iterator = rolesList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().roleName() == role) {
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
