package io.lesible.model.response.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-27 14:22</p>
 *
 * @author 何嘉豪
 */
@Data
@Deprecated
public class OldSkuOrder {
    private Long postAmount;
    private Long comboAmount;
    private String pid;
    private Integer urgeCnt;
    private Long shopCouponAmount;
    private Integer orderStatus;
    private Integer finalStatus;
    private String productId;
    private Long outProductId;
    private Integer orderType;
    private String campaignId;
    private String postReceiver;
    private String createTime;
    private String productPic;
    private String logisticsCode;
    private Long platformDirectReductionPlatformAmount;
    private String buyerWords;
    private String productName;
    private List<OldCouponInfo> couponInfo;
    private String payTime;
    private Boolean isInsurance;
    private Long shopId;
    private Long expShipTime;
    private Long adjustAmount;
    private Long adjustPostAmount;
    private Long totalAmount;
    private List<String> itemIds;
    private String orderId;
    private String receiptTime;
    private String code;
    private String logisticsTime;
    private String cosRatio;
    @JsonProperty("sub_b_type")
    private Integer subBType;
    private Long logisticsId;
    private Integer sellerRemarkStars;
    private Long updateTime;
    private List<ProductTag> productTag;
    private String isComment;
    private String postTel;
    private Integer payType;
    private Integer processType;
    @JsonProperty("b_type")
    private String bType;
    private Long platformFullAmount;
    private Long couponAmount;
    private Long outSkuId;
    private String authorId;
    private String groupBuyGroupId;
    private Long groupBuySuccessTime;
    private List<SkuSpec> specDesc;
    private PostAddr postAddr;
    private Long comboId;
    private String couponMetaId;
    private Integer comboNum;
    private String cancelReason;
    private Integer shippedNum;
    private Integer preSaleType;
    private List<CampaignInfo> campaignInfo;
    private String sellerWords;
    @JsonProperty("c_type")
    private String cType;
    private String postCode;
    private String encryptPostReceiver;
    private String encryptPostTel;

    private String itemInventory;

    private String openId;

    private Object orderTag;

    private Integer scspWhType;

    private Long talentCouponDiscount;

    private Long talentCouponId;

    private Long talentCouponMetaId;

    private Integer tradeType;
}