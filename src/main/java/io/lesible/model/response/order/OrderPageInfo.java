package io.lesible.model.response.order;

import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-22 14:20</p>
 *
 * @author 何嘉豪
 */
@Data
public class OrderPageInfo {

    /**
     * 页数，从0开始
     */
    private Integer page;

    /**
     * 总订单数
     */
    private Integer total;

    /**
     * 单页大小
     */
    private Integer size;

    /**
     * 订单信息集
     */
    private List<ShopOrderInfo> shopOrderList;

}
