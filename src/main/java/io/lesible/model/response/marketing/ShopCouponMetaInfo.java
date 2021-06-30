package io.lesible.model.response.marketing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lesible.model.enumeration.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShopCouponMetaInfo {

    /**
     * 优惠券批次 id
     */
    private Long couponMetaId;
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
    private CouponPeriodType couponPeriodType;

    /**
     * 浮动有效期 天数
     */
    private Integer validPeriod;

    /**
     * 开始领取时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startApplyTime;

    /**
     * 结束领取时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endApplyTime;

    /**
     * 优惠券名称
     */
    private String couponName;

    /**
     * 优惠券描述
     */
    private String description;

    /**
     * 领完返回的 url
     */
    private String url;

    /**
     * 店铺名
     */
    private String opName;

    /**
     * 满减券的前置金额
     */
    private Long threshold;

    /**
     * 扣减金额
     */
    private Long credit;

    /**
     * 总库存
     */
    private Long totalAmount;

    /**
     * 当前剩余库存
     */
    private Long leftAmount;

    /**
     * 单个用户最多领取数量
     */
    private Integer maxApplyTimes;

    /**
     * 单日最多领取数量(未使用)
     */
    private Integer dayMaxApplyTimes;

    /**
     * 优惠券类型
     *
     * @see io.lesible.model.enumeration.CouponType
     */
    @JsonProperty("type")
    private CouponType couponType;

    /**
     * 限制信息,取决于 type
     */
    private String typeDetail;

    /**
     * 折扣
     */
    private Integer discount;

    /**
     * 优惠券状态
     */
    @JsonProperty("status")
    private CouponStatus couponStatus;

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

    /**
     * 最大折扣金额 折扣券使用
     */
    private Long maxDiscountLimit;

    /**
     * 使用数
     */
    private Integer usedAmount;

    /**
     * 支持使用的支付类型
     * 0: 货到付款
     * 1: 在线支付
     * 2: 货到付款.在线支付都支持
     *
     * @see io.lesible.model.enumeration.CouponApplyScene
     */
    @JsonProperty("pay_type")
    private CouponApplyScene couponApplyScene;

    /**
     * 0: 全网店铺推广
     * 1: 自有渠道推广
     *
     * @see io.lesible.model.enumeration.PromoteType
     */
    @JsonProperty("is_show")
    private PromoteType promoteType;

    /**
     * 店铺 id
     * 2319538
     */
    private Long shopId;

}