package io.lesible.model.response.order;

import lombok.Data;

/**
 * <p> @date: 2021-04-27 14:07</p>
 *
 * @author 何嘉豪
 */
@Data
@Deprecated
public class CampaignInfo {

    private Long marketPrice;
    private String title;
    private Long salePrice;
    private Long campaignId;
}
