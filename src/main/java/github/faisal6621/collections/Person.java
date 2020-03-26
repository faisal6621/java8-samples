package github.faisal6621.collections;

import java.time.LocalDate;

/**
 * Person
 */
public class Person {

    private String name;
    private LocalDate dob;

    public Person() {
    }

    public Person(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Person [dob=" + dob + ", name=" + name + "]";
    }

}
