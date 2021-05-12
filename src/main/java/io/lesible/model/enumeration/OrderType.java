package io.lesible.model.enumeration;

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
    private final int orderType;

    OrderType(int orderType) {
        this.orderType = orderType;
    }

    public static OrderType get(int orderType) {
        for (OrderType value : values()) {
            if (value.value() == orderType) {
                return value;
            }
        }
        return null;
    }

    public int value() {
        return orderType;
    }
}
