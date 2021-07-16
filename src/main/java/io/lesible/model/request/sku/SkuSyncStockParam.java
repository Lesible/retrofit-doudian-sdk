package io.lesible.model.request.sku;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> @date: 2021-07-16 16:39</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkuSyncStockParam {

    /**
     * skuId
     */
    private Long skuId;

    /**
     * 外部仓库ID ，如果传入则代表设置的区域库存，不传入则设置为普通库存
     */
    private Long outWarehouseId;

    /**
     * 供应商 id
     */
    private Long supplierId;

    /**
     * true表示增量库存，false表示全量库存，默认为false
     */
    private Boolean incremental;

    /**
     * 幂等ID， incremental=true的时候必填
     */
    private Long idempotentId;

    /**
     * 库存,可以为 0
     */
    private Integer stockNum;

    /**
     * 阶梯库存 (可以为0)，阶梯库存类型的商品才支持更新
     */
    private Integer stepStockNum;

}
