package io.lesible.model.response.order;

import io.lesible.model.enumeration.CBiz;
import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-23 17:16</p>
 *
 * @author 何嘉豪
 */
@Data
public class ShopOrderDetail {
    /**
     * 卖家留言
     */
    private String buyerWords;

    /**
     * 店铺 id
     */
    private Long shopId;

    /**
     * 商户名称
     */
    private String shopName;

    /**
     * 抖音小程序id
     */
    private String openId;

    /**
     * 店铺订单号
     */
    private String orderId;

    /**
     * 订单层级
     */
    private Integer orderLevel;

    /**
     * 业务来源：1-鲁班 2-小店 3-好好学习等
     *
     * @see CBiz
     */
    private Integer biz;

    /**
     * 业务来源描述
     */
    private String bizDesc;

    /**
     * 订单类型：0-普通订单 2-虚拟订单 4-平台券码 5-商家券码
     *
     * @see io.lesible.model.enumeration.OrderType
     */
    private Integer orderType;

    /**
     * 订单类型描述
     */
    private String orderTypeDesc;

    /**
     * 交易类型：1-拼团 2-定金预售
     *
     * @see io.lesible.model.enumeration.TradeType
     */
    private Integer tradeType;

    /**
     * 交易类型描述
     */
    private String tradeTypeDesc;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 订单状态描述
     */
    private String orderStatusDesc;

    /**
     * 主流程状态
     */
    private Integer mainStatus;

    /**
     * 主流程状态描述
     */
    private String mainStatusDesc;

    /**
     * 支付时间
     */
    private Long payTime;

    /**
     * 订单过期时间
     */
    private Long orderExpireTime;

    /**
     * 订单完成时间
     */
    private Long finishTime;

    /**
     * 下单时间
     */
    private Long createTime;

    /**
     * 订单更新时间
     */
    private Long updateTime;

    /**
     * 取消原因
     */
    private String cancelReason;

    /**
     * 商家备注
     */
    private String sellerWords;

    /**
     * 下单端：0-站外 1-火山 2-抖音等
     *
     * @see io.lesible.model.enumeration.BType
     */
    private Integer bType;

    /**
     * 下单端描述
     */
    private String bTypeDesc;

    /**
     * 下单场景：0 未知 1 app 2 小程序 3 H5
     */
    private Integer subBType;

    /**
     * 下单场景描述
     */
    private String subBTypeDesc;

    /**
     * 小程序id
     */
    private Long appId;

    /**
     * 支付类型：0-货到付款 1-微信 2-支付宝
     *
     * @see io.lesible.model.enumeration.PayType
     */
    private Integer payType;

    /**
     * 支付流水号
     */
    private String channelPaymentNo;

    /**
     * 订单金额（分）
     */
    private Long orderAmount;

    /**
     * 支付金额（分）
     */
    private Long payAmount;

    /**
     * 快递费（分）
     */
    private Long postAmount;

    /**
     * 运费险金额
     */
    private Long postInsuranceAmount;

    /**
     * 改价金额变化量
     */
    private Long modifyAmount;

    /**
     * 改价运费金额变化量
     */
    private Long modifyPostAmount;

    /**
     * 单优惠总金额 = 店铺优惠金额 + 平台优惠金额 + 达人优惠金额 + 支付优惠金额
     */
    private Long promotionAmount;

    /**
     * 店铺优惠金额
     */
    private Long promotionShopAmount;

    /**
     * 平台优惠金额
     */
    private Long promotionPlatformAmount;

    /**
     * 平台优惠金额卖家承担部分
     */
    private Long shopCostAmount;

    /**
     * 平台优惠金额平台承担部分
     */
    private Long platformCostAmount;

    /**
     * 达人优惠金额
     */
    private Long promotionTalentAmount;

    /**
     * 支付优惠金额
     */
    private Long promotionPayAmount;

    /**
     * 卖家应收金额
     */
    private Long shopReceivableAmount;

    /**
     * 收件人电话
     */
    private String postTel;

    /**
     * 收件人姓名
     */
    private String postReceiver;

    /**
     * 收件人地址
     */
    private PostAddr postAddr;

    /**
     * 预计发货时间
     */
    private Long expShipTime;

    /**
     * 发货时间
     */
    private Long shipTime;

    /**
     * 物流信息
     */
    private List<LogisticsInfo> logisticsInfo;

    /**
     * 优惠信息
     */
    private PromotionDetail promotionDetail;

    /**
     * 商品单信息
     */
    private List<SkuOrder> skuOrderList;

    /**
     * "插旗信息：0：灰 1：紫 2: 青 3：绿 4： 橙 5： 红"
     */
    private Integer sellerRemarkStars;

    /**
     * 订金预售阶段单
     */
    private List<OrderPhase> orderPhaseList;

}
