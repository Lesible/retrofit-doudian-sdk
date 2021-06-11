package io.lesible.model.request.marketing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lesible.model.enumeration.CouponApplyScene;
import io.lesible.model.enumeration.CouponPeriodType;
import io.lesible.model.enumeration.CouponType;
import io.lesible.model.enumeration.PromoteType;
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
    @JsonProperty("type")
    private CouponType couponType;

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
     * 根据 type 传不同参数
     * <p>
     * 商家券使用 shopId
     * <p>
     * 商品券使用多个商品 id ',' 间隔
     */
    private String typeDetail;

    /**
     * 折扣券折扣 8.5 折传 85
     */
    private Integer discount;

    /**
     * 最大折扣金额 折扣券使用
     */
    private Long maxDiscountLimit;

    /**
     * 满减券门槛
     */
    private Long threshold;

    /**
     * 满减券/直减券金额
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
    @JsonProperty("pay_type")
    private CouponApplyScene couponApplyScene;

    /**
     * 领完返回的 url
     */
    private String url;

    /**
     * 0: 全网店铺推广
     * 1: 自有渠道推广
     */
    @JsonProperty("is_show")
    private PromoteType promoteType;

    /**
     * 文档没有的
     * <p>
     * 店铺名称
     */
    private String opName;

}
