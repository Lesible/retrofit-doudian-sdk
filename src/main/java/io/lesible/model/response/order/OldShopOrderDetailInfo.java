package io.lesible.model.response.order;

import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-28 11:18</p>
 *
 * @author 何嘉豪
 */
@Data
@Deprecated
public class OldShopOrderDetailInfo {

    private Integer total;
    private Integer count;
    private List<OldShopOrderDetail> list;

}
