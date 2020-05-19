package mate.acadamy.internetshop.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class User {
    private Long userId;
    private String userName;
    private String userLogin;
    private String userPassword;
    private byte[] salts;
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public byte[] getSalts() {
        return salts;
    }

    public void setSalts(byte[] salts) {
        this.salts = salts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(userId, user.userId)
                && Objects.equals(userName, user.userName)
                && Objects.equals(userLogin, user.userLogin)
                && Objects.equals(userPassword, user.userPassword)
                && Arrays.equals(salts, user.salts)
                && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userId, userName, userLogin, userPassword, roles);
        result = 31 * result + Arrays.hashCode(salts);
        return result;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId
                + ", userName='" + userName + '\''
                + ", userLogin='" + userLogin + '\''
                + ", userPassword='" + userPassword + '\''
                + ", salts=" + Arrays.toString(salts)
                + ", roles=" + roles + '}';
    }
}

