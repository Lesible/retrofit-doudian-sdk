package io.lesible.model.enumeration;

import java.util.Arrays;

/**
 * <p> @date: 2021-06-10 17:14</p>
 *
 * @author 何嘉豪
 */
public enum PromoteType {

    /**
     * 全网店铺推广
     */
    PLATFORM_PROMOTE(0),

    /**
     * 自有渠道推广
     */
    SELF_CHANNEL_PROMOTE(1);

    private final int promoteType;


    PromoteType(int promoteType) {
        this.promoteType = promoteType;
    }

    public static PromoteType get(int promoteType) {
        return Arrays.stream(values()).filter(it -> it.promoteType == promoteType)
                .findAny().orElse(null);
    }
    
    public int getPromoteType() {
        return promoteType;
    }
}
