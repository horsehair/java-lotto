package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoAccount {
    private Map results = new LinkedHashMap();

    public LottoAccount() {
        results.put("5등", 0);
        results.put("4등", 0);
        results.put("3등", 0);
        results.put("2등", 0);
        results.put("1등", 0);
    }
}
