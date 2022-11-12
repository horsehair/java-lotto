package lotto.domain;

import java.util.List;

public class User {
    LottoAccount lottoAccount;

    public User() {
        this.lottoAccount = new LottoAccount();
    }

    public void buyLottos() {
        int inputMoney = UserInterface.inputMoney();
        List<Lotto> lottos = LottoMachine(inputMoney);
        saveLottosInAccount(lottos);
    }

    public void saveLottosInAccount(List<Lotto> lottos) {
        this.lottoAccount.saveLottos(lottos);
    }
}
