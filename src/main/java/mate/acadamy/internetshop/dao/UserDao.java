package mate.acadamy.internetshop.dao;

import java.util.Optional;
import mate.acadamy.internetshop.model.User;

public interface UserDao extends GenericDao<User, Long> {

    Optional<User> findByLogin(String login);
}
