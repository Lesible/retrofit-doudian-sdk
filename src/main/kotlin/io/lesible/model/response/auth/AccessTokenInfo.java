package io.lesible.model.response.auth;

import lombok.Data;

/**
 * <p> @date: 2021-04-23 15:37</p>
 *
 * @author 何嘉豪
 */
@Data
public class AccessTokenInfo {

    /**
     * 用于调用 API 的 access_token
     * 过期时间为 expires_in 值
     * 可通过 refresh_token 刷新获取新的 access_token，过期时间仍为 expires_in 值
     */
    private String accessToken;

    /**
     * 授权作用域，使用逗号,分隔。预留字段
     */
    private String scope;

    /**
     * 店铺 id
     */
    private Long shopId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * access_token接口调用凭证超时时间，单位（秒），默认有效期：7天
     */
    private Integer expiresIn;

    /**
     * 用于刷新access_token的刷新令牌（有效期：14 天）
     */
    private String refreshToken;
}
