package io.lesible.model.response.order;

import lombok.Data;

/**
 * <p> @date: 2021-04-23 18:06</p>
 *
 * @author 何嘉豪
 */
@Data
public class CouponInfo {

    /**
     * 订单优惠券 id
     */
    private Long couponId;

    /**
     * 券类型,1平台折扣券 2平台直减券 3平台满减券 21 商家折扣券 22 商家直减券 23 商家满减券
     * 31 渠道折扣券 32 渠道直减券 33 渠道满减券 41 单品折扣券 42 单品直减券 43 单品满减券
     *
     * @see io.lesible.model.enumeration.CouponType
     */
    private Integer couponType;

    /**
     * 券批次 id
     */
    private Long couponMetaId;

    /**
     * 优惠金额
     */
    private Long couponAmount;

    /**
     * 券名称
     */
    private String couponName;

}
