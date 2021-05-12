package io.lesible.model.response.order;

import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-27 14:05</p>
 *
 * @author 何嘉豪
 */
@Data
@Deprecated
public class OldOrderPageInfo {

    /**
     * 当前查询条件订单总数
     */
    private Integer total;

    /**
     * 当前页的数量
     */
    private Integer count;

    /**
     * 订单数据
     */
    private List<OldShopOrderInfo> list;
}