package io.lesible.model.response.order;

import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-22 15:14</p>
 *
 * @author 何嘉豪
 */
@Data
public class OrderProduct {

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品价格
     */
    private Integer price;

    /**
     * 商家编码
     */
    private String outerSkuId;

    /**
     * 商品skuId
     */
    private Long skuId;

    /**
     * 规格信息
     */
    private List<SkuSpec> skuSpecs;

    /**
     * 商品数量
     */
    private Integer productCount;

    /**
     * 商品 ID
     */
    private Long productId;

    /**
     * 商品单ID
     */
    private String skuOrderId;

}
