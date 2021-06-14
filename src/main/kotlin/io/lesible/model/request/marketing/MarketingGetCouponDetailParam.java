package io.lesible.model.request.marketing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> @date: 2021-06-11 14:16</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketingGetCouponDetailParam {

    /**
     * 优惠券批次 id
     */
    private Long couponMetaId;

}
