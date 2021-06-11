package io.lesible.model.request.marketing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> @date: 2021-06-11 13:41</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketingApplyCouponParam {

    /**
     * 抖店 open_id
     */
    private String doudianOpenId;

    /**
     * 优惠券批次 id
     */
    private Long couponMetaId;

    /**
     * 唯一请求 id
     * 保证幂等性
     */
    private String uniqueId;

}
