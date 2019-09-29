import com.google.gson.Gson;
import dao.NewsDao;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Sql2o;
import java.sql.Connection;
import exceptions.ApiException;

import static spark.Spark.*;

public class App {
    public static void main(String[]args){
        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Sql2oUserDao userDao;
        Connection con;
        Gson gson = new Gson();

        staticFileLocation("/public");
        String connectionString="jdbc:postgresql://localhost:5432/management";
        Sql2o sql2o= new Sql2o(connectionString,"wecode","12345");

        departmentDao = new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
        con = (Connection) sql2o.open();


        post("/departments/:departmentId/news/:newsId", "application/json", (req, res) -> {

            int departmentId = Integer.parseInt(req.params("departmentId"));
            int newsId = Integer.parseInt(req.params("newsId"));
            Department department = departmentDao.findById(departmentId);
            News news = newsDao.findById(newsId);


            if (department != null && news != null) {
                //both exist and can be associated
                newsDao.addNewsToDepartment(news, department);
                res.status(201);
                return gson.toJson(String.format("Department '%s' and News '%s' have been associated", news.getDepNews(), department.getDepartmentName()));
            }
            else {
                throw new ApiException(404, String.format("Department or News does not exist"));
            }
        });

        get("/departments/:id/news", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            Department departmentToFind = departmentDao.findById(departmentId);
            if (departmentToFind == null) {
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            } else if (departmentDao.getAllNewsByDepartment(departmentId).size() == 0) {
                return "{\"message\":\"I'm sorry, but no news are listed for this department.\"}";
            } else {
                return gson.toJson(departmentDao.getAllNewsByDepartment(departmentId));
            }
        });

        get("/news/:id/departments", "application/json", (req, res) -> {
            int newsId = Integer.parseInt(req.params("id"));
            News newsToFind = newsDao.findById(newsId);
            if (newsToFind == null) {
                throw new ApiException(404, String.format("No news with the id: \"%s\" exists", req.params("id")));
            } else if (NewsDao.getAllDepartmentNews(newsId).size() == 0) {
                return "{\"message\":\"I'm sorry, but no departments are listed for this news.\"}";
            } else {
                return gson.toJson(newsDao.getAllDepartmentNews(newsId));
            }
        });

        post("/departments/:departmentId/users/new", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("departmentId"));
            User user = gson.fromJson(req.body(), User.class);

            user.setDepartmentId(departmentId);
            userDao.add(user);
            res.status(201);
            res.type("application/json");
            return gson.toJson(user);
        });

        post("/news/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.status(201);
            res.type("application/json");
            return gson.toJson(news);
        });

    }
}
