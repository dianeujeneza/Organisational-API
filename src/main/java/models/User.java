package models;

import java.util.Objects;

public class User {
    private int userId;
    private String userName;
    private String userPosition;
    private int departmentId;

    public User(String userName, String userPosition, int departmentId) {
        this.userName = userName;
        this.userPosition = userPosition;
        this.departmentId = departmentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserId() == user.getUserId() &&
                getDepartmentId() == user.getDepartmentId() &&
                getUserName().equals(user.getUserName()) &&
                getUserPosition().equals(user.getUserPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUserName(), getUserPosition(), getDepartmentId());
    }

}
