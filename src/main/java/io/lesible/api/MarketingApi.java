package io.lesible.api;

import io.lesible.model.response.DyResult;
import io.lesible.model.response.marketing.ShopCouponMetaListInfo;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * <p> @date: 2021-06-03 11:54</p>
 * 营销接口
 *
 * @author 何嘉豪
 */
public interface MarketingApi {

    /**
     * 创建优惠券
     *
     * @param queryMap 查询参数列表
     * @return 创建成功的优惠券 id
     */
    @POST("marketing/createCoupon")
    Call<String> createCoupon(@QueryMap Map<String, String> queryMap);

    /**
     * 查询已存在的优惠券列表
     *
     * @param queryMap 查询参数列表
     * @return 查询到的优惠券的信息
     */
    @POST("marketing/GetShopCouponMetaList")
    Call<DyResult<ShopCouponMetaListInfo>> getShopCouponMetaList(@QueryMap Map<String, String> queryMap);

}
