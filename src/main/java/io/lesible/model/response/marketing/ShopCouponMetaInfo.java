package io.lesible.model.response.marketing;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.lesible.model.enumeration.CouponPeriodType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShopCouponMetaInfo {

    CouponPeriodType aa;
    /**
     * 优惠券批次 id
     */
    private String couponMetaId;
    /**
     * 生效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    /**
     * 过期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expireTime;
    /**
     * 类型
     * 1. 固定有效期类型
     * 2. 浮动有效期类型
     *
     * @see io.lesible.model.enumeration.CouponPeriodType
     */
    private Integer periodType;

    private Integer validPeriod;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endApplyTime;
    private String description;
    private Integer discount;
    private String opName;
    private Integer threshold;
    private Integer type;
    private String couponName;
    private String typeDetail;
    private Integer maxApplyTimes;
    private Integer payType;
    private Integer credit;
    private Integer maxDiscountLimit;


    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startApplyTime;

    private Integer isShow;
    private String url;
    private Integer shopId;
    private Integer totalAmount;
    private Integer usedAmount;
    private Integer leftAmount;
    private Integer dayMaxApplyTimes;
    private Integer status;
}