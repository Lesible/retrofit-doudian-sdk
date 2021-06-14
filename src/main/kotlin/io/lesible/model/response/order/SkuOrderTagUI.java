package io.lesible.model.response.order;

import lombok.Data;

/**
 * <p> @date: 2021-06-09 21:32</p>
 *
 * @author 何嘉豪
 */
@Data
public class SkuOrderTagUI {

    /**
     * 标签 key
     */
    private String key;

    /**
     * 标签文案
     */
    private String text;

    /**
     * 标签备注文案
     */
    private String hoverText;

    /**
     * 标签类型: 颜色
     */
    private String tagType;

    /**
     * 帮助文档
     */
    private String helpDoc;

    /**
     * 排序
     */
    @Deprecated
    private Integer sort;

}
