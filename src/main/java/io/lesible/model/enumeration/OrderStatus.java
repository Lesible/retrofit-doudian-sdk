package io.lesible.model.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p> @date: 2021-04-22 14:01</p>
 *
 * @author 何嘉豪
 */
public enum OrderStatus {

    /**
     * 在线支付订单待支付；货到付款订单待确认
     */
    WAITING_FOR_PAY("1"),

    /**
     * 订单支付成功，风控处理中；订单支付成功，待成团。
     * 当前订单状态如果发生风控拒绝或者成团失败，订单将被取消；
     * 风控通过或者成团成功，订单将流转到2状态
     */
    RISK_MANAGING("105"),

    /**
     * 备货中（只有此状态下，才可发货）
     */
    STOCKING_UP("2"),

    /**
     * 整单已发货
     */
    DELIVERED_ENTIRELY("3"),

    /**
     * 已取消：
     * 1.未支付时用户或客服取消订单；
     * 2.用户超时未支付，系统自动取消订单；
     * 3.货到付款订单，用户拒收；
     * 4.订单付款未发货时，触发平台风控，取消订单
     */
    ORDER_CANCELED("4"),

    /**
     * 已完成：
     * 1.在线支付订单，商家发货后，用户收货、拒收或7天超时自动确认收货（国内订单7天，跨境订单15天）；
     * 2.货到付款订单，用户确认收货；
     */
    ORDER_FINISHED("5"),


    /**
     * 部分发货
     */
    DELIVERED_PARTLY("101");

    /**
     * 订单状态
     */
    private final String orderStatus;

    OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @JsonValue
    public String getValue() {
        return orderStatus;
    }
}
