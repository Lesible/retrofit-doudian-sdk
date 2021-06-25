package io.lesible.model.request.billing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p> @date: 2021-06-15 11:58</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillingAllianceGetOrderListParam {

    /**
     * 订单 id 列表
     */
    private List<String> orderIds;

}
