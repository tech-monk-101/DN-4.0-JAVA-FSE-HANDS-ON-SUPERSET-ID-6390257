package com.cognizant.hibernate;


public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Ruchika Bhati");
        emp.setDepartment("Contractor");

        EmployeeDAO dao = new EmployeeDAO();
        Integer id = dao.addEmployee(emp);

        System.out.println("Employee ID: " + id);
    }
}
