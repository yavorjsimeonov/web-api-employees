package com.web.api.employees.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee {
  public String id;
  public String firstName;
  public String lastName;
  public String email;
  public String position;
  public Map<String, Long> workedHoursPerDate = new HashMap<>();


  @Override
  public String toString() {
    return "Employee{" +
        "id='" + id + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", position='" + position + '\'' +
        ", workedHoursPerDate=" + workedHoursPerDate +
        '}';
  }
}
