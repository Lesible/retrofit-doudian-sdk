package io.lesible.api;

import io.lesible.model.response.DyResult;
import io.lesible.model.response.auth.AccessTokenInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * <p> @date: 2021-04-23 15:01</p>
 *
 * @author 何嘉豪
 */
public interface AuthApi {

    /**
     * 获取 accessToken
     *
     * @param queryMap 查询参数列表
     * @return 获取 token 参数
     */
    @GET("oauth2/access_token")
    Call<DyResult<AccessTokenInfo>> accessToken(@QueryMap Map<String, String> queryMap);

    /**
     * 刷新 accessToken
     *
     * @param queryMap 查询参数列表
     * @return 刷新 token 参数
     */
    @GET("oauth2/refresh_token")
    Call<DyResult<AccessTokenInfo>> refreshToken(@QueryMap Map<String, String> queryMap);

}
