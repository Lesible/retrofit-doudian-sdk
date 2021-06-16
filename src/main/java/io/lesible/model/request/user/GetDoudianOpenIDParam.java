package io.lesible.model.request.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> @date: 2021-06-15 18:05</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetDoudianOpenIDParam {

    /**
     * 抖音开放平台的 openId
     */
    private String dyOpenId;

    /**
     * 小程序 appKey
     */
    private String dyClientKey;

}
