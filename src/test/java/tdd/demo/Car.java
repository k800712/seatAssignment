package tdd.demo;

import java.util.Objects;

public class Car {

    private String brand;
    private String number;
    private int old;
    private int MileAge;

    public Car(String brand, String number, int old, int mileAge) {
        this.brand = brand;
        this.number = number;
        this.old = old;
        this.MileAge = mileAge;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public int getMileAge() {
        return MileAge;
    }

    public void setMileAge(int mileAge) {
        MileAge = mileAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return old == car.old && MileAge == car.MileAge && Objects.equals(brand, car.brand) && Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, number, old, MileAge);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", number='" + number + '\'' +
                ", old=" + old +
                ", MileAge=" + MileAge +
                '}';
    }
}

