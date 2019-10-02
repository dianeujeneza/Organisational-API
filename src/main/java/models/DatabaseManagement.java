package models;

import org.sql2o.Sql2o;

public class DatabaseManagement {
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/management","wecode","12345");

    String connectionString = "jdbc:postgresql://ec2-107-22-228-141.compute-1.amazonaws.com:5432/dclp5qqigbb7lf"; //!
    Sql2o sql2o = new Sql2o(connectionString, "ybievxciuetcbe", "9a2d22ef6e34fd63b840ca9388228353614614baf8aca067cd2b9df22b4ba716"); //!
}
