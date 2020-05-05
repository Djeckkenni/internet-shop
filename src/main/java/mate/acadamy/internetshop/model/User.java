package mate.acadamy.internetshop.model;

import java.util.Objects;
import java.util.Set;

public class User {
    private Long userId;
    private String userName;
    private String userLogin;
    private String userPassword;
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

    @Override
    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if (!(ob instanceof User)) {
            return false;
        }
        User user = (User) ob;
        return Objects.equals(userId, user.userId)
                && Objects.equals(userName, user.userName)
                && Objects.equals(userLogin, user.userLogin)
                && Objects.equals(userPassword, user.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userLogin, userPassword);
    }

    @Override
    public String toString() {
        return "User{" + "userId="
                + userId + ", userName='"
                + userName + '\'' + ", userLogin='"
                + userLogin + '\'' + ", userPassword='"
                + userPassword + '\'' + '}';
    }
}

