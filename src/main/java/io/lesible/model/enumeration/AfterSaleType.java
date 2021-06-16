package io.lesible.model.enumeration;

import java.util.Arrays;

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
    BEFORE_SALE_REFUND(2),

    /**
     * 换货
     */
    EXCHANGE(3),

    /**
     * 系统取消
     */
    CANCEL_BY_SYSTEM(4),

    /**
     * 用户取消
     */
    CANCEL_BY_USER(5);

    private final Integer afterSaleType;

    AfterSaleType(Integer afterSaleType) {
        this.afterSaleType = afterSaleType;
    }

    public static AfterSaleType get(Integer afterSaleType) {
        if (afterSaleType == null) {
            return null;
        }
        return Arrays.stream(values()).filter(it -> it.afterSaleType.equals(afterSaleType))
                .findAny().orElse(null);
    }

    private Integer getAfterSaleType() {
        return afterSaleType;
    }
}
