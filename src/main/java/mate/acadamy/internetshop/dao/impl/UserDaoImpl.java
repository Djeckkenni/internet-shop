package mate.acadamy.internetshop.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import mate.acadamy.internetshop.dao.UserDao;
import mate.acadamy.internetshop.dao.lib.Dao;
import mate.acadamy.internetshop.db.Storage;
import mate.acadamy.internetshop.model.User;

@Dao
public class UserDaoImpl implements UserDao {
    @Override
    public User create(User user) {
        Storage.addUser(user);
        return user;
    }

    @Override
    public Optional<User> get(Long userId) {
        return Storage.users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public List<User> getAll() {
        return Storage.users;
    }

    @Override
    public User update(User user) {
        IntStream.range(0, Storage.users.size())
                .filter(index -> Storage.users.get(index).getUserId().equals(user.getUserId()))
                .forEach(index -> Storage.users.set(index, user));
        return user;
    }

    @Override
    public boolean delete(Long userId) {
        return Storage.users.removeIf(user -> user.getUserId().equals(userId));
    }
}
