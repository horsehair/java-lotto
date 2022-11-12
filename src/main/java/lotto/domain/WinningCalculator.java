package lotto.domain;

import java.util.List;
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
}
