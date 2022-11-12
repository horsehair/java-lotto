package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.utility.Utility;

public class LottoMachine {
    private static final int AMOUNT_OF_LOTTO = 1_000;

    public static List<Lotto> publish(int inputMoney) {
        int countOfLottos = calculateCount(inputMoney);
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
        List<Integer> numbers = new ArrayList<>();
        int randomNumber;
        do {
            randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        } while (numbers.size() < 6);
        List<Integer> numbersSorted = Utility.sortNumbers(numbers);
        Lotto lotto = new Lotto(numbersSorted);
        return lotto;
    }
}
