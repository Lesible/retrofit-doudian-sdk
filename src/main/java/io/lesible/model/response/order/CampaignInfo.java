package io.lesible.model.response.order;

import lombok.Data;

/**
 * <p> @date: 2021-04-27 14:07</p>
 *
 * @author 何嘉豪
 */
@Data
public class CampaignInfo {

    private Long marketPrice;
    private String title;
    private Long salePrice;

    /**
     * 活动 id
     */
    private Long campaignId;

    /**
     * 活动类型
     * <p>
     * 7: 商家侧限时限量购 (平台侧就是平台直降)
     * 10: 定金预售
     * 100: 店铺满减活动
     * 110: 平台满减活动
     * 120: 拼团
     *
     * @see io.lesible.model.enumeration.CampaignType
     */
    private Integer campaignType;

    /**
     * 活动名称
     */
    private String campaignName;

    /**
     * 活动金额
     */
    private String campaignAmount;

    /**
     * 活动子类型
     * <p>
     * 0: 店铺活动
     * 1: 平台活动
     */
    private Integer campaignSubType;

    /**
     * 成本分摊
     */
    private ShareDiscountCost shareDiscountCost;
}
