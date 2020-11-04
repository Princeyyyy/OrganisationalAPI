import com.google.gson.Gson;
import DAO.Sql2oGeneralNewsDAO;
import models.GeneralNews;
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

        Map<String, Object> model = new HashMap<>();
        Gson gson = new Gson();


        //           API   ROUTES
        get("/api/generalnews", (req, res) -> {
            return gson.toJson(generalNewsDAO.getAllGeneralNews());
        });

        get("/api/generalnews/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            return gson.toJson(generalNewsDAO.getGeneralNewsById(id));
        });


        //          UI ROUTES
        get("/", (req, res) -> {
            model.put("generalnews", generalNewsDAO.getAllGeneralNews());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/addgeneral", (req, res) -> {
            return new ModelAndView(model, "general-news-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/addgeneral", (req, res) -> {
            String title = req.queryParams("title");
            String content = req.queryParams("content");
            GeneralNews newGeneralNews = new GeneralNews(title,content);
            generalNewsDAO.add(newGeneralNews);
            model.put("generalnews",generalNewsDAO.getAllGeneralNews());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
