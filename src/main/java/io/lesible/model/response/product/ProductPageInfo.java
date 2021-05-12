package io.lesible.model.response.product;

import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-21 10:09</p>
 *
 * @author 何嘉豪
 */
@Data
public class ProductPageInfo {

    /**
     * 商品总数
     */
    private Integer all;

    /**
     * 以当前 size 所得的分页数
     */
    private Integer allPages;

    /**
     * 当前条件 data 返回结果数量
     */
    private Integer count;

    /**
     * 每页的数据量
     */
    private Integer pageSize;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 数据
     */
    private List<ProductInfo> data;

}
