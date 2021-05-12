package io.lesible.model.response.order;

import lombok.Data;

/**
 * <p> @date: 2021-04-22 15:16</p>
 *
 * @author 何嘉豪
 */
@Data
public class SkuSpec {

    /**
     * 规格名称
     */
    private String name;

    /**
     * 规格值
     */
    private String value;
}
