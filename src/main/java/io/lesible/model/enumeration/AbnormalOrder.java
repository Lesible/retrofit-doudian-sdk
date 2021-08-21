package io.lesible.model.enumeration;

import java.util.Arrays;

/**
 * <p> @date: 2021-04-22 11:50</p>
 *
 * @author 何嘉豪
 */
public enum AbnormalOrder {

    /**
     * 异常取消
     */
    ABNORMAL_CANCEL(1),

    /**
     * 风控审核中
     */
    REVIEWING(2);

    private final Integer abnormalOrderType;

    AbnormalOrder(Integer abnormalOrderType) {
        this.abnormalOrderType = abnormalOrderType;
    }

    public static AbnormalOrder get(Integer abnormalOrderType) {
        if (abnormalOrderType == null) {
            return null;
        }
        return Arrays.stream(values()).filter(it -> it.abnormalOrderType.equals(abnormalOrderType))
                .findAny().orElse(null);
    }

    public Integer getAbnormalOrderType() {
        return abnormalOrderType;
    }

}
