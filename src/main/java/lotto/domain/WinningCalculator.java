package lotto.domain;

import java.util.List;
import lotto.ui.UserInterface;

public class WinningCalculator {
    private static List<Integer> numbers;

    public static void setNumbers() {
        List<Integer> inputWinningNumbers = UserInterface.inputWinningNumbers();
        numbers = inputWinningNumbers;
    }
}
