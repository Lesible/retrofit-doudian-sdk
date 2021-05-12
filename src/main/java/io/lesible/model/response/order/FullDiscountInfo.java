package io.lesible.model.response.order;

import lombok.Data;

/**
 * <p> @date: 2021-04-23 18:20</p>
 *
 * @author 何嘉豪
 */
@Data
public class FullDiscountInfo {


    /**
     * 活动 id
     */
    private Long campaignId;

    /**
     * 活动类型 7限时特卖, 10定金预售 100店铺满减活动 110平台满减活动 120拼团
     *
     * @see io.lesible.model.enumeration.CampaignType
     */
    private Integer campaignType;

    /**
     * 成本分摊
     */
    private ShareDiscountCost shareDiscountCost;

    /**
     * 活动名称
     */
    private String campaignName;

    /**
     * 活动金额
     */
    private Long campaignAmount;

    /**
     * 活动子类型，0 店铺活动，1 平台活动
     */
    private Integer campaignSubType;
}

