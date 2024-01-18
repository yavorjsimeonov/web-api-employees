package com.web.api.employees.service;

import com.web.api.employees.EmployeesApplication;
import com.web.api.employees.database.JdbcDatabaseRepository;
import com.web.api.employees.model.Employee;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeesService {

  static Logger logger = Logger.getLogger(EmployeesApplication.class.getName());


  @Autowired
  JdbcDatabaseRepository jdbcDatabaseRepository;


  public List<Employee> getAllEmployees(){
    return jdbcDatabaseRepository.getAllEmployees();
  }

  public Employee getEmployeeById(String id){
    if (id == null) {
      throw new IllegalArgumentException("Missing employee id");
    }

    Employee employee = jdbcDatabaseRepository.findEmployeeById(id);

    return employee;
  }

  public int deleteEmployeeById(String id){
    if (id == null) {
      throw new IllegalArgumentException("Missing employee id");
    }

    return jdbcDatabaseRepository.deleteEmployeeById(id);
  }

}