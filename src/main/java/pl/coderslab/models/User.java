package pl.coderslab.models;

import org.mindrot.jbcrypt.BCrypt;

import java.util.StringJoiner;

public class User {

    private int id;
    private String userName;
    private String email;
    private String password;
    private int userGroupId;

    public User(String userName, String email, String password, int userGroupId) {
        this.userName = userName;
        this.email = email;
        this.hashPassword(password);
        this.userGroupId = userGroupId;
    }

    public User() {
    }

    public void hashPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(int userGroupId) {
        this.userGroupId = userGroupId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userName='" + userName + "'")
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("groupId=" + userGroupId)
                .toString();
    }
}
