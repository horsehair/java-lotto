package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.WinningResult;
import lotto.ui.UserInterface;

public class LottoAccount {
    private Map<WinningResult, Integer> results = new LinkedHashMap();
    private int count;
    private int winningAmount;

    public LottoAccount() {
        this.results.put(WinningResult.RANK_NONE, 0);
        this.results.put(WinningResult.RANK_5, 0);
        this.results.put(WinningResult.RANK_4, 0);
        this.results.put(WinningResult.RANK_3, 0);
        this.results.put(WinningResult.RANK_2, 0);
        this.results.put(WinningResult.RANK_1, 0);
        this.winningAmount = 0;
    }

    public void saveLottos(List<Lotto> lottos) {
        this.count = lottos.size();
        lottos.stream()
                .forEach(lotto -> saveOneLotto(lotto));
        calculateWinningAmount();
    }

    private void saveOneLotto(Lotto lotto) {
        WinningResult result = WinningCalculator.getResult(lotto);
        int previousCount = results.get(result);
        int nextCount = previousCount + 1;
        results.put(result, nextCount);
    }

    public void returnResult() {
        UserInterface.printResult(results);
        UserInterface.printYield(calculateYield());
    }

    private void calculateWinningAmount() {
        for (WinningResult result: results.keySet()) {
            this.winningAmount += results.get(result) * result.getMoney();
        }
    }

    private String calculateYield() {
        double yieldRaw = winningAmount * 100 / (count * 1000);
        String yield = String.format("%.2f", yieldRaw);
        return yield;
    }
}
