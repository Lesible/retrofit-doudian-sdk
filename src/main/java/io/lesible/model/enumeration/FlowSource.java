package io.lesible.model.enumeration;

import java.util.Arrays;

/**
 * <p> @date: 2021-05-28 15:30</p>
 *
 * @author 何嘉豪
 */
public enum FlowSource {

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
    MALL(3),

    /**
     * 自主经营
     */
    SELF_BIZ(4),
    /**
     * 线索通
     */
    XIANSUOTONG(5),

    /**
     * 抖音门店
     */
    TICTOK_SHOP(6),

    /**
     * 抖+
     */
    DOU_PLUS(7),

    /**
     * 穿山甲
     */
    PANGOLIN(8);

    private final Integer flowType;

    FlowSource(Integer flowType) {
        this.flowType = flowType;
    }

    public static FlowSource get(Integer flowType) {
        if (flowType == null) {
            return null;
        }
        return Arrays.stream(values()).filter(it -> it.flowType.equals(flowType))
                .findAny().orElse(null);
    }

    public Integer getFlowType() {
        return flowType;
    }
}
