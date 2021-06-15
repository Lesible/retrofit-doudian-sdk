package io.lesible.api;

import io.lesible.model.response.DyResult;
import io.lesible.model.response.billing.AllianceRet;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * <p> @date: 2021-06-15 11:41</p>
 * <p>
 * 账单 api
 *
 * @author 何嘉豪
 */
public interface BillingApi {

    /**
     * 查询联盟订单明细
     *
     * @param queryMap 查询参数列表
     * @return 联盟订单详情
     */
    @GET("alliance/getOrderList")
    Call<DyResult<AllianceRet>> list(@QueryMap Map<String, String> queryMap);

}
