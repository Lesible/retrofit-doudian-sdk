package io.lesible.model.enumeration;

import java.util.Arrays;

/**
 * <p> @date: 2021-06-09 20:50</p>
 *
 * @author 何嘉豪
 */
public enum RefundStatus {

    /**
     * 原路返回
     */
    ORIGIN(0),

    /**
     * 线下退款
     */
    Offline(1),

    /**
     * 预付款退款
     */
    IM_PRESET(2),

    /**
     * 保证金退款
     */
    PLEDGE(3),

    /**
     * 无需退款
     */
    NONE(4),

    /**
     * 全部
     */
    REFUND_TYPE_ALL(5);

    private final Integer refundStatus;

    RefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public static RefundStatus get(Integer refundStatus) {
        if (refundStatus == null) {
            return null;
        }
        return Arrays.stream(values()).filter(it -> it.refundStatus.equals(refundStatus))
                .findAny().orElse(null);
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }
}
