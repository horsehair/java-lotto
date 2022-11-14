package lotto.domain;

import static lotto.constant.LottoRule.AMOUNT_OF_ONE_LOTTO;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.WinningResult;

public class Account {
    private final WinningCalculator winningCalculator;
    private final Map<WinningResult, Integer> winningResultTable = new LinkedHashMap<>();
    private int count;
    private long winningAmount;

    public Account(WinningCalculator winningCalculator) {
        this.winningCalculator = winningCalculator;
        this.winningResultTable.put(WinningResult.RANK_NONE, 0);
        this.winningResultTable.put(WinningResult.RANK_5, 0);
        this.winningResultTable.put(WinningResult.RANK_4, 0);
        this.winningResultTable.put(WinningResult.RANK_3, 0);
        this.winningResultTable.put(WinningResult.RANK_2, 0);
        this.winningResultTable.put(WinningResult.RANK_1, 0);
    }

    public void saveResult(List<Lotto> lottos) {
        this.count = lottos.size();
        lottos.forEach(this::saveOneLotto);
        calculateWinningAmountByResults();
    }

    public Map<WinningResult, Integer> getWinningResultTable() {
        return this.winningResultTable;
    }

    public String getYield() {
        double yieldRaw = winningAmount / ((double) (count * AMOUNT_OF_ONE_LOTTO));
        double yieldPercent = yieldRaw * 100;
        DecimalFormat decFormat = new DecimalFormat("###,##0.0");
        return decFormat.format(yieldPercent);
    }

    private void saveOneLotto(Lotto lotto) {
        WinningResult winningResult = winningCalculator.getResultOfOneLotto(lotto);
        int previousCountOfWinningResult = winningResultTable.get(winningResult);
        int nextCountOfWinningResult = previousCountOfWinningResult + 1;
        winningResultTable.put(winningResult, nextCountOfWinningResult);
    }

    private void calculateWinningAmountByResults() {
        this.winningAmount = 0;
        for (WinningResult winningResult: winningResultTable.keySet()) {
            this.winningAmount += winningResultTable.get(winningResult) * winningResult.getMoney();
        }
    }
}
