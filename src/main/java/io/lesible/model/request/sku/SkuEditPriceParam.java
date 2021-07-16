package io.lesible.model.request.sku;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> @date: 2021-07-16 14:59</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkuEditPriceParam {

    /**
     * skuId
     */
    private Long skuId;

    /**
     * 售价 单位 分
     */
    private Long price;


}
