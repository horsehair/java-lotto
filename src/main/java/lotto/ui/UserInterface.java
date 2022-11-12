package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInterface {
    private static final String ANNOUNCEMENT_INPUT_MONEY = "구입금액을 입력해 주세요.";

    public static int inputMoney() {
        System.out.println(ANNOUNCEMENT_INPUT_MONEY);
        int inputMoney = Integer.parseInt(Console.readLine());
        return inputMoney;
    }

    public static void printNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
