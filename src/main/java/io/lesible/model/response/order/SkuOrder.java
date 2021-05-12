package io.lesible.model.response.order;

import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-22 15:17</p>
 *
 * @author 何嘉豪
 */
@Data
public class SkuOrder {

    /**
     * 商品订单号
     */
    private String orderId;

    /**
     * 父订单号（店铺订单号）
     */
    private String parentOrderId;

    /**
     * 订单层级
     */
    private Integer orderLevel;

    /**
     * 业务来源：1-鲁班 2-小店 3-好好学习等
     *
     * @see io.lesible.model.enumeration.Biz
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
     *
     * @see io.lesible.model.enumeration.OrderStatus
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
     *
     * @see io.lesible.model.enumeration.SubBType
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
     * 物流收货时间
     */
    private Long logisticsReceiptTime;

    /**
     * 用户确认收货时间
     */
    private Long confirmReceiptTime;

    /**
     * 商品类型
     */
    private Integer goodsType;

    /**
     * 商品ID
     */
    private Long productId;


    /**
     * 商品 skuId
     */
    private Long skuId;


    /**
     * 规格信息商品skuId
     */
    private List<SkuSpec> spec;

    /**
     * 一级类目
     */
    private Long firstCid;

    /**
     * 二级类目
     */
    private Long secondCid;

    /**
     * 三级类目
     */
    private Long thirdCid;

    /**
     * 四级类目
     */
    private Long fourthCid;

    /**
     * 外部 Sku id
     */
    private String outSkuId;

    /**
     * sku外部供应商编码
     */
    private String supplierId;

    /**
     * 商品外部编码
     */
    private String outProductId;

    /**
     * 仓 id
     */
    private List<String> warehouseIds;

    /**
     * 外部仓 id
     */
    private List<String> outWarehouseIds;

    /**
     * 库存类型，普通库存/区域库存
     */
    private String inventoryType;

    /**
     * 库存类型描述
     */
    private String inventoryTypeDesc;

    /**
     * 库存扣减方式
     */
    private Integer reduceStockType;

    /**
     * 库存扣减方式名称
     */
    private String reduceStockTypeDesc;

    /**
     * 商品现价
     */
    private Long originAmount;

    /**
     * 是否包税
     */
    private Boolean hasTax;

    /**
     * 商品件数
     */
    private Integer itemNum;

    /**
     * 商品总价 商品现价*件数
     */
    private Long sumAmount;

    /**
     * 商品来源平台
     */
    private String sourcePlatform;

    private String cBizDesc;
    private Long cBiz;
    private String sendPay;
    private String authorId;
    private Long cid;
    private String authorName;
    private Long roomId;
    private String code;
    private String themeTypeDesc;
    private String originId;
    private String themeType;
    private Long pageId;
    private String contentId;
    private String sendPayDesc;
    private String videoId;

    /**
     * 仓库信息
     */
    private List<Inventory> inventoryList;

    /**
     * 商品图片
     */
    private String productPic;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 是否评价 :1已评价，0未评价
     */
    private Integer isComment;
}
