package models;

import org.sql2o.Sql2o;

public class DatabaseManagement {
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/management","wecode","12345");

    static String connectionString = "jdbc:postgresql://ec2-174-129-43-40.compute-1.amazonaws.com:5432/d2fcj6tsr6jfsh";
    static Sql2o sql2o = new Sql2o(connectionString, "wtznrlbezawozu", "37fbcb77bfa5f876ca5c80061157210ffb9dce550b8234e3c6b3ae064ea4db35");
}
