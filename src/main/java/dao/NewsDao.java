package dao;

import models.Department;
import models.News;

import java.util.List;

public interface NewsDao {
    void add(News news);
    void addNewsToDepartment(News news, Department department);

    List<News>getAll();
    News findById(int id);

    List<Department> getAllDepartmentNews(int id);

    void deleteById(int id);
    void clearAll();
}
