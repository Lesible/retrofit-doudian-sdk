package io.lesible.model.enumeration;

import java.util.Arrays;

/**
 * <p> @date: 2021-06-09 20:50</p>
 *
 * @author 何嘉豪
 */
public enum RefundStatus {
    ;

    private final int refundStatus;

    RefundStatus(int refundStatus) {
        this.refundStatus = refundStatus;
    }

    public static RefundStatus get(int refundStatus) {
        return Arrays.stream(values()).filter(it -> it.refundStatus == refundStatus)
                .findAny().orElse(null);
    }

    public int getRefundStatus() {
        return refundStatus;
    }
}
