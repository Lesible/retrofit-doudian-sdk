package io.lesible.model.response.order;

import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-22 15:09</p>
 *
 * @author 何嘉豪
 */
@Data
public class LogisticsInfo {

    /**
     * 物流单号
     */
    private String trackingNo;

    /**
     * 物流公司
     */
    private String company;

    /**
     * 发货时间
     */
    private Long shipTime;

    /**
     * 包裹 id
     */
    private String deliveryId;

    /**
     * 物流公司名称
     */
    private String companyName;

    /**
     * 商品信息
     */
    private List<OrderProduct> productInfo;

}
