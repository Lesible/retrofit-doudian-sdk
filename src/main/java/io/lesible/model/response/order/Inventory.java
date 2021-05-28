package io.lesible.model.response.order;

import lombok.Data;

/**
 * <p> @date: 2021-04-26 9:13</p>
 *
 * @author 何嘉豪
 */
@Data
public class Inventory {

    /**
     * 仓 id
     */
    private String warehouseId;

    /**
     * 外部仓 id
     */
    private String outWarehouseId;

    /**
     * 库存类型
     *
     * @see io.lesible.model.enumeration.InventoryType
     */
    private Integer inventoryType;

    /**
     * 库存类型描述
     */
    private String inventoryTypeDesc;

}
