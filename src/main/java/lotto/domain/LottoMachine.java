package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.ui.UserInterface;
import lotto.utility.Utility;

public class LottoMachine {
    private static final int AMOUNT_OF_LOTTO = 1_000;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_COUNT_OF_NUMBERS = 6;

    public static List<Lotto> publish(int inputMoney) {
        int countOfLottos = calculateCount(inputMoney);
        UserInterface.printCountOfLottos(countOfLottos);
        List<Lotto> lottos = createLottos(countOfLottos);
        return lottos;
    }

    private static int calculateCount(int inputMoney) {
        int count = inputMoney / AMOUNT_OF_LOTTO;
        return count;
    }

    private static List<Lotto> createLottos(int countOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < countOfLottos; count++) {
            Lotto lotto = createLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private static Lotto createLotto() {
        List<Integer> numbers = getRandomNumbers();
        List<Integer> numbersSorted = Utility.sortNumbers(numbers);
        Lotto lotto = new Lotto(numbersSorted);
        return lotto;
    }

    private static List<Integer> getRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT_OF_NUMBERS);
        return numbers;
    }
}
