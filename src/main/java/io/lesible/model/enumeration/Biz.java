package io.lesible.model.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * <p> @date: 2021-05-28 15:23</p>
 *
 * @author 何嘉豪
 */
public enum Biz {
    /**
     * 鲁班
     */
    LUBAN(1),

    /**
     * 小店
     */
    SMALL_STORE(2),

    /**
     * 好好学习
     */
    STUDY_HARD(3);

    private final int biz;

    Biz(int biz) {
        this.biz = biz;
    }

    public static Biz get(int biz) {
        return Arrays.stream(values()).filter(it -> it.biz == biz)
                .findAny().orElse(null);
    }

    @JsonValue
    public int getValue() {
        return biz;
    }
}
