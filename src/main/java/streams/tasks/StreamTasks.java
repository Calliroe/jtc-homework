package streams.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTasks {
    public static void main(String[] args) {

        List<Employee> employeeList = makeEmployeeList();

//        Задача 1. Сгруппировать сотрудников по странам
//        Задача 2. Найти самых молодых сотрудников
//        Задача 3. Найти всех американских сотрудников
//        Задача 4. Вернуть список стран, в которых проживают сотрудники
//        Задача 5. Найти самых старых сотрудников в каждой стране

        Map<Country, List<Employee>> map1 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCountry));
        System.out.println("Группировка сотрудников по странам: " + map1);

        int minAge = employeeList.stream().min(Comparator.comparing(Employee::getAge)).orElseThrow().getAge();
        System.out.println("Список самых молодых сотрудников: ");
        employeeList.stream()
                .filter(employee -> employee.getAge() == minAge)
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("Список всех американских сотрудников: ");
        employeeList.stream()
                .filter(employee -> employee.getCountry().equals(Country.USA))
                .collect(Collectors.toList()).forEach(System.out::println);

        List<Country> list4 = employeeList.stream()
                .map(Employee::getCountry)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Список всех стран, в которых проживают сотрудники: " + list4);

        Map<Country, Optional<Employee>> uniqueEmloyeeMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCountry, Collectors.maxBy(Comparator.comparing(Employee::getAge))));
        List<Employee> suitableEmployees = employeeList.stream()
                .filter(employee -> employee.getAge().equals(uniqueEmloyeeMap.get(employee.getCountry()).get().getAge()))
                .collect(Collectors.toList());
        Map<Country, List<Employee>> m5 = suitableEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getCountry));
        System.out.println("Самые старые сотрудники в каждой стране: " + m5);

    }

    private static List<Employee> makeEmployeeList() {
        return List.of(
                Employee.fromFrance("FranceName1", 15),
                Employee.fromFrance("FranceName2", 18),
                Employee.fromFrance("FranceName3", 25),
                Employee.fromFrance("FranceName4", 32),
                Employee.fromFrance("FranceName5", 48),
                Employee.fromRussia("RussiaName1", 15),
                Employee.fromRussia("RussiaName2", 19),
                Employee.fromRussia("RussiaName3", 35),
                Employee.fromRussia("RussiaName4", 32),
                Employee.fromRussia("RussiaName5", 48),
                Employee.fromItaly("ItalyName1", 35),
                Employee.fromItaly("ItalyName2", 18),
                Employee.fromUSA("USAName1", 20),
                Employee.fromUSA("USAName2", 12),
                Employee.fromUSA("USAName3", 18)
        );
    }
}
