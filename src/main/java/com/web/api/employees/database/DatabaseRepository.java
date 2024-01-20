package com.web.api.employees.database;

import com.web.api.employees.model.Employee;

import java.util.List;

public interface DatabaseRepository {

  Employee findEmployeeById(String employeeId);

  List<Employee> getAllEmployees();

  int deleteEmployeeById(String id);

  int addEmployee(String emloyeeId, String firstName, String lastName, String email);

  int updateEmployee(String emloyeeId, String firstName, String lastName, String email);
}
