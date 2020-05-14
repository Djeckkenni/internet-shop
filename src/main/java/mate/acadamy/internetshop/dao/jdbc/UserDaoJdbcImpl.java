package mate.acadamy.internetshop.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import mate.acadamy.internetshop.dao.UserDao;
import mate.acadamy.internetshop.dao.lib.Dao;
import mate.acadamy.internetshop.exceptions.DataProcessingException;
import mate.acadamy.internetshop.model.Role;
import mate.acadamy.internetshop.model.User;
import mate.acadamy.internetshop.util.ConnectionUtil;

@Dao
public class UserDaoJdbcImpl implements UserDao {
    @Override
    public Optional<User> findByLogin(String login) {
        String query = "SELECT * FROM internet_shop.users WHERE login=?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getUserFromResultSet(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Getting of user with login="
                    + login + " is failed", e);
        }
    }

    @Override
    public User create(User user) {
        String query = "INSERT INTO internet_shop.users (name, login, password) "
                + "VALUES(?,?,?);";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserLogin());
            statement.setString(3, user.getUserPassword());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setUserId(resultSet.getLong(1));
            }
            addRolesForUser(user);
            return user;
        } catch (SQLException e) {
            throw new DataProcessingException("Creation of user is failed", e);
        }
    }

    @Override
    public Optional<User> get(Long id) {
        String query = "SELECT * FROM internet_shop.users WHERE user_id=?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getUserFromResultSet(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Getting of user with id="
                    + id + " is failed", e);
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM internet_shop.users;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(getUserFromResultSet(resultSet));
            }
            return users;
        } catch (SQLException e) {
            throw new DataProcessingException("Getting of list of users is failed", e);
        }
    }

    @Override
    public User update(User user) {
        String query = "UPDATE internet_shop.users "
                + "SET user_name=?, user_login=?, user_password=? WHERE user_id=?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserLogin());
            statement.setString(3, user.getUserPassword());
            statement.setLong(4, user.getUserId());
            statement.executeUpdate();
            deleteRolesOfUser(user);
            addRolesForUser(user);
            return user;
        } catch (SQLException e) {
            throw new DataProcessingException("Update of user with id="
                    + user.getUserId() + " is failed", e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "DELETE FROM internet_shop.users WHERE user_id=?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DataProcessingException("Delete of user with id="
                    + id + " is failed", e);
        }
    }

    public User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        Long userId = resultSet.getLong("user_id");
        String userName = resultSet.getString("name");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserLogin(login);
        user.setUserPassword(password);
        return user;
    }

    private void addRolesForUser(User user) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            for (Role role : user.getRoles()) {
                String query = "INSERT INTO internet_shop.users_roles (user_id, role_id)"
                        + "VALUES(?,?);";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setLong(1, user.getUserId());
                statement.setLong(2, role.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add role for user", e);
        }
    }

    private void deleteRolesOfUser(User user) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "DELETE FROM internet_shop.users_roles WHERE user_id=?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, user.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete roles of user", e);
        }
    }

    private Set<Role> getRolesOfUser(Long userId) {
        Set<Role> roles = new HashSet<>();
        String query = "SELECT roles.role_name FROM users_roles INNER JOIN roles "
                + "ON  users_roles.role_id=roles.role_id \n"
                + "WHERE users_roles.user_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                roles.add(Role.of(resultSet.getString("role_name")));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get roles of user", e);
        }
        return roles;
    }
}
