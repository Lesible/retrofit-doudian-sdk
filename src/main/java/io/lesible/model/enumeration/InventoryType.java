package io.lesible.model.enumeration;

import java.util.Arrays;

/**
 * <p> @date: 2021-05-28 16:12</p>
 * 库存类型描述
 *
 * @author 何嘉豪
 */
public enum InventoryType {

    /**
     * 普通库存
     */
    NORMAL_INVENTORY(1),

    /**
     * 暂时还不知道啥类型 官方文档不明
     * 碰到该类型的同学请私我返回一下 inventoryTypeDesc
     * <p>
     * 2021-05-28
     */
    UNKNOWN(2),

    /**
     * 阶梯库存
     */
    ECHELON_INVENTORY(3),

    /**
     * 活动库存
     */
    CAMPAIGN_INVENTORY(4),
    /**
     * 活动阶梯库存
     */
    CAMPAIGN_ECHELON_INVENTORY(5);

    private final int inventoryType;

    InventoryType(int inventoryType) {
        this.inventoryType = inventoryType;
    }

    public static InventoryType get(int inventoryType) {
        return Arrays.stream(values()).filter(it -> it.value() == inventoryType)
                .findAny().orElse(null);
    }

    public int value() {
        return inventoryType;
    }
}
