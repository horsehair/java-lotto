package lotto.domain;

import static lotto.constant.LottoRule.AMOUNT_OF_ONE_LOTTO;
import static lotto.constant.LottoRule.COUNT_OF_NUMBERS;
import static lotto.constant.LottoRule.END_NUMBER;
import static lotto.constant.LottoRule.START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.ui.UserInterface;

public class LottoMachine {
    public static List<Lotto> publish(int inputMoney) {
        int countOfLottos = getCountOfLottos(inputMoney);
        UserInterface.announceCountOfLottosPublished(countOfLottos);
        List<Lotto> lottos = publishLottosByCount(countOfLottos);
        return lottos;
    }

    private static int getCountOfLottos(int inputMoney) {
        return inputMoney / AMOUNT_OF_ONE_LOTTO;
    }

    private static List<Lotto> publishLottosByCount(int countOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < countOfLottos; count++) {
            List<Integer> randomNumbers = getSortedRandomNumbers();
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private static List<Integer> getSortedRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                        START_NUMBER, END_NUMBER, COUNT_OF_NUMBERS)
                .stream()
                .sorted()
                .collect(Collectors.toList());
        return numbers;
    }
}
