package io.lesible.model.response.order;

import lombok.Data;

/**
 * <p> @date: 2021-04-23 18:27</p>
 *
 * @author 何嘉豪
 */
@Data
public class ShareDiscountCost {

    /**
     * 平台承担金额
     */
    private Long platformCost;

    /**
     * 商家承担金额
     */
    private Long shopCost;

}
