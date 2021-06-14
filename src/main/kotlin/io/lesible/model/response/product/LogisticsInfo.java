package io.lesible.model.response.product;

import lombok.Data;

/**
 * <p> @date: 2021-04-22 18:27</p>
 *
 * @author 何嘉豪
 */
@Data
public class LogisticsInfo {

    private Integer netWeightQty;
    private Integer taxPayer;
    private Long originRegionId;
    private Integer customsClearType;
    private Long brandRegionId;
    private Long sourceRegionId;

}
