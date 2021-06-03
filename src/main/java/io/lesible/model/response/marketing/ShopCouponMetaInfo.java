package io.lesible.model.response.marketing;

import lombok.Data;

@Data
public class ShopCouponMetaInfo {
    private Integer validPeriod;
    private String endApplyTime;
    private String description;
    private Integer discount;
    private String opName;
    private Integer threshold;
    private Integer type;
    private String couponName;
    private String typeDetail;
    private Integer maxApplyTimes;
    private String updateTime;
    private Integer payType;
    private Integer credit;
    private Integer maxDiscountLimit;
    private String createTime;
    private String expireTime;
    private Integer isShow;
    private String url;
    private String couponMetaId;
    private Integer shopId;
    private String startTime;
    private Integer totalAmount;
    private Integer usedAmount;
    private Integer leftAmount;
    private String startApplyTime;
    private Integer periodType;
    private Integer dayMaxApplyTimes;
    private Integer status;
}