package tdd.demo;

import java.util.Objects;

public class Cat {

    private String nane;

    public Cat(String nane) {
        this.nane = nane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(nane, cat.nane);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nane);
    }
}
