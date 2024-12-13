package tdd.demo;

import java.util.Objects;

public class Cat {

    private String nane;
    private double weight;
    private int age;
    private String nickname;


    public Cat(double weight, int age, String nane) {
        this.weight = weight;
        this.age = age;
        this.nane = nane;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public Cat(String nane) {
        this.nane = nane;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Double.compare(weight, cat.weight) == 0 && age == cat.age && Objects.equals(nane, cat.nane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nane, weight, age);
    }
}
