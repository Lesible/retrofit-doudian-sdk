package io.lesible.model.response.billing;

import lombok.Data;

/**
 * <p> @date: 2021-06-15 11:50</p>
 *
 * @author 何嘉豪
 */
@Data
public class AllianceInfo {

    /**
     * 订单 id
     */
    private String orderId;

    /**
     * 产品 id
     */
    private String productId;

    /**
     * 达人账户
     */
    private String authorAccount;

    /**
     * 达人 shortId
     */
    private String shortId;

    /**
     * 支付金额 单位 分
     */
    private Long totalPayAmount;

    /**
     * 万为基数
     */
    private Integer commissionRate;

    /**
     * 预估佣金
     */
    private Long estimatedCommission;

    /**
     * 真实佣金
     */
    private Long realCommission;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 店铺 id
     */
    private String shopId;

    /**
     * 业务类型
     */
    private String allianceBizType;

    /**
     * 阶段单号
     */
    private Long phaseId;

}
