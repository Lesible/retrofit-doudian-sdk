package io.lesible.model.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

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
    abnormal_CANCEL(1),

    /**
     * 风控审核中
     */
    REVIEWING(2);

    private final int abnormalOrderType;

    AbnormalOrder(int abnormalOrderType) {
        this.abnormalOrderType = abnormalOrderType;
    }

    @JsonValue
    public int getValue() {
        return abnormalOrderType;
    }

    public static AbnormalOrder get(int abnormalOrderType) {
        return Arrays.stream(values()).filter(it -> it.abnormalOrderType == abnormalOrderType)
                .findAny().orElse(null);
    }

}
