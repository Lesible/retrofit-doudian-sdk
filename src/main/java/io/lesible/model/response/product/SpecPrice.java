package io.lesible.model.response.product;

import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-22 17:52</p>
 *
 * @author 何嘉豪
 */
@Data
public class SpecPrice {

    /**
     * skuId
     */
    private Long skuId;

    /**
     * 外部商家 skuId
     */
    private Long outSkuId;

    /**
     * 新增，推荐使用，外部商家sku_id，支持字符串和数字2种
     */
    private String outerSkuId;

    private String code;
    private Long settlementPrice;
    private Integer skuType;
    private CustomsReportInfo customsReportInfo;
    private Integer stockNum;
    private Integer stepStockNum;
    private Integer lockStepStockNum;
    private Integer promotionStockNum;
    private Integer lockStockNum;
    private Object stockNumMap;
    private Long specDetailId1;
    private Long specDetailId2;
    private List<Long> specDetailIds;
    private Long specDetailId3;
    private Integer price;
    private Integer promStepStockNum;
    private Integer promStockNum;
    private String supplierId;
    private Integer promotionStepStockNum;

}
