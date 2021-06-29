package io.lesible.model.request.marketing;

import io.lesible.model.enumeration.CouponType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p> @date: 2021-06-03 11:56</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketingGetShopCouponMetaListParam {

    /**
     * 优惠券批次 id
     */
    private Long couponMetaId;

    /**
     * 开始生效时间
     * <p>
     * format: yyyy/MM/dd HH:mm
     */
    private String startTime;

    /**
     * 过期时间
     * <p>
     * format: yyyy/MM/dd HH:mm
     */
    private String expireTime;

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
     * 偏移
     */
    private Integer offset;

    /**
     * 每页最大个数
     */
    private Integer limit;

    /**
     * 是否全网推广
     * -1 : 全部
     * 0: 全网推广 1: 自有渠道
     * 3: 新客专享 4: 定向券
     * 5: 单品广告推广券 6:评价返券
     * 9: 会员开卡礼
     */
    private Integer isShow;

    /**
     * 开始领取时间
     */
    private String startApplyTime;

    /**
     * 结束领取时间
     */
    private String endApplyTime;

    private List<CouponType> types;

    private List<Integer> statuses;

}
