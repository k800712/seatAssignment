package tdd.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LottoNumber {

    private final int[] numbers;

    public LottoNumber(int number1, int number2, int number3, int number4, int number5, int number6) {
        this.numbers = new int[]{number1, number2, number3, number4, number5, number6};
    }

    public List<Integer> getNumbers() {
        return Arrays.asList(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5]);
    }

    public int getNumber(int index) {
        if (index < 0 || index >= 6) {
            throw new IndexOutOfBoundsException("인덱스는 0에서 5 사이여야 합니다.");
        }
        return numbers[index];
    }

    @Override
    public String toString() {
        return "LottoNumber{" + "numbers=" + Arrays.toString(numbers) + '}';
    }

    public LottoNumber(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.deepEquals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numbers);
    }

    public int checkLottoBonusRank(LottoNumber winningNumber, int bonusNumber) {
        List<Integer> lottoNumbers = this.getNumbers();
        List<Integer> winningNumbers = winningNumber.getNumbers();

        long matchCount = lottoNumbers.stream().filter(winningNumbers::contains).count();
        boolean hasBonus = lottoNumbers.contains(bonusNumber);

        if (matchCount == 6) {
            return 1; // 모든 번호 일치
        } else if (matchCount == 5) {
            return hasBonus ? 2 : 3; // 보너스 포함 시: 두 번째 등수
        } else if (matchCount == 4) {
            return 4; // 네 개 일치
        } else if (matchCount == 3) {
            return 5; // 세 개 일치
        }

        return hasBonus ? -1 : 0; // 보너스 번호만 맞추었을 경우
    }
}