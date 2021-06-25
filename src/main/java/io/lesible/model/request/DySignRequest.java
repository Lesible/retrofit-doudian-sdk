package io.lesible.model.request;

import io.lesible.model.Authorization;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> @date: 2021-04-19 16:40</p>
 *
 * @author 何嘉豪
 */
@Data
@NoArgsConstructor
public class DySignRequest<T> {

    /**
     * 默认认证 Auth (appKey,appSecret)
     */
    public static Authorization DEFAULT_AUTHORIZATION;

    /**
     * appKey
     */
    private String appKey;

    /**
     * secret
     */
    private String appSecret;

    /**
     * 每个门店不同的 token
     */
    private String accessToken;

    /**
     * 请求的方法
     */
    private String method;

    /**
     * 业务参数
     */
    private T businessParam;

    /**
     * 时间戳,不能与当前时间差开 10 分钟
     */
    private String timestamp;

    /**
     * 签名,计算获得
     */
    private String sign;

    public DySignRequest(String appKey, String appSecret, String method, T businessParam, String accessToken) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.method = method;
        this.businessParam = businessParam;
        this.accessToken = accessToken;
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {

        private String appKey;

        private String appSecret;

        private String method;

        private String accessToken;

        private T businessParam;

        private Builder() {
        }

        public Builder<T> appKey(String appKey) {
            this.appKey = appKey;
            return this;
        }

        public Builder<T> appSecret(String appSecret) {
            this.appSecret = appSecret;
            return this;
        }

        public Builder<T> method(String method) {
            this.method = method;
            return this;
        }

        public Builder<T> authorization(Authorization authorization) {
            if (authorization != null) {
                this.appKey = authorization.getAppKey();
                this.appSecret = authorization.getAppSecret();
            }
            return this;
        }

        public Builder<T> accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public Builder<T> businessParam(T businessParam) {
            this.businessParam = businessParam;
            return this;
        }

        public DySignRequest<T> build() {
            return new DySignRequest<T>(appKey, appSecret, method, businessParam, accessToken);
        }

    }
}
