package models;

import java.util.Objects;

public class Department {
private int id;
private String departmentName;
private int employeesNumber;
private String departmentDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return getId() == that.getId() &&
                getEmployeesNumber() == that.getEmployeesNumber() &&
                getDepartmentName().equals(that.getDepartmentName()) &&
                getDepartmentDescription().equals(that.getDepartmentDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDepartmentName(), getEmployeesNumber(), getDepartmentDescription());
    }
}
