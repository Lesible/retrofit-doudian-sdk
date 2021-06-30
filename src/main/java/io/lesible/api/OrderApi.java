package io.lesible.api;

import io.lesible.model.response.DyResult;
import io.lesible.model.response.order.OrderPageInfo;
import io.lesible.model.response.order.ShopOrderDetailInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * <p> @date: 2021-04-22 15:49</p>
 *
 * @author 何嘉豪
 */
public interface OrderApi {

    /**
     * 获取满足条件的订单列表
     *
     * @param queryMap 查询参数列表
     * @return 订单列表结果
     */
    @GET("order/searchList")
    Call<DyResult<OrderPageInfo>> searchList(@QueryMap Map<String, String> queryMap);

    /**
     * 获取订单详情
     *
     * @param queryMap 查询参数列表
     * @return 订单详情结果
     */
    @GET("order/orderDetail")
    Call<DyResult<ShopOrderDetailInfo>> orderDetail(@QueryMap Map<String, String> queryMap);

}
