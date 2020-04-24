package mate.acadamy.internetshop.service;

import java.util.List;
import mate.acadamy.internetshop.model.User;

public interface UserService {
    User create(User user);

    User get(Long userId);

    boolean delete(Long userId);

    User update(User user);

    List<User> getAll();
}
