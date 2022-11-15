package lotto.domain;

import static lotto.constant.LottoRule.PRICE_OF_ONE_LOTTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    @DisplayName("생성한 객체가 로또가 맞는지 확인한다.")
    @Test
    void publishLotto() {
        // given
        String moneyRaw = "1000";
        // when
        List<Lotto> lottos = LottoMachine.publish(moneyRaw);
        // then
        assertThat(lottos.get(0)).isInstanceOf(Lotto.class);
    }

    @DisplayName("입력 금액에 해당하는 개수만큼 로또를 구매했는지 확인한다.")
    @Test
    void publishLottosByMoney() {
        // given
        int money = PRICE_OF_ONE_LOTTO * 5;
        String moneyRaw = Integer.toString(PRICE_OF_ONE_LOTTO * 5);
        // when
        List<Lotto> lottos = LottoMachine.publish(moneyRaw);
        int countLottosByPrice = money / PRICE_OF_ONE_LOTTO;
        // then
        assertThat(lottos.size()).isEqualTo(countLottosByPrice);
    }

    @DisplayName("입력 금액이 1,000의 배수가 아님 -> 예외발생")
    @Test
    void isNotMultipleOf1000() {
        assertThatThrownBy(() -> LottoMachine.publish("7001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}