package io.lesible.model.request.marketing;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.lesible.model.enumeration.CouponStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> @date: 2021-06-11 11:31</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketingAbleCouponMetaParam {

    /**
     * 优惠券批次 id
     */
    private Long couponMetaId;

    /**
     * 优惠券状态
     */
    @JsonProperty("status")
    private CouponStatus couponStatus;

    /**
     * 店铺名
     */
    private String opName;

}
