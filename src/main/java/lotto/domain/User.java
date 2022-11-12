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
        saveLottosInAccount(lottos);
    }

    public void saveLottosInAccount(List<Lotto> lottos) {
        this.lottoAccount.saveLottos(lottos);
    }
}
