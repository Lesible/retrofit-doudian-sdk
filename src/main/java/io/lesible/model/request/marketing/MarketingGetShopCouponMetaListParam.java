package io.lesible.model.request.marketing;

import io.lesible.model.enumeration.CouponType;
import lombok.*;

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
    @Getter(AccessLevel.NONE)
    private Integer type;
    /**
     *
     */
    private Integer offset;
    private Integer limit;
    private Integer isShow;

    public CouponType getType() {
        return CouponType.get(type);
    }

}
