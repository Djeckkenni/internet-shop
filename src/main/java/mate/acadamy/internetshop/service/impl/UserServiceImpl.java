package mate.acadamy.internetshop.service.impl;

import java.util.List;
import mate.acadamy.internetshop.dao.UserDao;
import mate.acadamy.internetshop.inject.lib.Inject;
import mate.acadamy.internetshop.model.User;
import mate.acadamy.internetshop.service.UserService;
import mate.acadamy.internetshop.service.lib.Service;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User get(Long userId) {
        return userDao.get(userId).get();
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean delete(Long userId) {
        return userDao.delete(userId);
    }
}
