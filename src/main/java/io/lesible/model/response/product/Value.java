package io.lesible.model.response.product;

import lombok.Data;

/**
 * <p> @date: 2021-04-22 18:19</p>
 *
 * @author 何嘉豪
 */
@Data
public class Value {

    private Long specId;
    private String name;
    private Long pid;
    private Long id;
    private Integer isLeaf;
    private Integer status;

}
