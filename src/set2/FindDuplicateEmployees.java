//Given an array of employees where Employee class has following attributes:
// ID, Name, Department, Salary; write a program to remove duplicate employees.
// Duplicate employees are those whose IDs are same. (Complexity desired : O(n))

package set2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindDuplicateEmployees {

  public static void main(String[] args) {

    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee(111, "Chethan", "supply chain", BigDecimal.valueOf(3000)));
    employeeList.add(new Employee(112, "Saransh", "supply chain", BigDecimal.valueOf(2000)));
    employeeList.add(new Employee(113, "Revan", "finance", BigDecimal.valueOf(1000)));
    employeeList.add(new Employee(101, "ranabir", "property", BigDecimal.valueOf(10000)));
    employeeList.add(new Employee(101, "shyam", "property", BigDecimal.valueOf(10000)));
    employeeList.add(new Employee(111, "amar", "online", BigDecimal.valueOf(8000)));

    System.out.println("employee list" + employeeList);

    Set<Employee> s = new TreeSet<>(employeeList);
    System.out.println("Set employee list" + s);

//    HashSet doesn't remove duplicates
//    Set<Employee> s1 = new HashSet<>(employeeList);
//    System.out.println("Set employee list" + s1);

  }

}

class Employee implements Comparable<Employee> {

  int id;
  String name;
  String department;
  BigDecimal salary;

  public Employee(int id, String name, String department, BigDecimal salary) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "\nEmployee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", department='" + department + '\'' +
        ", salary=" + salary +
        '}';
  }

  @Override
  public int compareTo(Employee e) {

//    Chethan: compare based on employee id
    if(this.id == e.id)
      return 0;
    else
      return this.id > e.id? 1:-1;

//    Chethan: compare based on salary
//    if(this.salary.compareTo(e.salary) == 0)
//      return 0;
//    else if(this.salary.compareTo(e.salary) == 1)
//      return 1;
//    else
//      return -1;
  }

}
