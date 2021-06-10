package io.lesible.model.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * <p> @date: 2021-04-22 14:44</p>
 *
 * @author 何嘉豪
 */
public enum SubBType {

    /**
     * 未知
     */
    UNKNOWN(0),

    /**
     * app
     */
    APP(1),

    /**
     * 小程序
     */
    APPLET(2),

    /**
     * h5
     */
    H5(3);

    /**
     * 下单场景
     */
    private final int subBType;

    SubBType(int subBType) {
        this.subBType = subBType;
    }

    public static SubBType get(int subBType) {
        return Arrays.stream(values()).filter(it -> it.subBType == subBType)
                .findAny().orElse(null);
    }

    @JsonValue
    public int getValue() {
        return subBType;
    }
}
