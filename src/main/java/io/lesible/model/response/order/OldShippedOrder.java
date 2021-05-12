package io.lesible.model.response.order;

import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-28 14:12</p>
 *
 * @author 何嘉豪
 */
@Data
@Deprecated
public class OldShippedOrder {

    private Integer skuNum;
    private String shippedOrderId;
    private List<String> shippedItemIds;

}
