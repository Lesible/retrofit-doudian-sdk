package io.lesible.model.response.order;

/**
 * <p> @date: 2021-04-22 17:33</p>
 *
 * @author 何嘉豪
 */
public enum PreSellType {
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

    private final int preSellType;

    PreSellType(int preSellType) {
        this.preSellType = preSellType;
    }

    public int value() {
        return preSellType;
    }
}
