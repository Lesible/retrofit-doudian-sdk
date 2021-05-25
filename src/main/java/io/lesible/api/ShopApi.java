package io.lesible.api;

import io.lesible.model.response.DyResult;
import io.lesible.model.response.shop.BrandInfo;
import io.lesible.model.response.shop.CategoryInfo;
import retrofit2.Call;
import retrofit2.http.POST;
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
     */
    @POST("shop/brandList")
    Call<DyResult<List<BrandInfo>>> brandList(@QueryMap Map<String, String> queryMap);


    /**
     * 获取店铺的已授权品牌列表
     */
    @POST("shop/getShopCategory")
    Call<DyResult<List<CategoryInfo>>> getShopCategory(@QueryMap Map<String, String> queryMap);

}
