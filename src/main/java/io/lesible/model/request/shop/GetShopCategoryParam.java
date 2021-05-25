package io.lesible.model.request.shop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> @date: 2021-05-25 15:06</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetShopCategoryParam {

    /**
     * 类目 id
     */
    private Long cid;

}
