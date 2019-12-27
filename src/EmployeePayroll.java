import java.util.ArrayList;
import java.util.List;

public class EmployeePayroll {
  public static void main(String[] args) {

    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee("A", 10.1));
    employees.add(new Employee("B", 30.1));
    employees.add(new Employee("C", 50.1));
    employees.add(new Employee("D", 40.1));
    employees.add(new Employee("E", 1.1));

//    Collections.sort(employees, (Employee e1, Employee e2) -> e1.getSalary().compareTo(e2.getSalary()));
//    employees.stream().forEach(i-> System.out.println(i));

// Anuj:: 1. Try to use method reference to further shorten it.
    // Anuj:: 2. Try to use good variable names instead of i, e1,e2.
//    employees.stream()
//        .sorted((e1, e2) -> e1.getSalary().compareTo(e2.getSalary()))
//        .forEach(i-> System.out.println("is: "+i));

    //Chethan: i have used method reference, but then i had to create additional static method for comparision
    //is adding additional method ok to use method reference?
    employees.stream()
        .sorted(Employee::compare)
        .forEach(i-> System.out.println("is: "+i));


    //only salary will be shown in output, not full object/entity
//    List<Double> sE = employees.stream()
//        .map(entity -> entity.getSalary())
//        .sorted()
//        .collect(Collectors.toList());
    //sE.stream().forEach(i-> System.out.println("salary: "+i));

  }
}

class Employee {

  String name;
  //Anuj: Why would you not use BigDecimal to represent salary? What are the limitations of Double? Explore as an exercise.
  //Chethan: I didn't know about BigDecimal, but now i read about that.
  Double salary;

  Employee(String name, Double salary) {
    this.name = name;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public static int compare(Employee sal1, Employee sal2) {
    return sal1.getSalary().compareTo(sal2.getSalary());
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", salary=" + salary +
        '}';
  }
}
