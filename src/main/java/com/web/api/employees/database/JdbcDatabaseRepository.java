package com.web.api.employees.database;

import com.web.api.employees.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcDatabaseRepository implements DatabaseRepository {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public Employee findEmployeeById(String employeeId) {
    String sql = "select * from employee where id = ?";

    return jdbcTemplate.queryForObject(sql, new Object[]{employeeId}, new EmployeeRowMapper());
  }
  @Override
  public List<Employee> getAllEmployees(){

    String sql = "select * from employee";


    return jdbcTemplate.query(sql,  new EmployeeRowMapper());
  }

  @Override
  public int deleteEmployeeById(String employeeId) {
    String sql = "delete from employee where id = ?";

    return jdbcTemplate.update(sql, new Object[]{employeeId});
  }

  @Override
  public int addEmployee(String employeeId, String firstName, String lastName, String email) {

    String sql = "insert into employee (id, first_name, last_name, email) values(?, ?, ?, ?)";

    return jdbcTemplate.update(sql, new Object[]{employeeId, firstName, lastName, email});
  }

  @Override
  public int updateEmployee(String employeeId, String firstName, String lastName, String email) {

    String sql = "update employee set first_name = ?, last_name = ?, email = ? where id = ?";

    return jdbcTemplate.update(sql, new Object[]{firstName, lastName, email, employeeId});
  }

}
