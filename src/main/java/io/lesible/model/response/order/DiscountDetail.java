package io.lesible.model.response.order;

import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-23 18:02</p>
 *
 * @author 何嘉豪
 */
@Data
public class DiscountDetail {

    /**
     * 优惠总金额
     */
    private Long totalAmount;

    /**
     * 券优惠金额
     */
    private Long couponAmount;

    /**
     * 满减金额
     */
    private Long fullDiscountAmount;

    /**
     * 券信息
     */
    private List<CouponInfo> couponInfo;

    /**
     * 满减信息
     */
    private List<FullDiscountInfo> fullDiscountInfo;

}
