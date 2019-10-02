import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main(String[]args){
        staticFileLocation("/public");

        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"home.hbs");
        },new HandlebarsTemplateEngine());

        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Sql2oUserDao userDao;

        String connectionString="jdbc:postgresql://localhost:5432/management";
        Sql2o sql2o= new Sql2o(connectionString,"wecode","12345");


       departmentDao= new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);

        get("/newsForm", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newsForm.hbs");
        },new HandlebarsTemplateEngine());

        get("/depForm", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "depForm.hbs");
        },new HandlebarsTemplateEngine());

        get("/userForm", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "userForm.hbs");
        },new HandlebarsTemplateEngine());

        post("/new/newsForm", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            String depNews = req.queryParams("depNews");
            News newNews = new News(depNews);
            newsDao.add(newNews);
            return new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());


        post("/new/userForm", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String userName = req.queryParams("userName");
            String userPosition = req.queryParams("userPosition") ;
            int departmentId = Integer.parseInt(req.queryParams("departmentId"));
            User newUser = new User(userName, userPosition,departmentId);
            userDao.add(newUser);
            return new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());

        get("/userForm", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<User> allUsers = userDao.getAll();
            model.put("users", allUsers);
            return new ModelAndView(model, "userForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/new/depForm",(req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String departmentName = req.queryParams("departmentName") ;
            String departmentDescription = req.queryParams("departmentDescription") ;
            int employeesNumber = Integer.parseInt(req.queryParams("employeesNumber"));
            Department newDepartment = new Department(departmentName, departmentDescription,employeesNumber);
            departmentDao.add(newDepartment);
            return new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());

        get("/depForm", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Department> allDepartment = departmentDao.getAll();
            model.put("departments", allDepartment);
            return new ModelAndView(model, "depForm.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
