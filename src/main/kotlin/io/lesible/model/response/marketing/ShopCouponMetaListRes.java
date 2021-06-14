package io.lesible.model.response.marketing;

import lombok.Data;

import java.util.List;

@Data
public class ShopCouponMetaListRes {

    /**
     * 优惠券数量
     */
    private Integer count;

    /**
     * 优惠券列表
     */
    private List<ShopCouponMetaInfo> shopCouponMetaList;
}