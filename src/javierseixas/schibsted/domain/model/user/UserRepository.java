package javierseixas.schibsted.domain.model.user;

public interface UserRepository {
    User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException;
}
