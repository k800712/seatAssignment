package tdd.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class CarTest {

    @Test
    void findOldestCarsTest() {

        List<Car> give = List.of(new Car("현대", "12가3456", 2018, 99000),
                new Car("대우", "14나1457", 2019, 56987),
                new Car("벤츠", "15다1245", 2024, 10000));
        List<Car> when = List.of(new Car("현대", "12가3456", 2018, 99000));
        List<Car> result = findOldestCars(give);

        Assertions.assertThat(result).isEqualTo(when);
    }
    private List<Car> findOldestCars(List<Car> give) {

        int findOldestCars = give.stream()
                .mapToInt(Car::getOld)
                .min()
                .orElseThrow();

        return give.stream()
                .filter(car -> car.getOld() == findOldestCars)
                .collect(Collectors.toList());
    }

    @Test
    void findMaxMileageCarsTest() {
        List<Car> give = List.of(new Car("현대", "12가3456", 2018, 99000),
                new Car("대우", "14나1457", 2019, 569807),
                new Car("벤츠", "15다1245", 2024, 10000));
        List<Car> when = List.of(new Car("대우", "14나1457", 2019, 569807));
        List<Car> result = findMaxMileageCars(give);

        Assertions.assertThat(result).isEqualTo(when);
    }
    private List<Car> findMaxMileageCars(List<Car> give) {

        int findMaxMileageCars = give.stream()
                .mapToInt(Car::getMileAge)
                .max()
                .orElseThrow();

        return give.stream()
                .filter(car -> car.getMileAge() == findMaxMileageCars)
                .collect(Collectors.toList());
    }
}


