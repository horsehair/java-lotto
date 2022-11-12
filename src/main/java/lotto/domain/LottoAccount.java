package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.WinningResult;
import lotto.ui.UserInterface;

public class LottoAccount {
    private Map<WinningResult, Integer> results = new LinkedHashMap();
    private int count;

    public LottoAccount() {
        results.put(WinningResult.RANK_NONE, 0);
        results.put(WinningResult.RANK_5, 0);
        results.put(WinningResult.RANK_4, 0);
        results.put(WinningResult.RANK_3, 0);
        results.put(WinningResult.RANK_2, 0);
        results.put(WinningResult.RANK_1, 0);
    }

    public void saveLottos(List<Lotto> lottos) {
        this.count = lottos.size();
        lottos.stream()
                .forEach(lotto -> saveOneLotto(lotto));
    }

    private void saveOneLotto(Lotto lotto) {
        WinningResult result = WinningCalculator.getResult(lotto);
        int previousCount = results.get(result);
        int nextCount = previousCount + 1;
        results.put(result, nextCount);
    }

    public void returnResult() {
        UserInterface.printResult(results);
    }
}
