package io.lesible.model.enumeration;

import java.util.Arrays;

/**
 * <p> @date: 2021-04-22 11:38</p>
 *
 * @author 何嘉豪
 */
public enum OrderType {

    /**
     * 普通订单
     */
    NORMAL_ORDER(0),

    /**
     * 虚拟订单
     */
    VIRTUAL_ORDER(2),

    /**
     * 平台券码
     */
    PLATFORM_COUPONS_CODE(4),

    /**
     * 商家券码
     */
    SHOP_COUPONS_CODE(5);

    /**
     * 订单类型
     */
    private final Integer orderType;

    OrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public static OrderType get(Integer orderType) {
        if (orderType == null) {
            return null;
        }
        return Arrays.stream(values()).filter(it -> it.orderType.equals(orderType))
                .findAny().orElse(null);
    }

    public Integer getOrderType() {
        return orderType;
    }
}
