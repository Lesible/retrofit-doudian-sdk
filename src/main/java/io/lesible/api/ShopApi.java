package io.lesible.api;

import io.lesible.model.response.DyResult;
import io.lesible.model.response.shop.BrandInfo;
import io.lesible.model.response.shop.CategoryInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * <p> @date: 2021-05-25 09:50</p>
 * 店铺 API
 *
 * @author 何嘉豪
 */
public interface ShopApi {

    /**
     * 获取店铺的已授权品牌列表
     *
     * @param queryMap 查询参数列表
     */
    @GET("shop/brandList")
    Call<DyResult<List<BrandInfo>>> brandList(@QueryMap Map<String, String> queryMap);


    /**
     * 获取店铺的已授权品牌列表
     *
     * @param queryMap 查询参数列表
     */
    @GET("shop/getShopCategory")
    Call<DyResult<List<CategoryInfo>>> getShopCategory(@QueryMap Map<String, String> queryMap);

}
