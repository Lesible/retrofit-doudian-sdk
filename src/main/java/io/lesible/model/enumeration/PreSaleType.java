package io.lesible.model.enumeration;

import java.util.Arrays;

/**
 * <p> @date: 2021-04-22 17:33</p>
 *
 * @author 何嘉豪
 */
public enum PreSaleType {
    /**
     * 非预售
     */
    NO_PRE_SELL(0),

    /**
     * 全款预售
     */
    FULL_PAYMENT_PRE_SELL(1),

    /**
     * 阶梯库存
     */
    ECHELON_INVENTORY(2);

    private final int preSaleType;

    PreSaleType(int preSaleType) {
        this.preSaleType = preSaleType;
    }

    public static PreSaleType get(int preSaleType) {
        return Arrays.stream(values()).filter(it -> it.preSaleType == preSaleType)
                .findAny().orElse(null);
    }
    
    public int getPreSaleType() {
        return preSaleType;
    }
}
