package javierseixas.schibsted.infrastructure.persistence;

import javierseixas.schibsted.domain.model.user.Role;
import javierseixas.schibsted.domain.model.user.User;
import javierseixas.schibsted.domain.model.user.UserNotFoundException;
import javierseixas.schibsted.domain.model.user.UserRepository;

import java.util.ArrayList;
import java.util.Iterator;

public class InMemoryUserRepository implements UserRepository {

    private ArrayList<User> users;

    public InMemoryUserRepository() {

        users = new ArrayList<User>();

        users.add(new User("user1", "pass1", new Role[] {new Role("page1", "page1")}));
        users.add(new User("user2", "pass2", new Role[] {new Role("page2", "page2")}));
        users.add(new User("user3", "pass3", new Role[] {new Role("page3", "page3")}));
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.username().equals(username) && user.password().equals(password)) {
                return user;
            }
        }

        throw new UserNotFoundException("Credentials incorrect");
    }
}
