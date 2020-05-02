package mate.acadamy.internetshop.security;

import mate.acadamy.internetshop.exceptions.AuthenticationException;
import mate.acadamy.internetshop.model.User;

public interface AuthenticationService {
    User login(String login, String password) throws AuthenticationException;
}
