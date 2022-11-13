package lotto;

import lotto.domain.Cashier;
import lotto.domain.WinningCalculator;

public class Application {
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        cashier.buyLottos();
        cashier.setWinningRule();
        cashier.saveResultInAccount();
        cashier.getResultInAccount();
    }
}
