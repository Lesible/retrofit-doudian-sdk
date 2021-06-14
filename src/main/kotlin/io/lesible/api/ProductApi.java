package io.lesible.api;

import io.lesible.model.response.DyResult;
import io.lesible.model.response.product.ProductDetail;
import io.lesible.model.response.product.ProductPageInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * <p> @date: 2021-04-20 11:23</p>
 *
 * @author 何嘉豪
 */
public interface ProductApi {

    /**
     * 获取商品列表
     *
     * @param queryMap 查询参数列表
     * @return 商品列表结果
     */
    @GET("product/list")
    Call<DyResult<ProductPageInfo>> list(@QueryMap Map<String, String> queryMap);

    /**
     * 获取商品详情
     *
     * @param queryMap 查询参数列表
     * @return 商品详情结果
     */
    @GET("product/detail")
    Call<DyResult<ProductDetail>> detail(@QueryMap Map<String, String> queryMap);

}
