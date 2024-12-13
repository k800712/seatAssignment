package tdd.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class BasicTest {

    @Test
    void toIntegersTest() {

        List<String> give = List.of("1", "2", "3");
        List<Integer> when = List.of(1, 2, 3);
        List<Integer> result = toIntegers(give);

        Assertions.assertThat(result).isEqualTo(when);
    }

    private List<Integer> toIntegers(List<String> give) {
        return give.stream().map(Integer::parseInt).toList();
    }

    @Test
    void PersonTest() {

        List<String> give = List.of("김수린", "김세린", "김단우");
        List<Person> when = List.of(new Person("김수린"),
                new Person("김세린"),
                new Person("김단우"));
        List<Person> result = toPerson(give);

        Assertions.assertThat(result).isEqualTo(when);
    }

    private List<Person> toPerson(List<String> give) {

        return give.stream().map(Person::new).toList();
    }

    @Test
    void CatTest() {
        List<String> give = List.of("나비", "나리");
        List<Cat> when = List.of(new Cat("나비"), new Cat("나리"));
        List<Cat> result = toCat(give);
        Assertions.assertThat(result).isEqualTo(when);
    }

    private List<Cat> toCat(List<String> give) {
        return give.stream().map(Cat::new).toList();
    }

    @Test
    void findMaxValuesTest() {
        List<Integer> input = List.of(1, 2, 3, 4, 4);
        List<Integer> expected = List.of(4, 4);
        List<Integer> actual = findMaxValues(input);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private List<Integer> findMaxValues(List<Integer> numbers) {
        Integer max = numbers.stream().max(Integer::compare).orElse(null);
        return numbers.stream()
                .filter(n -> n.equals(max))
                .collect(Collectors.toList());
    }
}



