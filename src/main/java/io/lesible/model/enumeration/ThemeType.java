package io.lesible.model.enumeration;

import java.util.Arrays;

/**
 * <p> @date: 2021-05-28 15:46</p>
 * <p>
 * 下单来源
 *
 * @author 何嘉豪
 */
public enum ThemeType {

    /**
     * 直播间
     */
    BROADCAST(0),

    /**
     * 短视频
     */
    SHORT_VIDEO(1),

    /**
     * 文章
     */
    ARTICLE(2);

    private final int themeType;

    ThemeType(int themeType) {
        this.themeType = themeType;
    }

    public static ThemeType get(int themeType) {
        return Arrays.stream(values()).filter(it -> it.value() == themeType)
                .findAny().orElse(null);
    }

    private int value() {
        return themeType;
    }
}
