package models;

import java.util.List;

public class Department {

    private int id;
    private String departmentName;
    private String description;
    private List<User> departmentUsers;
    private int noOfUsers;
    private List<DepartmentNews> departmentNews;

    public Department(String departmentName, String description) {
        this.departmentName = departmentName;
        this.description = description;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getDepartmentName() {

        return departmentName;
    }

    public void setDepartmentName(String departmentName) {

        this.departmentName = departmentName;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public List<User> getDepartmentUsers() {

        return departmentUsers;
    }

    public void setDepartmentUsers(List<User> departmentUsers) {

        this.departmentUsers = departmentUsers;
    }

    public int getNoOfUsers() {

        return noOfUsers;
    }

    public void setNoOfUsers(int noOfUsers) {

        this.noOfUsers = noOfUsers;
    }

    public List<DepartmentNews> getDepartmentNews() {

        return departmentNews;
    }

    public void setDepartmentNews(List<DepartmentNews> departmentNews) {

        this.departmentNews = departmentNews;
    }
}
