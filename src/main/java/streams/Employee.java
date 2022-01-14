package streams;

import java.util.Objects;

public class Employee {
    private String name;
    private Integer age;
    private Country country;

    private Employee(String name, Integer age, Country country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public static Employee fromRussia(String name, Integer age) {
        return new Employee(name, age, Country.RUSSIA);
    }

    public static Employee fromItaly(String name, Integer age) {
        return new Employee(name, age, Country.ITALY);
    }

    public static Employee fromFrance(String name, Integer age) {
        return new Employee(name, age, Country.FRANCE);
    }

    public static Employee fromUSA(String name, Integer age) {
        return new Employee(name, age, Country.USA);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(age, employee.age) && country == employee.country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, country);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country=" + country +
                '}';
    }
}
