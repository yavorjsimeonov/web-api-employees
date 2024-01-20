package com.web.api.employees;

import com.web.api.employees.database.JdbcDatabaseRepository;
import com.web.api.employees.model.Employee;
import com.web.api.employees.service.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Duration;
import java.util.Map;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class) // you can even removed it
@Testcontainers
public class WebApiProjectTests {

  @LocalServerPort
  private Integer port;

  @Autowired
  JdbcDatabaseRepository jdbcDatabaseRepository;

  @Autowired
  EmployeesService employeesService;

  static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.0.2")
      .withNetwork(Network
                       .NetworkImpl
                       .builder()
                    .createNetworkCmdModifier(
      cm -> cm.withOptions(Map.of("com.docker.network.bridge.host_binding_ipv4", "127.0.0.1")))
      .build())
      .withExposedPorts(3306)
            .withStartupTimeout(Duration.ofMinutes(1))
      .withConnectTimeoutSeconds(60);;

  Random random =  new Random();


  @BeforeAll
  static void beforeAll() {
    mySQLContainer.start();
  }

  @AfterAll
  static void afterAll() {
    mySQLContainer.stop();
  }

  @DynamicPropertySource
  static void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
    registry.add("spring.datasource.username", mySQLContainer::getUsername);
    registry.add("spring.datasource.password", mySQLContainer::getPassword);
  }

  @Test
  public void testAddEmployee(){
    Employee employee = createEmployeeObject();
    employeesService.addEmployee(employee);
    Employee adedEmployee = employeesService.getEmployeeById(employee.id);

    assertEquals(adedEmployee.id, employee.id);
    assertEquals(adedEmployee.firstName, employee.firstName);
    assertEquals(adedEmployee.lastName, employee.lastName);
    assertEquals(adedEmployee.email, employee.email);
  }

  @Test
  public void testGetEmployeeById(){
    Employee employee = createEmployeeObject();
    employeesService.addEmployee(employee);
    Employee testEmployee = employeesService.getEmployeeById(employee.id);

    assertEquals(testEmployee.id, employee.id);
    assertEquals(testEmployee.firstName, employee.firstName);
    assertEquals(testEmployee.lastName, employee.lastName);
    assertEquals(testEmployee.email, employee.email);
  }

  @Test
  public void testDeleteEmployeeById(){
    Employee employee = createEmployeeObject();
    employeesService.addEmployee(createEmployeeObject());
    assertNotNull(employeesService.getEmployeeById(employee.id));

    employeesService.deleteEmployeeById(employee.id);
    assertNull(employeesService.getEmployeeById(employee.id));
  }


  private Employee createEmployeeObject() {
    Employee employee = new Employee();
    employee.id = "1" + random.nextInt();
    employee.firstName = "ivan";
    employee.lastName = "marinov";
    employee.email = "ivanm@gmail.com";

    return employee;
  }
}
