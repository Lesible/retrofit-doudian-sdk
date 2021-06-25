package io.lesible.api;

import io.lesible.model.response.DyResult;
import io.lesible.model.response.marketing.*;
import retrofit2.Call;
import retrofit2.http.GET;
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
    @GET("marketing/createCoupon")
    Call<DyResult<CreatedCouponRes>> createCoupon(@QueryMap Map<String, String> queryMap);

    /**
     * 查询已存在的优惠券列表
     *
     * @param queryMap 查询参数列表
     * @return 查询到的优惠券的信息
     */
    @GET("marketing/GetShopCouponMetaList")
    Call<DyResult<ShopCouponMetaListRes>> getShopCouponMetaList(@QueryMap Map<String, String> queryMap);

    /**
     * 查询指定优惠券详情信息
     *
     * @param queryMap 查询参数列表
     * @return 优惠券详情信息
     */
    @GET("marketing/GetCouponDetail")
    Call<DyResult<CouponMetaDetailRes>> getCouponDetail(@QueryMap Map<String, String> queryMap);

    /**
     * 优惠券启用/作废
     *
     * @param queryMap 查询参数列表
     * @return 是否操作成功
     */
    @GET("marketing/AbleCouponMeta")
    Call<DyResult<AbleCouponMetaRes>> ableCouponMeta(@QueryMap Map<String, String> queryMap);

    /**
     * 修改优惠券库存
     *
     * @param queryMap 查询参数列表
     * @return 除了状态没有别的
     */
    @GET("marketing/AdjustShopCouponMeta")
    Call<DyResult<Void>> adjustShopCouponMeta(@QueryMap Map<String, String> queryMap);

    /**
     * 发放优惠券
     *
     * @param queryMap 查询参数列表
     * @return 用户优惠券实例 id
     */
    @GET("marketing/ApplyCoupon")
    Call<DyResult<ApplyCouponRes>> applyCoupon(@QueryMap Map<String, String> queryMap);

}
