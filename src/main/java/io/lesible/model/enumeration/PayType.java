package io.lesible.model.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

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
    ALIPAY(2),

    /**
     * 小程序
     */
    APPLET(3),

    /**
     * 银行卡
     */
    BANK_CARD(4),

    /**
     * 余额
     */
    BALANCE(5),

    /**
     * 无需支付
     */
    NONE(7),

    /**
     * 放心花
     */
    CREDIT(8),

    /**
     * 新卡支付
     */
    NEW_CARD(9);

    private final int payType;

    PayType(int payType) {
        this.payType = payType;
    }

    @JsonValue
    public int getValue() {
        return payType;
    }

    public PayType get(int payType) {
        return Arrays.stream(values()).filter(it -> it.payType == payType)
                .findAny().orElse(null);
    }
}