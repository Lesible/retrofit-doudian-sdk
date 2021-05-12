package io.lesible.model.response.product;

import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-22 18:18</p>
 *
 * @author 何嘉豪
 */
@Data
public class Spec {

    private Long specId;

    private List<Value> values;

    private String name;

    private Long pid;

    private Long id;

    private Integer isLeaf;

}
