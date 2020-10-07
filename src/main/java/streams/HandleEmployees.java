package streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandleEmployees implements Runnable {
   @Override
   public void run() {
      List<Employee> employees = EmployeeLocalStorage.getListOfEmployees();
      System.out.println("\n Вывести всех мужчин \n");
      employees.stream().filter(e -> e.getGender().equals(EmployeeGender.MALE)).forEach(System.out::println);
      System.out.println("\n Возраст от 25 до 30 \n");
      employees.stream().filter(e -> e.getAge() > 24 && e.getAge() < 31).forEach(System.out::println);
      System.out.println("\n отсортировать всех по опыту работы в естественном порядке \n");
      employees.stream().sorted(Comparator.comparing(Employee::getWorkExperience)).forEach(System.out::println);
      System.out.println("\n отсортировать всех по длине имени в обратном порядке \n");
      employees.stream().sorted((e1, e2) -> e2.getFirsName().length() - e1.getFirsName().length()).forEach(System.out::println);
      System.out.println("\n Вывести список имени и фамилии отсортированные по имени \n");
      employees.stream().map(e -> e.getFirsName() + " " + e.getSecondName()).sorted().forEach(System.out::println);
      boolean b1 = employees.stream().allMatch(e -> e.getFirsName().contains("z") || e.getSecondName().contains("t"));
      boolean b2 = employees.stream().anyMatch(e -> e.getFirsName().contains("z") || e.getSecondName().contains("t"));
      System.out.println("\n Есть ли во всех именах буквы z или фамилиях буква t? " + b1 + "\nЕсть ли в каких либо именах буквы z или фамилиях буква t? " + b2 + "\n");
      System.out.println("\n Вывести количество мужчин и женщин \n");
      System.out.println("Мужчин: " + employees.stream().filter(e -> e.getGender().equals(EmployeeGender.MALE)).count());
      System.out.println("Женщин: " + employees.stream().filter(e -> e.getGender().equals(EmployeeGender.FEMALE)).count());
      System.out.println("\n Вывести список работников через редьюс \n");
      employees.stream().map(e -> e.getFirsName() + " " + e.getSecondName()).reduce((e1, e2) -> e1 + "\n" + e2).ifPresent(System.out::println);
      System.out.println("\n Вывести список всех имен и фамилий по отделььности, отсортированных по алфавиту(параллельный стрим не упорядочен) \n");
      List<List<String>> list = new ArrayList<>();
      list.add(employees.stream().map(Employee::getFirsName).collect(Collectors.toList()));
      list.add(employees.stream().map(Employee::getSecondName).collect(Collectors.toList()));
      list.parallelStream().flatMap(Collection::stream).sorted().forEach(System.out::println);
      System.out.println("\n Вывести список всех имен и фамилий по отделььности, отсортированных по алфавиту(параллельный стрим упорядочен) \n");
      list.parallelStream().flatMap(Collection::stream).sorted().forEachOrdered(System.out::println);
      System.out.println("\n Создать стрим работников по имени иван, так чтобы у них возраст был числами Фибонначи \n");
      Stream.iterate(new Employee[] {
                  new Employee("Ivan", "Ivanov", LocalDate.now(), EmployeeGender.OTHER),
                  new Employee("Ivan", "Ivanov", LocalDate.now().minusYears(1), EmployeeGender.OTHER) },
            e -> new Employee[] {
                  new Employee("Ivan", "Ivanov", LocalDate.now().minusYears(LocalDate.now().compareTo(e[1].getBirthday())), EmployeeGender.OTHER),
                  new Employee("Ivan", "Ivanov", LocalDate.now().minusYears(LocalDate.now().compareTo(e[1].getBirthday()) + LocalDate.now().compareTo(e[0].getBirthday())), EmployeeGender.OTHER)
            }
      ).limit(15).map(e -> e[0]).forEach(System.out::println);
   }
}
