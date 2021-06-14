package io.lesible.model.enumeration;

import java.util.Arrays;

/**
 * 渠道类型
 * <p> @date: 2021-04-21 17:56</p>
 *
 * @author 何嘉豪
 */
public enum BType {

    /**
     * 站外渠道
     */
    OUT_SITE(0),

    /**
     * 火山渠道
     */
    HUOSHAN(1),

    /**
     * 抖音渠道
     */
    DOUYIN(2),

    /**
     * 头条渠道
     */
    TOUTIAO(3),

    /**
     * 西瓜渠道
     */
    XIGUA(4),

    /**
     * 微信渠道
     */
    WECHAT(5),

    /**
     * 值点渠道
     */
    ZHIDIAN(6),

    /**
     * 火山lite 渠道
     */
    HUOSHAN_LITE(7),

    /**
     * 懂车帝渠道
     */
    DONGCHEDI(8),

    /**
     * 皮皮虾渠道
     */
    PIPIXIA(9),

    /**
     * 抖音极速版渠道
     */
    DOUYIN_SPEED(11),

    /**
     * tiktok 渠道
     */
    TIKTOK(12),

    /**
     * musically 渠道
     */
    MUSICALLY(13),

    /**
     * 穿山甲渠道
     */
    PANGOLIN(14),

    /**
     * 火山极速版渠道
     */
    HUOSHAN_SPEED(15),

    /**
     * 服务市场渠道
     */
    SERVICE_MARKET(16);

    /**
     * 实际类型值
     */
    private final int bType;

    BType(int bType) {
        this.bType = bType;
    }

    public static BType get(int bType) {
        return Arrays.stream(values()).filter(it -> it.bType == bType)
                .findAny().orElse(null);
    }
    
    public int getBType() {
        return bType;
    }

}
