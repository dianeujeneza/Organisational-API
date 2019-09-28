package dao;

import models.Department;
import models.News;

import java.util.List;

public interface DepartmentDao {
    void add(Department department);

    List<Department>getAll();
    Department findById(int id);
    List<News> getAllNewsByDepartment(int departmentId);

    void deleteById(int id);
    void clearAll();
}
