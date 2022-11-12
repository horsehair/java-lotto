package lotto.domain;

import java.util.List;

public class LottoMachine {
    private static final int AMOUNT_OF_LOTTO = 1_000;

    public static List<Lotto> publish(int inputMoney) {
        int countOfLottos = calculateCount(inputMoney);
        List<Lotto> lottos = create(countOfLottos);
        return lottos;
    }

    private static int calculateCount(int inputMoney) {
        int count = inputMoney / AMOUNT_OF_LOTTO;
        return count;
    }
}
