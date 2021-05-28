package io.lesible.model.response.order;

import lombok.Data;

/**
 * <p> @date: 2021-05-28 11:43</p>
 * 订金预售阶段单
 *
 * @author 何嘉豪
 */
@Data
public class OrderPhase {

    /**
     * 阶段单 id
     */
    private String phaseOrderId;

    /**
     * 总共的阶段数
     */
    private Integer totalPhase;

    /**
     * 当前的阶段
     */
    private Integer currentPhase;

    /**
     * 是否支付成功
     */
    private Boolean paySuccess;

    /**
     * 商品单 id
     */
    private Long skuOrderId;

    /**
     * 活动 id
     */
    private Long campaignId;

    /**
     * 阶段定价
     */
    private Long parsePayablePrice;

    /**
     * 支付类型
     *
     * @see io.lesible.model.enumeration.PayType
     */
    private Integer phasePayType;

    /**
     * 阶段单开始支付时间
     */
    private Long phaseOpenTime;

    /**
     * 阶段单支付成功时间
     */
    private Long phasePayTime;

    /**
     * 阶段单关闭时间
     */
    private Long phaseCloseTime;

    /**
     * 渠道支付订单号
     */
    private String channelPaymentNo;

    /**
     * 阶段单总金额
     */
    private Long phaseOrderAmount;

    /**
     * 阶段单订单金额
     */
    private Long phaseSumAmount;

    /**
     * 阶段单运费金额
     */
    private Long phasePostAmount;

    /**
     * 阶段单用户实际支付金额
     */
    private Long phasePayAmount;

    /**
     * 阶段单总优惠金额
     */
    private Long phasePromotionAmount;

    /**
     * 阶段状态描述
     */
    private String currentPhaseStatusDesc;

    /**
     * sku 单价
     */
    private Long skuPrice;


}
