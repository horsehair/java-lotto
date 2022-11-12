package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInterface {
    private static final String ANNOUNCEMENT_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String ANNOUNCEMENT_INPUT_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String ANNOUNCEMENT_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

    public static int inputMoney() {
        System.out.println(ANNOUNCEMENT_INPUT_MONEY);
        int inputMoney = Integer.parseInt(Console.readLine());
        System.out.println();
        return inputMoney;
    }

    public static void printCountOfLottos(int countOfLottos) {
        System.out.println(countOfLottos + ANNOUNCEMENT_INPUT_LOTTO_COUNT);
    }

    public static void printNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println();
        System.out.println(ANNOUNCEMENT_INPUT_WINNING_NUMBERS);
        String inputNumbersRaw = Console.readLine();
        List<Integer> inputWinningNumbers = new ArrayList<>(Arrays.asList(inputNumbersRaw.split(","))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        return inputWinningNumbers;
    }
}
