package io.lesible.model.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p> @date: 2021-06-09 20:45</p>
 *
 * @author 何嘉豪
 */
public enum AfterSaleType {

    /**
     * 售后退货退款
     */
    AFTER_SALE_RETURN_GOODS_REFUND(0),

    /**
     * 售后仅退款
     */
    AFTER_SALE_REFUND(1),

    /**
     * 收钱仅退款
     */
    BEFORE_SALE_REFUND(2);

    private final int afterSaleType;

    AfterSaleType(int afterSaleType) {
        this.afterSaleType = afterSaleType;
    }

    @JsonValue
    private int getValue() {
        return afterSaleType;
    }
}
