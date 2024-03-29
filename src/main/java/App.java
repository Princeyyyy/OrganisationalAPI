import DAO.*;
import com.google.gson.Gson;
import models.Department;
import models.DepartmentNews;
import models.GeneralNews;
import models.User;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class App {

    public static void main(String[] args) {


        String connectionString = "jdbc:postgresql://localhost:5432/orgapi";
        Sql2o sql2o = new Sql2o(connectionString, "prince", "prince12");

        Sql2oGeneralNewsDAO generalNewsDAO = new Sql2oGeneralNewsDAO(sql2o);
        Sql2oDepartmentDAO departmentDAO = new Sql2oDepartmentDAO(sql2o);
        Sql2oUserDAO userDAO = new Sql2oUserDAO(sql2o);
        Sql2oDepartmentNewsDAO departmentNewsDAO = new Sql2oDepartmentNewsDAO(sql2o);

        Map<String, Object> model = new HashMap<>();
        Gson gson = new Gson();


        //           API   ROUTES
        get("/api/generalnews", (req, res) -> gson.toJson(generalNewsDAO.getAllGeneralNews()));

        get("/api/generalnews/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            return gson.toJson(generalNewsDAO.getGeneralNewsById(id));
        });

        get("/api/departmentnews", (req, res) -> gson.toJson(departmentNewsDAO.getAllDepartmentNews()));

        get("/api/departments", (req, res) -> {
            List<Department> departments = departmentDAO.getAllDepartments();
            for (Department department : departments) {
                int departmentId = department.getId();
                List<User> usersInDepartment = departmentDAO.getDepartmentUsersById(departmentId);
                department.setDepartmentUsers(usersInDepartment);
                department.setNoOfUsers(usersInDepartment.size());
                List<DepartmentNews> newsInDepartment = departmentDAO.getDepartmentNewsById(departmentId);
                department.setDepartmentNews(newsInDepartment);
            }
            return gson.toJson(departments);
        });

        get("/api/departments/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Department department = departmentDAO.getDepartmentById(id);
            int departmentId = department.getId();
            List<User> usersInDepartment = departmentDAO.getDepartmentUsersById(departmentId);
            department.setDepartmentUsers(usersInDepartment);
            department.setNoOfUsers(usersInDepartment.size());
            List<DepartmentNews> newsInDepartment = departmentDAO.getDepartmentNewsById(departmentId);
            department.setDepartmentNews(newsInDepartment);
            return gson.toJson(department);
        });


        //          UI ROUTES
        get("/", (req, res) -> {
            model.put("users", userDAO.getAllUsers());
            model.put("departments", departmentDAO.getAllDepartments());
            model.put("generalnews", generalNewsDAO.getAllGeneralNews());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/addgeneral", (req, res) -> {
            return new ModelAndView(model, "general-news-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/addgeneral", (req, res) -> {
            String title = req.queryParams("title");
            String content = req.queryParams("content");
            GeneralNews newGeneralNews = new GeneralNews(title, content);
            generalNewsDAO.add(newGeneralNews);
            model.put("generalnews", generalNewsDAO.getAllGeneralNews());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/adddepartment", (req, res) -> {
            return new ModelAndView(model, "department-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/adddepartment", (req, res) -> {
            String name = req.queryParams("name");
            String description = req.queryParams("description");
            Department newDepartment = new Department(name, description);
            departmentDAO.add(newDepartment);
            model.put("departments", departmentDAO.getAllDepartments());
            model.put("generalnews", generalNewsDAO.getAllGeneralNews());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/adduser", (req, res) -> {
            model.put("departments", departmentDAO.getAllDepartments());
            return new ModelAndView(model, "user-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/adduser", (req, res) -> {
            String name = req.queryParams("name");
            String position = req.queryParams("position");
            String role = req.queryParams("role");
            int departmentId = Integer.parseInt(req.queryParams("department"));
            User newUser = new User(name, position, role, departmentId);
            userDAO.add(newUser);
            model.put("users", userDAO.getAllUsers());
            model.put("departments", departmentDAO.getAllDepartments());
            model.put("generalnews", generalNewsDAO.getAllGeneralNews());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/adddepartmentnews", (req, res) -> {
            model.put("departments", departmentDAO.getAllDepartments());
            return new ModelAndView(model, "department-news-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/adddepartmentnews", (req, res) -> {
            String title = req.queryParams("title");
            String content = req.queryParams("content");
            int departmentId = Integer.parseInt(req.queryParams("department"));
            DepartmentNews newDepartmentNews = new DepartmentNews(title, content, departmentId);
            departmentNewsDAO.add(newDepartmentNews);
            model.put("departmentNews", departmentNewsDAO.getAllDepartmentNews());
            model.put("users", userDAO.getAllUsers());
            model.put("departments", departmentDAO.getAllDepartments());
            model.put("generalnews", generalNewsDAO.getAllGeneralNews());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
