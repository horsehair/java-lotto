package lotto.constant;

public enum WinningResult {
    RANK_1("1등", 2_000_000_000),
    RANK_2("2등", 30_000_000),
    RANK_3("3등", 1_500_000),
    RANK_4("4등", 50_000),
    RANK_5("5등", 5_000),
    RANK_NONE("꽝", 0)
    ;

    private final String rank;
    private final int money;

    WinningResult(String rank, int money) {
        this.rank = rank;
        this.money = money;
    }

    public String getRank() {
        return rank;
    }

    public int getMoney() {
        return money;
    }
}
