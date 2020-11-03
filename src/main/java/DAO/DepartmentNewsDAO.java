package DAO;

import models.DepartmentNews;

import java.util.List;

public interface DepartmentNewsDAO {

    void add(DepartmentNews departmentNews);

    List<DepartmentNews> getAllDepartmentNews();

    DepartmentNews getDepartmentNewsById(int id);

}
