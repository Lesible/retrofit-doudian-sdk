package io.lesible.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p> @date: 2021-04-20 19:16</p>
 *
 * @author 何嘉豪
 */
@Data
@AllArgsConstructor
public class Authorization {

    private String appKey;

    private String appSecret;

}
