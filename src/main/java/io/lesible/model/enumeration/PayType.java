package io.lesible.model.enumeration;

/**
 * <p> @date: 2021-04-22 14:47</p>
 *
 * @author 何嘉豪
 */
public enum PayType {
    /**
     * 货到付款
     */
    CASH_ON_DELIVERY(0),

    /**
     * 微信支付
     */
    WXPAY(1),

    /**
     * 支付宝
     */
    ALIPAY(2);

    private final int payType;

    PayType(int payType) {
        this.payType = payType;
    }

    public int value() {
        return payType;
    }

    public PayType get(int payType) {
        for (PayType value : values()) {
            if (value.value() == payType) {
                return value;
            }
        }
        return null;
    }
}
