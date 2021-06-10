package io.lesible.model.enumeration;

import java.util.Arrays;

/**
 * <p> @date: 2021-06-10 17:05</p>
 *
 * @author 何嘉豪
 */
public enum CouponApplyScene {

    /**
     * 货到付款
     */
    PAY_ON_DELIVERY(0),

    /**
     * 在线支付
     */
    PAY_ONLINE(1),

    /**
     * 两种场景都支持
     */
    MIXED(2);

    private final int couponApplyScene;

    CouponApplyScene(int couponApplyScene) {
        this.couponApplyScene = couponApplyScene;
    }

    public static CouponApplyScene get(int couponApplyScene) {
        return Arrays.stream(values()).filter(it -> it.couponApplyScene == couponApplyScene)
                .findAny().orElse(null);
    }

    public int getCouponApplyScene() {
        return couponApplyScene;
    }
}


