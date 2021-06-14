package io.lesible.model.response.marketing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lesible.model.enumeration.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CouponMetaDetail {


    /**
     * 优惠券批次 id
     */
    private String couponMetaId;

    /**
     * 优惠券名称
     */
    private String couponName;

    /**
     * 优惠券内容
     */
    private String couponString;

    /**
     * 满减券/直减券金额
     */
    private Long credit;

    /**
     * 结束领取时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endApplyTime;

    /**
     * 结束生效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expireTime;

    /**
     * 推广方式
     */
    @JsonProperty("is_show")
    private PromoteType promoteType;

    /**
     * 优惠券剩余库存
     */
    private Long leftAmount;

    /**
     * 单个用户最多领取数量
     */
    private Integer maxApplyTimes;

    /**
     * 折扣最高抵扣金额 折扣券使用
     */
    private Integer maxDiscountLimit;

    /**
     * 优惠券可以使用的场景
     */
    @JsonProperty("pay_type")
    private CouponApplyScene couponApplyScene;

    /**
     * 有效期类型
     */
    @JsonProperty("period_type")
    private CouponPeriodType couponPeriodType;

    /**
     * 店铺 id
     */
    private String shopId;

    /**
     * 店铺 logo
     */
    private String shopLogo;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * periodType 是 FLOAT_PERIOD 时使用
     * 浮动有效期 天数
     */
    private Integer validPeriod;

    /**
     * 满减券门槛
     */
    private Integer threshold;

    /**
     * 优惠券类型
     */
    @JsonProperty("type")
    private CouponType couponType;

    /**
     * 根据 type 不同而不同
     * <p>
     * 商家券使用 shopId
     * <p>
     * 商品券使用多个商品 id ',' 间隔
     */
    private String typeDetail;

    /**
     * 券类型
     */
    private String whatCoupon;

    /**
     * 券类型说明
     */
    private String typeString;

    /**
     * url
     */
    private String url;

    /**
     * 开始生效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    /**
     * 总数量
     */
    private Integer totalAmount;

    /**
     * 使用数
     */
    private Integer usedAmount;

    /**
     * 开始领取时间
     */
    private String startApplyTime;

    /**
     * 用户领取次数
     */
    private Integer userApplyTimes;

    /**
     * 优惠券状态
     */
    @JsonProperty("status")
    private CouponStatus couponStatus;
}