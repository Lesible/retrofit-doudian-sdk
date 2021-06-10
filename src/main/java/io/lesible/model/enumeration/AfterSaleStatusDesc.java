package io.lesible.model.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 售后状态
 * <p> @date: 2021-04-21 18:06</p>
 *
 * @author 何嘉豪
 */
public enum AfterSaleStatusDesc {

    /**
     * 全部
     */
    ALL("all"),

    /**
     * 售后中
     */
    IN_AFTER_SALE("in_aftersale"),

    /**
     * 退款中
     */
    REFUND("refund"),

    /**
     * 退款成功
     */
    REFUND_SUCCESS("refund_success"),

    /**
     * 退款失败
     */
    REFUND_FAIL("refund_fail"),

    /**
     * 换货成功
     */
    EXCHANGE_SUCCESS("exchange_success"),

    /**
     * 售后关闭
     */
    AFTER_SALE_CLOSE("aftersale_close");

    /**
     * 实际状态值
     */
    private final String statusDesc;

    AfterSaleStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public static AfterSaleStatusDesc get(String statusDesc) {
        return Arrays.stream(values()).filter(it -> it.statusDesc.equals(statusDesc))
                .findAny().orElse(null);
    }

    @JsonValue
    public String getValue() {
        return statusDesc;
    }

}
