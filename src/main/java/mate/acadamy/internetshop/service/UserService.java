package mate.acadamy.internetshop.service;

import java.util.Optional;
import mate.acadamy.internetshop.model.User;

public interface UserService extends GenericService<User, Long> {
    Optional<User> findByLogin(String login);
}
