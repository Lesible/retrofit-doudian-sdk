package io.lesible.model.response.order;

import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-28 14:10</p>
 *
 * @author 何嘉豪
 */
@Data
@Deprecated
public class OldShopChildOrderDetail {

    private Long taxAmount;
    private Long postAmount;
    private Long comboAmount;
    private String pid;
    private Integer urgeCnt;
    private Long shopCouponAmount;
    private Integer orderStatus;
    private Integer finalStatus;
    private String productId;
    private OldAllianceInfo allianceInfo;
    private Long outProductId;
    private Integer orderType;
    private String campaignId;
    private String postReceiver;
    private String openId;
    private String createTime;
    private String productPic;
    private String logisticsCode;
    private Long platformDirectReductionPlatformAmount;
    private String buyerWords;
    private String productName;
    private String itemInventory;
    private List<OldCouponInfo> couponInfo;
    private String payTime;
    private Boolean isInsurance;
    private Long shopId;
    private Long expShipTime;
    private Long adjustAmount;
    private Long adjustPostAmount;
    private Long totalAmount;
    private List<String> itemIds;
    private Long authorId;
    private String orderId;
    private String receiptTime;
    private String code;
    private String logisticsTime;
    private String cosRatio;
    private Integer subBType;
    private Long logisticsId;
    private Integer sellerRemarkStars;
    private Long updateTime;
    private String isComment;
    private String postTel;
    private Integer payType;
    private Integer processType;
    private String bType;
    private Long platformFullAmount;
    private Long couponAmount;
    private Long outSkuId;
    private String groupBuyGroupId;
    private Long groupBuySuccessTime;
    private List<SkuSpec> specDesc;
    private PostAddr postAddr;
    private Long comboId;
    private String couponMetaId;
    private Integer comboNum;
    private String cancelReason;
    private Integer shippedNum;
    private List<CampaignInfo> campaignInfo;
    private String sellerWords;
    private String cType;
    private String postCode;
    private Integer tradeType;
    private String priceHasTaxType;

}
