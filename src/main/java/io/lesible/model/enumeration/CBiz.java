package io.lesible.model.enumeration;

import java.util.Arrays;

/**
 * <p> @date: 2021-04-22 14:29</p>
 *
 * @author 何嘉豪
 */
public enum CBiz {

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
    TICTOK_SHOP(12),

    /**
     * 抖+
     */
    DOU_PLUS(14),

    /**
     * 穿山甲
     */
    PANGOLIN(15),

    /**
     * 服务市场
     */
    SERVICE_MARKET(16),

    /**
     * 服务市场外包客服
     */
    OUTSOURCE_SERVICE_MARKET(18);

    private final Integer cBiz;

    CBiz(Integer cBiz) {
        this.cBiz = cBiz;
    }

    public static CBiz get(Integer cBiz) {
        if (cBiz == null) {
            return null;
        }
        return Arrays.stream(values()).filter(it -> it.cBiz.equals(cBiz))
                .findAny().orElse(null);
    }

    public Integer getCBiz() {
        return cBiz;
    }
}
