package io.lesible.model.response.shop;

import lombok.Data;

/**
 * <p> @date: 2021-05-25 15:16</p>
 *
 * @author 何嘉豪
 */
@Data
public class CategoryInfo {

    /**
     * 类目 id
     */
    private Long id;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 类目级别: 1,2,3 级类目
     */
    private Integer level;

    /**
     * 父类目 id
     */
    private Long parentId;

    /**
     * 是否为叶子结点,意味着没有子节点了
     */
    private Boolean isLeaf;

    /**
     * 是否有效
     */
    private Boolean enable;

}
