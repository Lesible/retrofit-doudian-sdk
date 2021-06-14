package io.lesible.model.response.order;

import lombok.Data;

/**
 * <p> @date: 2021-04-23 18:00</p>
 *
 * @author 何嘉豪
 */
@Data
public class PromotionDetail {

    /**
     * 店铺优惠信息
     */
    private DiscountDetail shopDiscountDetail;

    /**
     * 达人优惠信息
     */
    private DiscountDetail platformDiscountDetail;

    /**
     * 平台优惠信息
     */
    private DiscountDetail kolDiscountDetail;

}
