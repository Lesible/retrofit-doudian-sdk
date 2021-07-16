package io.lesible.api;

import io.lesible.model.response.DyResult;
import io.lesible.model.response.sku.SkuListInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * <p> @date: 2021-07-16 09:38</p>
 *
 * @author 何嘉豪
 */
public interface SkuApi {

    /**
     * 获取指定商品的 sku 列表
     *
     * @param queryMap 查询参数列表
     * @return sku 列表结果
     */
    @GET("sku/list")
    Call<DyResult<List<SkuListInfo>>> list(@QueryMap Map<String, String> queryMap);

    /**
     * 修改指定商品 sku 的价格
     *
     * @param queryMap 查询参数列表
     * @return 修改价格结果
     */
    @GET("sku/editPrice")
    Call<DyResult<Void>> editPrice(@QueryMap Map<String, String> queryMap);

    /**
     * 修改指定商品 sku 的库存
     *
     * @param queryMap 查询参数列表
     * @return 修改库存结果
     */
    @GET("sku/syncStock")
    Call<DyResult<Void>> syncStock(@QueryMap Map<String, String> queryMap);
}
