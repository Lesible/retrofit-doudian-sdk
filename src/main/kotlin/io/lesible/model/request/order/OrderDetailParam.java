package io.lesible.model.request.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> @date: 2021-04-27 16:57</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@Deprecated
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailParam {

    /**
     * 店铺订单号 需要加上A
     */
    private String orderId;

}
