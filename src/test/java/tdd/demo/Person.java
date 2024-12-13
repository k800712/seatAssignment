package tdd.demo;

import java.util.Objects;

public class Person {


    public Person(String name) {
        this.name = name;
    }

    private String name;
    private int experience;
    private String job;

    public Person(int experience, String job, String name) {
        this.experience = experience;
        this.job = job;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public String getJob() {
        return job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return experience == person.experience && Objects.equals(name, person.name) && Objects.equals(job, person.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, experience, job);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", job='" + job + '\'' +
                '}';
    }
}
