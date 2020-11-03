package DAO;

import models.Department;
import models.DepartmentNews;
import models.User;

import java.util.List;

public interface DepartmentDAO {

    void add(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(int id);

    List<DepartmentNews> getDepartmentNewsById(int id);

    List<User> getDepartmentUsersById(int id);
}
