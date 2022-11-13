package lotto.domain;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class Validator {
    private static final String MONEY_PATTERN = "[0-9]{4,100}";
    private static final String WINNING_NUMBERS_PATTERN =
            "[0-9]{1,2}+,+[0-9]{1,2}+,+[0-9]{1,2}+,+[0-9]{1,2}+,+[0-9]{1,2}+,+[0-9]{1,2}+,";

    public static void inputMoney(String inputMoneyRaw) {
        boolean isMatch = Pattern.matches(MONEY_PATTERN, inputMoneyRaw);
        if (!isMatch) {
            throw new IllegalArgumentException("[ERROR] 1000 단위의 숫자를 입력해주세요. (ex: 3000)");
        }
    }
}
