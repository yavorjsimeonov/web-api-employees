package com.web.api.employees.rest;

import com.web.api.employees.model.Employee;
import com.web.api.employees.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeesRestController {


  @Autowired
  EmployeesService employeesService;

  @GetMapping("/ping")
  @ResponseBody
  public String ping(@RequestParam(value = "myName", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }

  @GetMapping("/employees")
  public List<Employee> getAllEmployees(){
    return employeesService.getAllEmployees();
  }

  @GetMapping("/employees/{id}")
  public Employee getEmployeeById(@PathVariable String id){

    Employee employee = employeesService.getEmployeeById(id);

    return employee;
  }

  @DeleteMapping("/employees/{id}")
  public int deleteEmployeeById(@PathVariable String id){
    return employeesService.deleteEmployeeById(id);
  }

  @PostMapping("/employees")
  public int addEmployee(@RequestBody Employee employee){
    return employeesService.addEmployee(employee);
  }

  @PutMapping("/employees")
  public int updateEmployee(@RequestBody Employee employee){
    return employeesService.updateEmployee(employee);
  }

}
