package io.lesible.model.response.sku;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class SkuListInfo {

    /**
     * skuId
     */
    private Long id;

    /**
     * 已废弃,无业务意义
     */
    private Long openUserId;

    /**
     * sku 外部 id
     */
    private Long outSkuId;

    /**
     * sku 对应的商家编码
     */
    private String code;

    /**
     * 商品 id,整形
     */
    private Long productId;

    /**
     * 商品 id,字符串
     */
    private String productIdStr;

    /**
     * 一级规格 id
     */
    @JsonProperty("spec_detail_id1")
    private Long firstSpecDetailId;

    /**
     * 二级规格 id,缺省为 0
     */
    @JsonProperty("spec_detail_id2")
    private Integer secondSpecDetailId;

    /**
     * 三级规格 id,缺省为 0
     */
    @JsonProperty("spec_detail_id3")
    private Integer thirdSpecDetailId;

    /**
     * 一级规格名称
     */
    @JsonProperty("spec_detail_name1")
    private String firstSpecDetailName;

    /**
     * 二级规格名称
     */
    @JsonProperty("spec_detail_name2")
    private String secondSpecDetailName;

    /**
     * 三级规格名称
     */
    @JsonProperty("spec_detail_name3")
    private String thirdSpecDetailName;

    /**
     * 剩余库存数
     */
    private Integer stockNum;

    /**
     * 预占库存数
     */
    @JsonProperty("prehold_stock_num")
    private Integer preHoldStockNum;

    /**
     * 阶梯库存数
     */
    private Integer stepStockNum;

    /**
     * 预占阶梯库存数
     */
    @JsonProperty("prehold_step_stock_num")
    private Integer preHoldStepStockNum;

    /**
     * 活动库存数
     */
    private Integer promStockNum;

    /**
     * 活动阶梯库存
     */
    private Integer promStepStockNum;

    /**
     * 价格  单位分
     */
    private Integer price;

    /**
     * 已废弃，无业务意义
     */
    private Integer settlementPrice;

    /**
     * 规格组 id
     */
    private Long specId;

    /**
     * 创建时间 秒时间戳
     */
    private Long createTime;

    /**
     * 库存类型：0普通库存，1区域库存
     */
    private Integer skuType;

    private Object customsReportInfo;

    /**
     * 区域仓库存信息，out_warehouse_id 与 stock_num对应关系
     */
    private Map<String, Integer> stockMap;

    /**
     * 区域仓预占库存信息，out_warehouse_id 与 pre_hold_stock_num对应关系
     */
    @JsonProperty("prehold_stock_map")
    private Map<String, Integer> preHoldStockMap;
}