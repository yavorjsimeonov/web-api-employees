package com.web.api.employees.database;

import com.web.api.employees.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

  @Override
  public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

    Employee employee = new Employee();
    employee.id = rs.getString("id");
    employee.firstName = rs.getString("first_name");
    employee.lastName = rs.getString("last_name");
    employee.email = rs.getString("email");

    return employee;

  }
}
