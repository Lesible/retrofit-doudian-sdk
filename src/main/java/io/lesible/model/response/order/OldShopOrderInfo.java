package io.lesible.model.response.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


/**
 * <p> @date: 2021-04-27 14:07</p>
 *
 * @author 何嘉豪
 */
@Data
@Deprecated
public class OldShopOrderInfo {

    private Long postAmount;
    private String receiptTime;
    private String logisticsTime;
    private String cosRatio;
    @JsonProperty("sub_b_type")
    private Integer subBType;
    private Integer urgeCnt;
    private Long shopCouponAmount;
    private Long logisticsId;
    private Integer orderStatus;
    private Integer biz;
    private Integer sellerRemarkStars;
    private Long updateTime;
    private Integer finalStatus;
    private String isComment;
    private String postTel;
    private Integer payType;
    private Integer processType;
    @JsonProperty("b_type")
    private String bType;
    private Integer orderType;
    private Long orderTotalAmount;
    private String postReceiver;
    private Long couponAmount;
    private String groupBuyGroupId;
    private String createTime;
    private Long groupBuySuccessTime;
    @JsonProperty("c_biz")
    private Integer cBiz;
    private PostAddr postAddr;
    private String logisticsCode;
    private Long platformDirectReductionPlatformAmount;
    private String buyerWords;
    private List<OldCouponInfo> couponInfo;
    private String payTime;
    private Boolean isInsurance;
    private Long shopId;
    private Long expShipTime;
    private String openId;
    private String cancelReason;
    private Integer shippedNum;
    private Long adjustAmount;
    private Long adjustPostAmount;
    private String sellerWords;
    @JsonProperty("c_type")
    private String cType;
    private String postCode;
    private Integer childNum;
    private String orderId;
    private List<OldSkuOrder> child;
    private String encryptPostReceiver;
    private String encryptPostTel;

    private Long identityCardId;

    private Integer identityCheckState;

    private List<OldLogistics> logisticsList;

    private Object orderTag;

    private Long promotionPayAmount;

    private Long talentCouponDiscount;

    private Long talentCouponId;

    private Long talentCouponMetaId;
}