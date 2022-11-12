package lotto.domain;

import java.util.List;
import lotto.ui.UserInterface;

public class User {
    LottoAccount lottoAccount;

    public User() {
        this.lottoAccount = new LottoAccount();
    }

    public void buyLottos() {
        int inputMoney = UserInterface.inputMoney();
        List<Lotto> lottos = LottoMachine.publish(inputMoney);
        WinningCalculator.setNumbers();
        saveResult(lottos);
        returnResult();
    }

    public void saveResult(List<Lotto> lottos) {
        this.lottoAccount.saveLottos(lottos);
    }

    public void returnResult() {
        this.lottoAccount.returnResult();
    }
}
