package io.lesible.model.enumeration;

/**
 * <p> @date: 2021-04-22 11:50</p>
 *
 * @author 何嘉豪
 */
public enum AbnormalOrder {

    /**
     * 异常取消
     */
    abnormal_CANCEL(1),

    /**
     * 风控审核中
     */
    REVIEWING(2);

    private final int abnormalOrderType;

    AbnormalOrder(int abnormalOrderType) {
        this.abnormalOrderType = abnormalOrderType;
    }

    public int value() {
        return abnormalOrderType;
    }
}
