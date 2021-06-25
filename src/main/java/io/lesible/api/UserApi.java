package io.lesible.api;

import io.lesible.model.response.DyResult;
import io.lesible.model.response.user.DoudianOpenIdRet;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * <p> @date: 2021-06-15 18:03</p>
 * 用户 api
 *
 * @author 何嘉豪
 */
public interface UserApi {

    /**
     * 转换开放平台 openId 到抖店 openId
     *
     * @param queryMap 查询参数列表
     * @return 抖店 openId 结果
     */
    @GET("user/getDoudianOpenID")
    Call<DyResult<DoudianOpenIdRet>> getDoudianOpenID(@QueryMap Map<String, String> queryMap);

}
