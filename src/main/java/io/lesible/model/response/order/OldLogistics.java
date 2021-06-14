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
public class OldLogistics {

    private Integer shippedNum;
    private Long logisticsTime;
    private String packId;
    private List<OldShippedOrder> shippedOrderList;
    private String logisticsCompanyId;
    private String logisticsCode;
    private String logisticsCompanyName;

}
