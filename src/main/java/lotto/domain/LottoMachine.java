package lotto.domain;

import java.util.List;

public class LottoMachine {
    public static List<Lotto> publish(int inputMoney) {
        int countOfLottos = calculateCount(inputMoney);
        List<Lotto> lottos = create(countOfLottos);
        return lottos;
    }
}
