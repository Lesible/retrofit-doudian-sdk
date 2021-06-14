package io.lesible.model.request.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品列表业务参数
 * <p> @date: 2021-04-19 17:00</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductListParam {

    /**
     * 页码
     */
    private String page;

    /**
     * 每页大小
     */
    private String size;

    /**
     * 指定状态返回商品列表：0上架 1下架
     */
    private String status;

    /**
     * 指定审核状态返回商品列表：1未提审 2审核中 3审核通过 4审核驳回 5封禁 7审核通过，待上架状态
     *
     * @see io.lesible.model.enumeration.CheckStatus
     */
    private String checkStatus;

}
