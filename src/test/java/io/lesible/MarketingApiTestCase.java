package io.lesible;

import io.lesible.api.MarketingApi;
import io.lesible.model.constant.MethodConstant;
import io.lesible.model.enumeration.*;
import io.lesible.model.request.DySignRequest;
import io.lesible.model.request.marketing.*;
import io.lesible.model.response.DyResult;
import io.lesible.model.response.marketing.*;
import io.lesible.util.ParamUtil;
import io.lesible.util.UniqueIdUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import retrofit2.Call;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p> @date: 2021-06-11 15:18</p>
 *
 * @author 何嘉豪
 */
@Slf4j
public class MarketingApiTestCase {

    private final MarketingApi marketingApi = ApiFactoryInitializer.MARKETING_API;

    /**
     * 优惠券创建
     */
    @Test
    @SneakyThrows
    public void createCoupon() {
        // 6972135647914066184
        // 6972136631113482532
        LocalDateTime ldt = LocalDateTime.of(2021, 6, 10, 0, 0);
        MarketingCreateCouponParam param = MarketingCreateCouponParam.builder()
                .couponName("抖店 api 测试 3 号").couponType(CouponType.SHOP_DIRECT_DISCOUNT_COUPON)
                .periodType(CouponPeriodType.FLOAT_PERIOD).validPeriod(5).typeDetail("2319538")
                .startApplyTime(ldt).endApplyTime(ldt.plusDays(14L)).startTime(ldt)
                .expireTime(ldt.plusDays(14L)).totalAmount(5).url("").opName("暖糖糖的吃货铺")
                .discount(100).maxDiscountLimit(0L).threshold(0L).credit(200L).maxApplyTimes(1)
                .couponApplyScene(CouponApplyScene.MIXED).promoteType(PromoteType.SELF_CHANNEL_PROMOTE).build();
        DySignRequest<MarketingCreateCouponParam> request = DySignRequest.<MarketingCreateCouponParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstant.MARKETING_CREATE_COUPON).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<CreatedCouponRes>> body = marketingApi.createCoupon(paramMap);
        DyResult<CreatedCouponRes> result = body.execute().body();
        log.info("result: {}", result);
    }

    /**
     * 优惠券列表查询
     */
    @Test
    @SneakyThrows
    public void getShopCouponMetaList() {
        // 店铺 url https://haohuo.jinritemai.com/views/shop/index?id=tMOiCrl
        MarketingGetShopCouponMetaListParam param = MarketingGetShopCouponMetaListParam.builder()
                .couponMetaId(3428704890636122168L).offset(0).limit(5).startApplyTime("2021-08-06 00:00")
                .limit(5).isShow(1).build();
        DySignRequest<MarketingGetShopCouponMetaListParam> request = DySignRequest
                .<MarketingGetShopCouponMetaListParam>builder().accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstant.MARKETING_GET_SHOP_COUPON_META_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ShopCouponMetaListRes>> body = marketingApi.getShopCouponMetaList(paramMap);
        DyResult<ShopCouponMetaListRes> result = body.execute().body();
        log.info("result: {}", result);
    }

    /**
     * 优惠券详情查询
     */
    @Test
    @SneakyThrows
    public void getCouponDetail() {
        MarketingGetCouponDetailParam param = MarketingGetCouponDetailParam.builder()
                .couponMetaId(6972135647914066184L).build();
        DySignRequest<MarketingGetCouponDetailParam> request = DySignRequest
                .<MarketingGetCouponDetailParam>builder().accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstant.MARKETING_GET_COUPON_DETAIL).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<CouponMetaDetailRes>> body = marketingApi.getCouponDetail(paramMap);
        DyResult<CouponMetaDetailRes> result = body.execute().body();
        log.info("result: {}", result);
    }

    /**
     * 优惠券启用/废弃
     */
    @Test
    @SneakyThrows
    public void ableCouponMeta() {
        MarketingAbleCouponMetaParam param = MarketingAbleCouponMetaParam.builder()
                .couponMetaId(6972135647914066184L).couponStatus(CouponStatus.ACTIVATED)
                .opName("什么?").build();
        DySignRequest<MarketingAbleCouponMetaParam> request = DySignRequest
                .<MarketingAbleCouponMetaParam>builder().accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstant.MARKETING_ABLE_COUPON_META).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<AbleCouponMetaRes>> body = marketingApi.ableCouponMeta(paramMap);
        DyResult<AbleCouponMetaRes> result = body.execute().body();
        log.info("result: {}", result);
    }

    @Test
    @SneakyThrows
    public void adjustShopCouponMeta() {
        MarketingAdjustShopCouponMetaParam param = MarketingAdjustShopCouponMetaParam.builder()
                .couponMetaId(6972135647914066184L).currentTotalAmount(6L).build();
        DySignRequest<MarketingAdjustShopCouponMetaParam> request = DySignRequest.<MarketingAdjustShopCouponMetaParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstant.MARKETING_ADJUST_SHOP_COUPON4_META).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<Void>> dyResultCall = marketingApi.adjustShopCouponMeta(paramMap);
        DyResult<Void> result = dyResultCall.execute().body();
        log.info("result: {}", result);
    }

    /**
     * 优惠券发放
     */
    @Test
    @SneakyThrows
    public void applyCoupon() {
        // 华胜的 doudian_open_id  1@#QlEMZy4wLjtuPBNlQSl3ZFTc4uBAfgexNFmQfxskmdrNHd+WQzmN5vF8g6VukV4uJQ==
        MarketingApplyCouponParam param = MarketingApplyCouponParam.builder()
                .couponMetaId(6972135647914066184L).doudianOpenId("1@#Gk8XL628jfo/PwLUW2v7LHCzJzdAetQ4yx3cN7WYQ/PUHvSf7jueOLKOR+kumBOk4jmfqp/l")
                .uniqueId(UniqueIdUtil.nextUniqueId()).build();
        DySignRequest<MarketingApplyCouponParam> request = DySignRequest
                .<MarketingApplyCouponParam>builder().accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstant.MARKETING_APPLY_COUPON).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ApplyCouponRes>> body = marketingApi.applyCoupon(paramMap);
        DyResult<ApplyCouponRes> result = body.execute().body();
        log.info("result: {}", result);
    }

}
