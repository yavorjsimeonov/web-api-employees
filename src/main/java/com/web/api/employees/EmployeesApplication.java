package com.web.api.employees;

import com.web.api.employees.database.JdbcDatabaseRepository;
import com.web.api.employees.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileSystems;
import java.util.List;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class EmployeesApplication {

  private final static Logger logger = LoggerFactory.getLogger(EmployeesApplication.class.getName());

  private static String tmpdir = System.getProperty("java.io.tmpdir");
  private static String fileSeparator = FileSystems.getDefault().getSeparator();

  public static void main(String[] args) {
    SpringApplication.run(EmployeesApplication.class, args);
  }

}
