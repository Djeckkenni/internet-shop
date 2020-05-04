package mate.acadamy.internetshop.security.impl;

import mate.acadamy.internetshop.exceptions.AuthenticationException;
import mate.acadamy.internetshop.inject.lib.Inject;
import mate.acadamy.internetshop.model.User;
import mate.acadamy.internetshop.security.AuthenticationService;
import mate.acadamy.internetshop.service.UserService;
import mate.acadamy.internetshop.service.lib.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Override
    public User login(String login, String password) throws AuthenticationException {
        User userFromDB = userService
                .findByLogin(login)
                .orElseThrow(() -> new AuthenticationException("Incorrect login or password"));
        if (userFromDB.getUserPassword().equals(password)) {
            return userFromDB;
        }
        throw new AuthenticationException("Incorrect login or password");
    }
}
