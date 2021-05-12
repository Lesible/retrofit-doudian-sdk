package io.lesible.model.enumeration;

/**
 * <p> @date: 2021-04-23 18:08</p>
 *
 * @author 何嘉豪
 */
public enum CouponType {

    /**
     * 平台折扣券
     */
    PLATFORM_DISCOUNT_COUPON(1),

    /**
     * 平台直减券
     */
    PLATFORM_DIRECT_DISCOUNT_COUPON(2),

    /**
     * 商家折扣券
     */
    PLATFORM_FULL_DISCOUNT_COUPON(3),

    /**
     * 商家直减券
     */
    SHOP_DIRECT_DISCOUNT_COUPON(22),

    /**
     * 商家满减券
     */
    SHOP_FULL_DISCOUNT_COUPON(23),

    /**
     * 渠道折扣券
     */
    CHANNEL_DISCOUNT_COUPON(31),

    /**
     * 渠道直减券
     */
    CHANNEL_DIRECT_DISCOUNT_COUPON(32),

    /**
     * 渠道满减券
     */
    CHANNEL_FULL_DISCOUNT_COUPON(33),

    /**
     * 单品折扣券
     */
    ITEM_DISCOUNT_COUPON(41),

    /**
     * 单品直减券
     */
    ITEM_DIRECT_DISCOUNT_COUPON(42),

    /**
     * 单品满减券
     */
    ITEM_FULL_DISCOUNT_COUPON(43);

    private final int couponType;

    CouponType(int couponType) {
        this.couponType = couponType;
    }

    public static CouponType get(int couponType) {
        for (CouponType value : values()) {
            if (value.value() == couponType) {
                return value;
            }
        }
        return null;
    }

    public int value() {
        return couponType;
    }
}
