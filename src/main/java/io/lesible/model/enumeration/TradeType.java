package io.lesible.model.enumeration;

import java.util.Arrays;

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

    private final Integer tradeType;

    TradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    public static TradeType get(Integer tradeType) {
        if (tradeType == null) {
            return null;
        }
        return Arrays.stream(values()).filter(it -> it.tradeType.equals(tradeType))
                .findAny().orElse(null);
    }

    public Integer getTradeType() {
        return tradeType;
    }
}
