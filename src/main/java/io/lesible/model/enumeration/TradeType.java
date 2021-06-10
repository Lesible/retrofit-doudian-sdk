package io.lesible.model.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

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

    private final int tradeType;

    TradeType(int tradeType) {
        this.tradeType = tradeType;
    }

    public static TradeType get(int tradeType) {
        return Arrays.stream(values()).filter(it -> it.tradeType == tradeType)
                .findAny().orElse(null);
    }

    @JsonValue
    public int getValue() {
        return tradeType;
    }
}
