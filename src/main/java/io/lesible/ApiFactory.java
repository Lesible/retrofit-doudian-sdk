package io.lesible;

import io.lesible.config.ApiFactoryConfig;
import io.lesible.converter.FastJsonConverterFactory;
import io.lesible.model.Authorization;
import io.lesible.model.request.DySignRequest;
import retrofit2.Retrofit;

/**
 * <p> @date: 2021-04-19 16:07</p>
 *
 * @author 何嘉豪
 */
public class ApiFactory {

    private final Retrofit retrofit;

    public ApiFactory(ApiFactoryConfig apiFactoryConfig) {
        DySignRequest.DEFAULT_AUTHORIZATION = new Authorization(apiFactoryConfig
                .getDefaultKey(), apiFactoryConfig.getDefaultSecret());
        this.retrofit = new Retrofit.Builder().addConverterFactory(FastJsonConverterFactory.create())
                .baseUrl(apiFactoryConfig.getBaseUrl()).build();
    }

    /**
     * 自定义 retrofit 客户端需要添加 FastJsonConverterFactory
     *
     * @param retrofit retrofit 客户端设置
     */
    public ApiFactory(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public ApiFactory(Retrofit retrofit, Authorization defaultAuthorization) {
        DySignRequest.DEFAULT_AUTHORIZATION = defaultAuthorization;
        this.retrofit = retrofit;
    }

    public <T> T generateApi(Class<T> apiClass) {
        return retrofit.create(apiClass);
    }
}
