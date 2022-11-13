package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.WinningResult;

public class WinningCalculator {
    private List<Integer> numbers;
    private int bonusNumber;

    public void setWinningNumbers(String numbersRaw) {
        List<Integer> winningNumbers = convertStringToIntegerList(numbersRaw);
        numbers = winningNumbers;
    }

    public void setBonusNumber(String bonusNumberRaw) {
        int bonusNumberConverted = Integer.parseInt(bonusNumberRaw);
        bonusNumber = bonusNumberConverted;
    }

    public WinningResult getResultOfOneLotto(Lotto lotto) {
        int countContainNumbers = calculateCountContainNumbers(lotto);
        boolean isContainBonusNumber = checkIsContainBonusNumber(lotto);
        WinningResult winningResult = getWinningResultByCount(countContainNumbers, isContainBonusNumber);
        return winningResult;
    }

    private List<Integer> convertStringToIntegerList(String numbersRaw) {
        List<Integer> numbersConverted = Arrays.asList(numbersRaw.split(",")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbersConverted;
    }

    private int calculateCountContainNumbers(Lotto lotto) {
        List<Integer> numbersOfLotto = lotto.getNumbers();
        int count = 0;
        for (int number: numbersOfLotto) {
            if (this.numbers.contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean checkIsContainBonusNumber(Lotto lotto) {
        List<Integer> numbersOfLotto = lotto.getNumbers();
        boolean isContainBonusNumber = numbersOfLotto.contains(this.bonusNumber);
        return isContainBonusNumber;
    }
}
