package io.lesible.model.enumeration;

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

    public int value() {
        return subBType;
    }
}
