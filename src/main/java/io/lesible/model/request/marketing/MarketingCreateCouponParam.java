package io.lesible.model.request.marketing;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.lesible.model.enumeration.CouponPeriodType;
import io.lesible.model.enumeration.CouponType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * <p> @date: 2021-06-10 16:40</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketingCreateCouponParam {

    /**
     * 优惠券名称
     */
    private String couponName;

    /**
     * 优惠券类型
     *
     * @see io.lesible.model.enumeration.CouponType
     */
    private CouponType type;

    /**
     * 类型
     * 1. 固定有效期类型
     * 2. 浮动有效期类型
     *
     * @see io.lesible.model.enumeration.CouponPeriodType
     */
    private CouponPeriodType periodType;

    /**
     * periodType 是 FLOAT_PERIOD 时使用
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
     * 总库存
     */
    private Integer totalAmount;

    /**
     * 限制信息,取决于 type
     */
    private String typeDetail;

    /**
     * 折扣
     */
    private Integer discount;

    /**
     * 最大折扣金额 折扣券使用
     */
    private Integer maxDiscountLimit;

    /**
     * 满减券的前置金额
     */
    private Long threshold;

    /**
     * 扣减金额
     */
    private Long credit;


    /**
     * 单个用户最多领取数量
     */
    private Integer maxApplyTimes;

    /**
     * 支持使用的支付类型
     * 0: 货到付款
     * 1: 在线支付
     * 2: 货到付款.在线支付都支持
     */
    private Integer payType;

    /**
     * 领完返回的 url
     */
    private String url;

    /**
     * 0: 全网店铺推广
     * 1: 自有渠道推广
     */
    private Integer isShow;

}
