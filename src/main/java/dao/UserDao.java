package dao;

import models.User;

import java.util.List;

public interface UserDao {
void add (User user);

List<User>getAll();
List<User>getAllUserByDepartment(int departmentId);

void deleteById(int id);
}
