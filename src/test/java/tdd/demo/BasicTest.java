package tdd.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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


    @Test
    void findHeaviestCatsTest() {

        List<Cat> give = List.of(new Cat(3.5, 4, "나리"),
                new Cat(6.6, 9, "나비"),
                new Cat(5.6, 10, "고양이"));
        List<Cat> when = List.of(new Cat(6.6, 9, "나비"));
        List<Cat> result = findHeaviestCats(give);

        Assertions.assertThat(result).isEqualTo(when);
    }

    private List<Cat> findHeaviestCats(List<Cat> give) {

        double maxWeight = give.stream()
                .mapToDouble(Cat::getWeight)
                .max()
                .orElse(0);

        return give.stream()
                .filter(cat -> cat.getWeight() == maxWeight)
                .collect(Collectors.toList());
    }

    @Test
    void findOldestCatsTest() {

        List<Cat> give = List.of(new Cat(3.5, 4, "나리"),
                new Cat(6.6, 9, "나비"),
                new Cat(5.6, 10, "고양이"));
        List<Cat> when = List.of(new Cat(5.6, 10, "고양이"));
        List<Cat> result = findOldestCats(give);

        Assertions.assertThat(result).isEqualTo(when);

    }

    private List<Cat> findOldestCats(List<Cat> give) {
        int maxAge = give.stream()
                .mapToInt(Cat::getAge)
                .max()
                .orElse(0);

        return give.stream()
                .filter(cat -> cat.getAge() == maxAge)
                .collect(Collectors.toList());
    }

    @Test
    void findSeniorDeveloperTest() {

        List<Person> give = List.of(new Person(4, "개발자", "김씨"),
                new Person(7, "개발자", "이씨"),
                new Person(3, "개발자", "박씨"),
                new Person(11, "개발자", "홍씨"));
        List<Person> when = List.of(new Person(11, "개발자", "홍씨"));
        List<Person> result = findSeniorDeveloper(give);

        Assertions.assertThat(result).isEqualTo(when);
    }

    private List<Person> findSeniorDeveloper(List<Person> give) {

        int maxExperience = give.stream()
                .mapToInt(Person::getExperience)
                .max()
                .orElse(0);

        return give.stream()
                .filter(person -> person.getExperience() == maxExperience)
                .collect(Collectors.toList());
    }

    @Test
    void LottoNumberTest() {

        List<Integer> give = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        List<LottoNumber> when = List.of(new LottoNumber(1, 2, 3, 4, 5, 6),
                new LottoNumber(7, 8, 9, 10, 11, 12));
        List<LottoNumber> result = toLottoNumbers(give);

        Assertions.assertThat(result).isEqualTo(when);
    }

    private List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        List<Integer> validNumbers = numbers.stream()
                .filter(n -> n >= 1 && n <= 45)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i + 5 < validNumbers.size(); i += 6) {
            lottoNumbers.add(new LottoNumber(
                    validNumbers.get(i), validNumbers.get(i + 1), validNumbers.get(i + 2),
                    validNumbers.get(i + 3), validNumbers.get(i + 4), validNumbers.get(i + 5)));
        }
        return lottoNumbers;
    }

    @Test
    void checkLottoRankTest() {
        LottoNumber lotto1 = new LottoNumber(1, 2, 3, 4, 5, 6);
        LottoNumber winning1 = new LottoNumber(4, 5, 6, 7, 8, 9);
        LottoNumber winning2 = new LottoNumber(3, 4, 5, 6, 7, 8);
        LottoNumber winning3 = new LottoNumber(2, 3, 4, 5, 6, 7);
        LottoNumber winning4 = new LottoNumber(1, 2, 3, 4, 5, 6);

        Assertions.assertThat(checkLottoRank(lotto1, winning1)).isEqualTo(5);
        Assertions.assertThat(checkLottoRank(lotto1, winning2)).isEqualTo(4);
        Assertions.assertThat(checkLottoRank(lotto1, winning3)).isEqualTo(3);
        Assertions.assertThat(checkLottoRank(lotto1, winning4)).isEqualTo(1);
    }

    private int checkLottoRank(LottoNumber lottoNumber, LottoNumber winningNumber) {
        List<Integer> lottoNumbers = lottoNumber.getNumbers();
        List<Integer> winningNumbers = winningNumber.getNumbers();

        int matchCount = (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        switch (matchCount) {
            case 6:
                return 1;
            case 5:
                return 3;
            case 4:
                return 4;
            case 3:
                return 5;
            default:
                return 0; // 당첨되지 않음
        }
    }

//    @Test
//    void checkLottoBonusRankTest() {
//        LottoNumber userLotto = new LottoNumber(1, 2, 3, 4, 5, 6);
//
//
//        LottoNumber winningLotto = new LottoNumber(2, 3, 4, 5, 6, 7);
//        assertThat(userLotto.checkLottoBonusRank(winningLotto, 7)).isEqualTo(2);
//
//        winningLotto = new LottoNumber(1, 2, 3, 4, 5, 8);
//        assertThat(userLotto.checkLottoBonusRank(winningLotto, 8)).isEqualTo(2);
//
//        winningLotto = new LottoNumber(1, 2, 3, 8, 9, 10);
//        assertThat(userLotto.checkLottoBonusRank(winningLotto, 7)).isEqualTo(5);
//
//        winningLotto = new LottoNumber(8, 9, 10, 11, 12, 13);
//        assertThat(userLotto.checkLottoBonusRank(winningLotto, 7)).isEqualTo(0);
//
//    }

}