package io.lesible.model.request.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> @date: 2021-04-22 17:06</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailParam {

    /**
     * 商品id
     */
    private Long productId;

    /**
     * "true"：读取草稿数据；"false"：读取上架数据
     */
    private Boolean showDraft;

}
