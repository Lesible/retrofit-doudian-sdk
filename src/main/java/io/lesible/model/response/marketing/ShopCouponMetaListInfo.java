package io.lesible.model.response.marketing;

import lombok.Data;

import java.util.List;

@Data
public class ShopCouponMetaListInfo {
    private List<ShopCouponMetaInfo> shopCouponMetaList;
    private Integer count;
}