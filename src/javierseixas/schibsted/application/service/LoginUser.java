package javierseixas.schibsted.application.service;

import javierseixas.schibsted.domain.model.user.User;
import javierseixas.schibsted.domain.model.user.UserNotFoundException;
import javierseixas.schibsted.domain.model.user.UserRepository;

public class LoginUser {

    private UserRepository userRepository;

    public LoginUser(UserRepository inMemoryUserRepository) {
        userRepository = inMemoryUserRepository;
    }

    public boolean authenticate(String username, String password) {

        try {
            User user = userRepository.findUserByUsernameAndPassword(username, password);
            return true;
        } catch (UserNotFoundException e) {
            return false;
        }


//        if (password == null || password.trim() == "") {
//            return false;
//        }

//        return true;
    }
}
