package io.lesible.model.enumeration;

/**
 * <p> @date: 2021-04-22 12:00</p>
 *
 * @author 何嘉豪
 */
public enum TradeType {

    /**
     * 拼团订单
     */
    GROUP_ORDER(1),

    /**
     * 定金预售
     */
    DEPOSIT_PRE_SELL(2);

    private final int tradeType;

    TradeType(int tradeType) {
        this.tradeType = tradeType;
    }

    public int value() {
        return tradeType;
    }
}
