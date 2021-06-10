package io.lesible;

import io.lesible.api.*;
import io.lesible.model.Authorization;
import io.lesible.model.constant.MethodConstant;
import io.lesible.model.request.DySignRequest;
import io.lesible.model.request.comment.CommentListParam;
import io.lesible.model.request.comment.CommentReplyParam;
import io.lesible.model.request.marketing.MarketingGetShopCouponMetaListParam;
import io.lesible.model.request.order.OrderDetailParam;
import io.lesible.model.request.order.OrderListParam;
import io.lesible.model.request.order.OrderOrderDetailParam;
import io.lesible.model.request.order.OrderSearchListParam;
import io.lesible.model.request.product.ProductDetailParam;
import io.lesible.model.request.product.ProductListParam;
import io.lesible.model.request.shop.ShopBrandListParam;
import io.lesible.model.request.shop.ShopGetShopCategoryParam;
import io.lesible.model.response.DyResult;
import io.lesible.model.response.auth.AccessTokenInfo;
import io.lesible.model.response.comment.CommentPageInfo;
import io.lesible.model.response.marketing.ShopCouponMetaListInfo;
import io.lesible.model.response.order.OldOrderPageInfo;
import io.lesible.model.response.order.OldShopOrderDetailInfo;
import io.lesible.model.response.order.OrderPageInfo;
import io.lesible.model.response.order.ShopOrderDetailInfo;
import io.lesible.model.response.product.ProductDetail;
import io.lesible.model.response.product.ProductPageInfo;
import io.lesible.model.response.shop.BrandInfo;
import io.lesible.model.response.shop.CategoryInfo;
import io.lesible.util.JsonUtil;
import io.lesible.util.ParamUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p> @date: 2021-04-20 19:07</p>
 *
 * @author 何嘉豪
 */
@Slf4j
public class ApiTest {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final String ACCESS_TOKEN = "2f0136ed-67ea-4d53-857b-7dd6e739f3ce";
    //    private static final String ACCESS_TOKEN = "2b3f08cc-6d8f-451b-9142-8f46b17d5151";
    private static OrderApi ORDER_API;
    private static ProductApi PRODUCT_API;
    private static CommentApi COMMENT_API;
    private static AuthApi AUTH_API;
    private static ShopApi SHOP_API;
    private static MarketingApi MARKETING_API;

    @BeforeAll
    public static void initApiFactory() {
        Authorization authorization = new Authorization("6873668517658347022", "601f6adf-f7df-42bf-8789-1b3a90979c50");
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(50, 30, TimeUnit.SECONDS))
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://openapi-fxg.jinritemai.com/")
                .addConverterFactory(JacksonConverterFactory.create(ApiFactory.OBJECT_MAPPER))
                .client(client).build();
        ApiFactory API_FACTORY = new ApiFactory(retrofit, authorization);
        ORDER_API = API_FACTORY.generateApi(OrderApi.class);
        PRODUCT_API = API_FACTORY.generateApi(ProductApi.class);
        COMMENT_API = API_FACTORY.generateApi(CommentApi.class);
        AUTH_API = API_FACTORY.generateApi(AuthApi.class);
        SHOP_API = API_FACTORY.generateApi(ShopApi.class);
        MARKETING_API = API_FACTORY.generateApi(MarketingApi.class);
    }

    @Test
    public void paramTest() {
        DySignRequest<ProductListParam> request = new DySignRequest<>();
        request.setAccessToken("085fc798-578b-4df4-adfd-ef45bdad772a");
        ProductListParam param = new ProductListParam();
        param.setPage("0");
        param.setSize("5");
        request.setBusinessParam(param);
        request.setMethod("product.list");
        request.setAppKey("6873668517658347022");
        request.setAppSecret("601f6adf-f7df-42bf-8789-1b3a90979c50");
        Map<String, String> stringStringMap = ParamUtil.buildParamMap(request);
        log.info("stringStringMap: {}", stringStringMap);
    }

    /**
     * 获取授权
     */
    @Test
    @SneakyThrows
    public void oauth2AccessToken() {
        Map<String, String> paramMap = ParamUtil.buildGetAccessTokenMap("c5c4a4ad-34c6-4667-bd7c-0d17df13fea5");
        Call<DyResult<AccessTokenInfo>> call = AUTH_API.accessToken(paramMap);
        DyResult<AccessTokenInfo> body = call.execute().body();
        log.info("body: {}", body);
    }

    /**
     * 刷新 token
     */
    @Test
    @SneakyThrows
    public void oauth2RefreshToken() {
        Map<String, String> paramMap = ParamUtil.buildRefreshTokenMap("02129cad-7b6d-4652-ac86-36ae677a5473");
        Call<DyResult<AccessTokenInfo>> call = AUTH_API.refreshToken(paramMap);
        DyResult<AccessTokenInfo> body = call.execute().body();
        log.info("body: {}", body);
    }

    /**
     * 商品列表查询
     */
    @Test
    @SneakyThrows
    public void productList() {
        ProductListParam productListParam = new ProductListParam();
        productListParam.setPage("0");
        productListParam.setSize("5");
        DySignRequest<ProductListParam> request = DySignRequest.<ProductListParam>builder()
                .accessToken(ACCESS_TOKEN)
                .businessParam(productListParam).method(MethodConstant.PRODUCT_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ProductPageInfo>> dyResultCall = PRODUCT_API.list(paramMap);
        DyResult<ProductPageInfo> body = dyResultCall.execute().body();
        assert body != null;
        log.info("body: {}", body);
    }

    /**
     * 商品详情查询
     */
    @Test
    @SneakyThrows
    public void productDetail() {
        ProductDetailParam productDetailParam = new ProductDetailParam();
        productDetailParam.setProductId("3485798704252859582");
        DySignRequest<ProductDetailParam> request = DySignRequest.<ProductDetailParam>builder()
                .accessToken(ACCESS_TOKEN).businessParam(productDetailParam)
                .method(MethodConstant.PRODUCT_DETAIL).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ProductDetail>> dyResultCall = PRODUCT_API.detail(paramMap);
        DyResult<ProductDetail> body = dyResultCall.execute().body();
        log.info("body: {}", body);
    }

    /**
     * 订单列表查询
     */
    @Test
    @SneakyThrows
    public void orderSearchList() {
        ZoneOffset defaultZoneOffset = ZoneOffset.of("+8");
        LocalDateTime yesterday = LocalDateTime.now().minusDays(2L);
        LocalDateTime localDateTime = LocalDateTime.now();
        long end = localDateTime.toEpochSecond(defaultZoneOffset);
        long begin = yesterday.toEpochSecond(defaultZoneOffset);
        OrderSearchListParam param = OrderSearchListParam.builder()
                .page(0).size(100)
                .createTimeStart(begin)
                .createTimeEnd(end)
                .build();
        DySignRequest<OrderSearchListParam> request = DySignRequest.<OrderSearchListParam>builder()
                .accessToken(ACCESS_TOKEN)
                .businessParam(param).method(MethodConstant.ORDER_SEARCH_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<OrderPageInfo>> dyResultCall = ORDER_API.searchList(paramMap);
        DyResult<OrderPageInfo> body = dyResultCall.execute().body();
        log.info("body: {}", body);
    }

    /**
     * 订单详情查询
     */
    @Test
    @SneakyThrows
    public void orderOrderDetail() {
        OrderOrderDetailParam param = OrderOrderDetailParam.builder().shopOrderId("4806897676511976972").build();
        DySignRequest<OrderOrderDetailParam> request = DySignRequest.<OrderOrderDetailParam>builder()
                .accessToken(ACCESS_TOKEN)
                .businessParam(param).method(MethodConstant.ORDER_ORDER_DETAIL).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ShopOrderDetailInfo>> dyResultCall = ORDER_API.orderDetail(paramMap);
        DyResult<ShopOrderDetailInfo> orderDetailInfo = dyResultCall.execute().body();
        log.info("orderDetailInfo: {}", orderDetailInfo);
    }

    /**
     * 订单列表查询 即将废弃
     */
    @Test
    @SneakyThrows
    public void orderList() {
        LocalDateTime start = LocalDateTime.of(2021, 5, 7, 12, 0);
//        LocalDateTime start = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        String startTime = DATE_TIME_FORMATTER.format(start);
        String endTime = DATE_TIME_FORMATTER.format(start.plusDays(1L));
        log.info("endTime: {}", endTime);
        log.info("startTime: {}", startTime);
        OrderListParam param = OrderListParam.builder()
                .page(0).size(1).orderBy("update_time")
                .startTime(startTime).endTime(endTime).isDesc(1)
                .build();
        DySignRequest<OrderListParam> request = DySignRequest.<OrderListParam>builder()
                .accessToken(ACCESS_TOKEN)
                .businessParam(param).method(MethodConstant.ORDER_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<OldOrderPageInfo>> dyResultCall = ORDER_API.list(paramMap);
        DyResult<OldOrderPageInfo> orderListResult = dyResultCall.execute().body();
        log.info("orderListResult: {}", orderListResult);
    }

    /**
     * 订单详情查询 即将废弃
     */
    @Test
    @SneakyThrows
    public void orderDetail() {
        String orderIds = "4806897676511976972A";
        for (String s : orderIds.split(",")) {
            OrderDetailParam param = OrderDetailParam.builder().orderId(s).build();
            DySignRequest<OrderDetailParam> request = DySignRequest.<OrderDetailParam>builder()
                    .accessToken(ACCESS_TOKEN)
                    .businessParam(param).method(MethodConstant.ORDER_DETAIL).build();
            Map<String, String> paramMap = ParamUtil.buildParamMap(request);
            Call<DyResult<OldShopOrderDetailInfo>> dyResultCall = ORDER_API.detail(paramMap);
            DyResult<OldShopOrderDetailInfo> oldShopOrderDetail = dyResultCall.execute().body();
            log.info("oldShopOrderDetail: {}", oldShopOrderDetail);
            log.info("oldShopOrderDetail: {}", JsonUtil.jsonValue(oldShopOrderDetail));
        }
    }

    /**
     * 评价列表查询
     */
    @Test
    @SneakyThrows
    public void commentList() {
        CommentListParam param = CommentListParam.builder()
                .orderBy("update_time").isDesc("-1").build();
        DySignRequest<CommentListParam> request = DySignRequest.<CommentListParam>builder()
                .accessToken(ACCESS_TOKEN)
                .businessParam(param).method(MethodConstant.COMMENT_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<CommentPageInfo>> dyResultCall = COMMENT_API.list(paramMap);
        DyResult<CommentPageInfo> commentPageInfo = dyResultCall.execute().body();
        log.info("commentPageInfo: {}", JsonUtil.jsonValue(commentPageInfo));
    }

    /**
     * 回复评价
     */
    @Test
    @SneakyThrows
    public void commentReply() {
        CommentReplyParam param = CommentReplyParam.builder().commentId("137844687636578599")
                .content("谢谢您的光临,能让您满意真是太好了").build();
        DySignRequest<CommentReplyParam> request = DySignRequest.<CommentReplyParam>builder()
                .accessToken(ACCESS_TOKEN)
                .businessParam(param).method(MethodConstant.COMMENT_REPLY).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<Void>> dyResultCall = COMMENT_API.reply(paramMap);
        DyResult<Void> commentReplay = dyResultCall.execute().body();
        log.info("commentReplay: {}", commentReplay);
    }

    /**
     * 品牌列表查询
     */
    @Test
    @SneakyThrows
    public void brandList() {
        //f6ca36f3-6c17-450b-9254-93467a1d9f88
        ShopBrandListParam param = ShopBrandListParam.builder().build();
        DySignRequest<ShopBrandListParam> request = DySignRequest.<ShopBrandListParam>builder()
                .accessToken(ACCESS_TOKEN)
                .businessParam(param).method(MethodConstant.SHOP_BRAND_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<List<BrandInfo>>> dyResultCall = SHOP_API.brandList(paramMap);
        DyResult<List<BrandInfo>> result = dyResultCall.execute().body();
        log.info("result: {}", result);
    }

    /**
     * 商品类目列表查询
     */
    @Test
    @SneakyThrows
    public void getShopCategory() {
        //f6ca36f3-6c17-450b-9254-93467a1d9f88
        ShopGetShopCategoryParam param = ShopGetShopCategoryParam.builder().cid(0L).build();
        DySignRequest<ShopGetShopCategoryParam> request = DySignRequest.<ShopGetShopCategoryParam>builder()
                .accessToken(ACCESS_TOKEN)
                .businessParam(param).method(MethodConstant.SHOP_GET_SHOP_CATEGORY).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<List<CategoryInfo>>> shopCategory = SHOP_API.getShopCategory(paramMap);
        DyResult<List<CategoryInfo>> result = shopCategory.execute().body();
        log.info("result: {}", result);
    }

    /**
     * 优惠券列表查询
     */
    @Test
    @SneakyThrows
    public void getShopCouponMetaList() {
        MarketingGetShopCouponMetaListParam param = MarketingGetShopCouponMetaListParam.builder()
                .couponMetaId(3428704890636122168L).offset(0).limit(5).startApplyTime("2021-08-06 00:00")
                .limit(5).isShow(1).build();
        DySignRequest<MarketingGetShopCouponMetaListParam> request = DySignRequest.<MarketingGetShopCouponMetaListParam>builder()
                .accessToken(ACCESS_TOKEN)
                .businessParam(param).method(MethodConstant.MARKETING_GET_SHOP_COUPON_META_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ShopCouponMetaListInfo>> body = MARKETING_API.getShopCouponMetaList(paramMap);
        DyResult<ShopCouponMetaListInfo> result = body.execute().body();
        log.info("result: {}", result);
    }


}
