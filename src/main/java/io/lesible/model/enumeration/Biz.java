package io.lesible.model.enumeration;

/**
 * <p> @date: 2021-04-22 14:29</p>
 *
 * @author 何嘉豪
 */
public enum Biz {

    /**
     * 鲁班广告
     */
    LUBAN(1),

    /**
     * 联盟
     */
    LEAGUE(2),

    /**
     * 商城
     */
    MALL(4),

    /**
     * 自主经营
     */
    SELF_BIZ(8),

    /**
     * 线索通
     */
    XIANSUOTONG(10),

    /**
     * 抖音门店
     */
    DOUDIAN(12),

    /**
     * 抖+
     */
    DOU_PULS(14),

    /**
     * 穿山甲
     */
    PANGOLIN(15);

    private final int bizType;

    Biz(int bizType) {
        this.bizType = bizType;
    }

    public static Biz get(int bizType) {
        for (Biz value : values()) {
            if (value.value() == bizType) {
                return value;
            }
        }
        return null;
    }

    public int value() {
        return bizType;
    }
}
