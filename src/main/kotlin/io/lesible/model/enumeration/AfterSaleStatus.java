package io.lesible.model.enumeration;

import java.util.Arrays;

/**
 * <p> @date: 2021-05-27 17:43</p>
 *
 * @author 何嘉豪
 */
public enum AfterSaleStatus {

    /**
     * 售后初始化
     */
    INIT(0),

    /**
     * 售后申请
     */
    APPLY(6),

    /**
     * 售后退货中
     */
    RETURNING(7),

    /**
     * 拒绝售后申请
     */
    APPLY_REJECT(27),

    /**
     * 售后成功
     */
    SUCCESS(12),

    /**
     * 售后失败
     */
    FAIL(28),

    /**
     * 售后已发货
     */
    DELIVERED(11),

    /**
     * 退货后拒绝退款
     */
    REFUND_REJECT(29),

    /**
     * 售后换货商家发货
     */
    EXCHANGE_SHIP(13),

    /**
     * 售后换货商家收货
     */
    EXCHANGE_RECEIPT(14),

    /**
     * 取消成功
     */
    SUCCESS_CANCEL(51),

    /**
     * 逆向交易完成
     */
    REVERSE_TRADE_FINISHED(53);

    private final int afterSaleStatus;

    AfterSaleStatus(int afterSaleStatus) {
        this.afterSaleStatus = afterSaleStatus;
    }

    public static AfterSaleStatus get(int afterSaleStatus) {
        return Arrays.stream(values()).filter(it -> it.afterSaleStatus == (afterSaleStatus))
                .findAny().orElse(null);
    }
    
    public Integer getAfterSaleStatus() {
        return afterSaleStatus;
    }
}
