package io.lesible.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> @date: 2021-04-20 19:04</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiFactoryConfig {

    /**
     * 抖店 api 请求地址
     */
    private String baseUrl;

    /**
     * 默认 key
     */
    private String defaultKey;

    /**
     * 默认 secret
     */
    private String defaultSecret;

}
