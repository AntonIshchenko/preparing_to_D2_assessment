package streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeLocalStorage {

   private static final List<Employee> employees = new ArrayList<>();

   private EmployeeLocalStorage() {}

   public static List<Employee> getListOfEmployees() {
      if (employees.isEmpty())
         return generateEmployees();
      else
         return employees;
   }

   private static List<Employee> generateEmployees() {
      employees.add(createEmployee("Ivan", "Ivanov", LocalDate.of(1986, 1, 1), EmployeeGender.MALE, JobPositions.DEVELOPER, 2));
      employees.add(createEmployee("Semen", "Kats", LocalDate.of(1983, 3, 27), EmployeeGender.MALE, JobPositions.CONSULTING, 6));
      employees.add(createEmployee("Egor", "Shubkin", LocalDate.of(1993, 5, 7), EmployeeGender.MALE, JobPositions.MANAGER, 9));
      employees.add(createEmployee("Leonid", "Baburin", LocalDate.of(1977, 2, 11), EmployeeGender.MALE, JobPositions.MANAGER, 8));
      employees.add(createEmployee("Timur", "Hohorin", LocalDate.of(1994, 11, 22), EmployeeGender.MALE, JobPositions.DEVELOPER, 8));
      employees.add(createEmployee("Emil", "Shapiro", LocalDate.of(1999, 7, 14), EmployeeGender.MALE, JobPositions.DEVELOPER, 10));
      employees.add(createEmployee("Izmail", "Spanov", LocalDate.of(1981, 9, 3), EmployeeGender.MALE, JobPositions.TEAM_MANAGER, 5));
      employees.add(createEmployee("Maksim", "Tsarev", LocalDate.of(1988, 6, 21), EmployeeGender.MALE, JobPositions.TESTER, 4));
      employees.add(createEmployee("Irina", "Titova", LocalDate.of(1994, 3, 3), EmployeeGender.FEMALE, JobPositions.DEVELOPER, 2));
      employees.add(createEmployee("Lidia", "Beria", LocalDate.of(1997, 5, 7), EmployeeGender.FEMALE, JobPositions.HR, 3));
      employees.add(createEmployee("Roza", "Vitinskaya", LocalDate.of(1974, 7, 6), EmployeeGender.FEMALE, JobPositions.HR, 10));
      employees.add(createEmployee("Irada", "Jakynina", LocalDate.of(1981, 2, 9), EmployeeGender.FEMALE, JobPositions.MANAGER, 2));
      employees.add(createEmployee("Emilia", "Sagadeeva", LocalDate.of(1975, 10, 28), EmployeeGender.FEMALE, JobPositions.DEVELOPER, 1));
      employees.add(createEmployee("Sofia", "Pankina", LocalDate.of(1977, 2, 18), EmployeeGender.FEMALE, JobPositions.TESTER, 8));
      employees.add(createEmployee("Izolda", "Verguna", LocalDate.of(1972, 5, 16), EmployeeGender.FEMALE, JobPositions.TEAM_MANAGER, 3));
      employees.add(createEmployee("Liana", "Samoshina", LocalDate.of(1977, 6, 6), EmployeeGender.FEMALE, JobPositions.DEVELOPER, 4));
      employees.add(createEmployee("Maja", "Shirokih", LocalDate.of(1985, 7, 20), EmployeeGender.FEMALE, JobPositions.MANAGER, 6));
      employees.add(createEmployee("Alex", "Duvanov", LocalDate.of(1998, 3, 19), EmployeeGender.OTHER, JobPositions.TESTER, 1));
      employees.add(createEmployee("Vadim", "Nevzorov", LocalDate.of(1991, 8, 11), EmployeeGender.MALE, JobPositions.CONSULTING, 5));
      return employees;
   }

   public static Employee getEmployee(String firsName,
         String secondName,
         LocalDate birthday,
         EmployeeGender gender,
         JobPositions jobPosition,
         Integer workExperience) {
      return createEmployee(firsName, secondName, birthday, gender, jobPosition, workExperience);
   }

   private static Employee createEmployee(
         String firsName,
         String secondName,
         LocalDate birthday,
         EmployeeGender gender,
         JobPositions jobPosition,
         Integer workExperience) {
      Employee employee = new Employee(firsName, secondName, birthday, gender);
      employee.setJobPosition(jobPosition);
      employee.setWorkExperience(workExperience);
      return employee;
   }

}
