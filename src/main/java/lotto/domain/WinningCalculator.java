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

    private static boolean isContainBonus(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    private static WinningResult getResultByCountAndBonus(int countHit, boolean isContainBonus) {
        if (countHit < 3) {
            return WinningResult.RANK_NONE;
        }
        if (countHit == 3) {
            return WinningResult.RANK_5;
        }
        if (countHit == 4) {
            return WinningResult.RANK_4;
        }
        if (countHit == 5 && isContainBonus) {
            return WinningResult.RANK_2;
        }
        if (countHit == 5) {
            return WinningResult.RANK_3;
        }
        return WinningResult.RANK_1;
    }
}
