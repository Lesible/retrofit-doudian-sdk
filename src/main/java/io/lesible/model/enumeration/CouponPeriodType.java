package io.lesible.model.enumeration;

import java.util.Arrays;

/**
 * <p> @date: 2021-06-10 15:47</p>
 * 优惠券类型
 *
 * @author 何嘉豪
 */
public enum CouponPeriodType {
    /**
     * 固定有效期
     */
    FIXED_PERIOD(1),

    /**
     * 浮动有效期
     */
    FLOAT_PERIOD(2);

    private final int periodType;

    CouponPeriodType(int periodType) {
        this.periodType = periodType;
    }

    public static CouponPeriodType get(int periodType) {
        return Arrays.stream(values()).filter(it -> it.periodType == periodType)
                .findAny().orElse(null);
    }

    private int getPeriodType() {
        return periodType;
    }
}
