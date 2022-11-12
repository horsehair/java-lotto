package lotto.domain;

import java.util.List;
import lotto.constant.WinningResult;
import lotto.ui.UserInterface;

public class WinningCalculator {
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public static void setNumbers() {
        List<Integer> inputWinningNumbers = UserInterface.inputWinningNumbers();
        winningNumbers = inputWinningNumbers;
        int inputBonusNumber = UserInterface.inputBonusNumer();
        bonusNumber = inputBonusNumber;
    }

    public static WinningResult getResult(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int countHit = countHit(numbers);
        boolean isContainBonus = isContainBonus(numbers);
        WinningResult result = getResultByCountAndBonus(countHit, isContainBonus);
        return result;
    }

    private static int countHit(List<Integer> numbers) {
        int count = 0;
        for (int number: numbers) {
            if (winningNumbers.contains(number)) {
                count += 1;
            }
        }
        return count;
    }
}
