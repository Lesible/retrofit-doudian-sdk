package io.lesible.model.enumeration;

import java.util.Arrays;

/**
 * <p> @date: 2021-04-23 18:21</p>
 *
 * @author 何嘉豪
 */
public enum CampaignType {

    /**
     * 限时特卖
     */
    FLASH_SALE(7),

    /**
     * 定金预售
     */
    DEPOSIT_PRE_SELL(10),

    /**
     * 店铺满减活动
     */
    SHOP_FULL_DISCOUNT(100),

    /**
     * 平台满减活动
     */
    PLATFORM_FULL_DISCOUNT(110),

    /**
     * 拼团
     */
    GROUP(120);

    private final int campaignType;

    CampaignType(int campaignType) {
        this.campaignType = campaignType;
    }

    public static CampaignType get(int campaignType) {
        return Arrays.stream(values()).filter(it -> it.campaignType == campaignType)
                .findAny().orElse(null);
    }
    
    public int getCampaignType() {
        return campaignType;
    }
}
