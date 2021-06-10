package io.lesible.model.response.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-28 11:27</p>
 *
 * @author 何嘉豪
 */
@Data
@Deprecated
public class OldShopOrderDetail {

    private Long taxAmount;
    private Long postAmount;
    private Integer urgeCnt;
    private Long shopCouponAmount;
    private Integer orderStatus;
    private Integer biz;
    private Integer finalStatus;
    private Integer orderType;
    private String postReceiver;
    private String createTime;
    @JsonProperty("c_biz")
    private Integer cBiz;
    private String logisticsCode;
    private Long platformDirectReductionPlatformAmount;
    private String buyerWords;
    private List<OldCouponInfo> couponInfo;
    private String payTime;
    private Boolean isInsurance;
    private Long shopId;
    private Long expShipTime;
    private Long adjustAmount;
    private Long adjustPostAmount;
    private Integer childNum;
    private Long authorId;
    private String openId;
    private String orderId;
    private List<OldShopChildOrderDetail> child;
    private String receiptTime;
    private String logisticsTime;
    private String cosRatio;
    @JsonProperty("sub_b_type")
    private Integer subBType;
    private Long logisticsId;
    private Integer sellerRemarkStars;
    private Long updateTime;
    private String isComment;
    private String postTel;
    private Integer payType;
    private Integer processType;
    @JsonProperty("b_type")
    private String bType;
    private Long orderTotalAmount;
    private Long couponAmount;
    private String groupBuyGroupId;
    private Long groupBuySuccessTime;
    private PostAddr postAddr;
    private String cancelReason;
    private Integer shippedNum;
    private String sellerWords;
    @JsonProperty("c_type")
    private String cType;
    private String postCode;
    private Integer tradeType;
    private Long promotionPayAmount;
    private List<OldLogistics> logisticsList;
    private String priceHasTaxType;
    private String encryptPostReceiver;
    private String encryptPostTel;
    private Long identityCardId;
    private Integer identityCheckState;
    private List<OrderPhase> orderPhaseList;
    private Object orderTag;
    private Long talentCouponDiscount;
    private Long talentCouponId;
    private Long talentCouponMetaId;
    private Long totalCanUseCount;
    private String useFrequencyMark;

}
