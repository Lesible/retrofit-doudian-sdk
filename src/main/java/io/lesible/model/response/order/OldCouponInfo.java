package io.lesible.model.response.order;

import lombok.Data;

/**
 * <p> @date: 2021-04-27 16:31</p>
 *
 * @author 何嘉豪
 */
@Data
@Deprecated
public class OldCouponInfo {

    private String name;
    private String description;
    private Integer discount;
    private Integer payType;
    private Long id;
    private Integer credit;
    private Integer type;

}
