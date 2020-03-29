package github.faisal6621.collections;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import github.faisal6621.bean.City;
import github.faisal6621.bean.Person;

/**
 * TestCollections
 */
public class TestCollections {

    public static void main(String[] args) {
        Person jitendra = new Person("Jitendra", LocalDate.of(1990, Month.JANUARY, 25));
        Person shivam = new Person("Shivam", LocalDate.of(1992, Month.AUGUST, 15));
        Person shashank = new Person("Shashank", LocalDate.of(1989, Month.MARCH, 10));
        Person mohak = new Person("Mohak", LocalDate.of(1990, Month.JULY, 17));
        Person nirved = new Person("Nirved", LocalDate.of(1986, Month.NOVEMBER, 14));
        Person lakshit = new Person("Lakshit", LocalDate.of(1991, Month.DECEMBER, 31));

        City delhi = new City("Delhi");
        City ghaziabad = new City("Ghaziabad");
        City agra = new City("Agra");
        City sitapur = new City("Sitapur");

        List<Person> persons = new ArrayList<>(Arrays.asList(jitendra, shivam, shashank, mohak, nirved, lakshit));

        persons.forEach(System.out::println); // Exercise 1

        boolean removed = persons.removeIf(person -> person.getDob().getYear() < 1990); // Exercise 2
        System.out.println("is some person removed: " + removed);
        System.out.println("Persons left after removing:");
        persons.forEach(System.out::println);

        System.out.println("Replacing all persons:");
        persons.replaceAll(person -> new Person(person.getName().toUpperCase(), person.getDob())); // Exercise 3
        persons.forEach(System.out::println);

        System.out.println("Sorting all persons:");
        persons.sort(Comparator.comparing(Person::getDob).reversed()); // Exercise 4
        persons.forEach(System.out::println);

        Map<City, List<Person>> m1 = new HashMap<>();
        System.out.println("People in Delhi: " + m1.getOrDefault(delhi, Collections.emptyList())); // Exercise 5

        System.out.println("People in group 1:");
        m1.putIfAbsent(delhi, new ArrayList<>());
        m1.get(delhi).add(lakshit); // Exercise 6.1

        m1.computeIfAbsent(sitapur, city -> new ArrayList<>()).add(jitendra); // Exercise 6.2
        m1.computeIfAbsent(sitapur, city -> new ArrayList<>()).add(shashank);
        m1.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("People in group 2:");
        Map<City, List<Person>> m2 = new HashMap<>();
        m2.computeIfAbsent(delhi, city -> new ArrayList<>()).add(mohak);
        m2.computeIfAbsent(ghaziabad, city -> new ArrayList<>()).add(nirved);
        m2.computeIfAbsent(agra, city -> new ArrayList<>()).add(shivam);
        m2.forEach((key, value) -> System.out.println(key + ": " + value));

        m1.forEach((city, personsInCity) -> {
            m2.merge(city, personsInCity, (existingPersons, newPersons) -> { // Exercise 7
                existingPersons.addAll(newPersons);
                return existingPersons;
            });
        });

        System.out.println("People in group 2 after merge:");
        m2.forEach((city, personsInCity) -> System.out.println(city + ": " + personsInCity));
    }
}
