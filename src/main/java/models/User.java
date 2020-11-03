package models;

public class User {

    private int id;
    private String name;
    private String userPosition;
    private String role;
    private int departmentId;

    public User(String name, String userPosition, String role, int departmentId) {
        this.name = name;
        this.userPosition = userPosition;
        this.role = role;
        this.departmentId = departmentId;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getUserPosition() {

        return userPosition;
    }

    public void setUserPosition(String userPosition) {

        this.userPosition = userPosition;
    }

    public String getRole() {

        return role;
    }

    public void setRole(String role) {

        this.role = role;
    }

    public int getDepartmentId() {

        return departmentId;
    }

    public void setDepartmentId(int departmentId) {

        this.departmentId = departmentId;
    }
}
