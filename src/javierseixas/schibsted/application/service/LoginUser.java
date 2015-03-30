package javierseixas.schibsted.application.service;

import javierseixas.schibsted.domain.model.user.User;
import javierseixas.schibsted.domain.model.user.UserNotFoundException;
import javierseixas.schibsted.domain.model.user.UserRepository;

public class LoginUser {

    private UserRepository userRepository;

    public LoginUser(UserRepository inMemoryUserRepository) {
        userRepository = inMemoryUserRepository;
    }

    public User authenticate(String username, String password) {

        try {
            return userRepository.findUserByUsernameAndPassword(username, password);
        } catch (UserNotFoundException exception) {
            return null;
        }

    }
}
