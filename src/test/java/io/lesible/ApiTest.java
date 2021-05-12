package io.lesible;

import com.alibaba.fastjson.JSON;
import io.lesible.api.AuthApi;
import io.lesible.api.CommentApi;
import io.lesible.api.OrderApi;
import io.lesible.api.ProductApi;
import io.lesible.config.ApiFactoryConfig;
import io.lesible.model.constant.MethodConstant;
import io.lesible.model.request.DySignRequest;
import io.lesible.model.request.comment.CommentListParam;
import io.lesible.model.request.comment.CommentReplyParam;
import io.lesible.model.request.order.OrderDetailParam;
import io.lesible.model.request.order.OrderListParam;
import io.lesible.model.request.order.OrderOrderDetailParam;
import io.lesible.model.request.order.OrderSearchListParam;
import io.lesible.model.request.product.ProductDetailParam;
import io.lesible.model.request.product.ProductListParam;
import io.lesible.model.response.DyResult;
import io.lesible.model.response.auth.AccessTokenInfo;
import io.lesible.model.response.comment.CommentPageInfo;
import io.lesible.model.response.order.*;
import io.lesible.model.response.product.ProductDetail;
import io.lesible.model.response.product.ProductInfo;
import io.lesible.model.response.product.ProductPageInfo;
import io.lesible.util.ParamUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Call;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p> @date: 2021-04-20 19:07</p>
 *
 * @author 何嘉豪
 */
@Slf4j
public class ApiTest {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static OrderApi ORDER_API;
    private static ProductApi PRODUCT_API;
    private static CommentApi COMMENT_API;
    private static AuthApi AUTH_API;

    @BeforeAll
    public static void initApiFactory() {
        ApiFactoryConfig apiFactoryConfig = new ApiFactoryConfig();
        apiFactoryConfig.setBaseUrl("https://openapi-fxg.jinritemai.com/");
        apiFactoryConfig.setDefaultKey("6873668517658347022");
        apiFactoryConfig.setDefaultSecret("601f6adf-f7df-42bf-8789-1b3a90979c50");
        ApiFactory API_FACTORY = new ApiFactory(apiFactoryConfig);
        ORDER_API = API_FACTORY.generateApi(OrderApi.class);
        PRODUCT_API = API_FACTORY.generateApi(ProductApi.class);
        COMMENT_API = API_FACTORY.generateApi(CommentApi.class);
        AUTH_API = API_FACTORY.generateApi(AuthApi.class);
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

    @Test
    public void oauth2AccessToken() throws IOException {
        Map<String, String> paramMap = ParamUtil.buildGetAccessTokenMap("c5c4a4ad-34c6-4667-bd7c-0d17df13fea5");
        Call<DyResult<AccessTokenInfo>> call = AUTH_API.accessToken(paramMap);
        DyResult<AccessTokenInfo> body = call.execute().body();
        log.info("body: {}", body);
    }

    @Test
    public void oauth2RefreshToken() throws IOException {
        Map<String, String> paramMap = ParamUtil.buildRefreshTokenMap("02129cad-7b6d-4652-ac86-36ae677a5473");
        Call<DyResult<AccessTokenInfo>> call = AUTH_API.refreshToken(paramMap);
        DyResult<AccessTokenInfo> body = call.execute().body();
        log.info("body: {}", body);
    }

    @Test
    public void productList() throws IOException {
        ProductListParam productListParam = new ProductListParam();
        productListParam.setPage("0");
        productListParam.setSize("5");
        DySignRequest<ProductListParam> request = DySignRequest.<ProductListParam>builder()
                .accessToken("085fc798-578b-4df4-adfd-ef45bdad772a")
                .businessParam(productListParam).method(MethodConstant.PRODUCT_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ProductPageInfo>> dyResultCall = PRODUCT_API.list(paramMap);
        DyResult<ProductPageInfo> body = dyResultCall.execute().body();
        assert body != null;
        String collect = body.getData().getData().stream().map(ProductInfo::getProductId)
                .map(String::valueOf).collect(Collectors.joining(","));
        log.info("collect: {}", collect);
    }

    @Test
    public void productDetail() throws IOException {
        ProductDetailParam productDetailParam = new ProductDetailParam();
        productDetailParam.setProductId("3476346241309393327");
        DySignRequest<ProductDetailParam> request = DySignRequest.<ProductDetailParam>builder()
                .accessToken("085fc798-578b-4df4-adfd-ef45bdad772a")
                .businessParam(productDetailParam).method(MethodConstant.PRODUCT_DETAIL).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ProductDetail>> dyResultCall = PRODUCT_API.detail(paramMap);
        DyResult<ProductDetail> body = dyResultCall.execute().body();
        log.info("body: {}", body);
    }

    @Test
    public void orderSearchList() throws IOException {
        OrderSearchListParam param = OrderSearchListParam.builder()
                .page(0).size(2)
                .createTimeEnd(1619319026L - 30 * 24 * 60 * 60L)
                .build();
        DySignRequest<OrderSearchListParam> request = DySignRequest.<OrderSearchListParam>builder()
                .accessToken("24f8e942-3423-417d-8a8c-f24fa27f84e5")
                .businessParam(param).method(MethodConstant.ORDER_SEARCH_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<OrderPageInfo>> dyResultCall = ORDER_API.searchList(paramMap);
        DyResult<OrderPageInfo> body = dyResultCall.execute().body();
        log.info("body: {}", body);
    }

    @Test
    public void orderOrderDetail() throws IOException {
        OrderOrderDetailParam param = OrderOrderDetailParam.builder().shopOrderId("4793994778726551289").build();
        DySignRequest<OrderOrderDetailParam> request = DySignRequest.<OrderOrderDetailParam>builder()
                .accessToken("24f8e942-3423-417d-8a8c-f24fa27f84e5")
                .businessParam(param).method(MethodConstant.ORDER_ORDER_DETAIL).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ShopOrderDetailInfo>> dyResultCall = ORDER_API.orderDetail(paramMap);
        DyResult<ShopOrderDetailInfo> orderDetailInfo = dyResultCall.execute().body();
        log.info("orderDetailInfo: {}", orderDetailInfo);
        String json = JSON.toJSONString(orderDetailInfo);
        log.info("json: {}", json);
    }

    @Test
    public void orderList() throws IOException {
        long second = 1620360200L;
        Instant instant = Instant.ofEpochSecond(second);
//        LocalDateTime start = LocalDateTime.of(2021, 5, 7, 12, 0);
        LocalDateTime start = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        String startTime = DATE_TIME_FORMATTER.format(start);
        String endTime = DATE_TIME_FORMATTER.format(start.plusMinutes(1L));
        log.info("endTime: {}", endTime);
        log.info("startTime: {}", startTime);
        OrderListParam param = OrderListParam.builder()
                .page(0).size(100).orderBy("update_time")
                .startTime(startTime).endTime(endTime).isDesc(1)
                .build();
        DySignRequest<OrderListParam> request = DySignRequest.<OrderListParam>builder()
                .accessToken("24f8e942-3423-417d-8a8c-f24fa27f84e5")
                .businessParam(param).method(MethodConstant.ORDER_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<OldOrderPageInfo>> dyResultCall = ORDER_API.list(paramMap);
        DyResult<OldOrderPageInfo> orderListResult = dyResultCall.execute().body();
        OldShopOrderInfo info = orderListResult.getData().getList()
                .stream().filter(o -> o.getPostReceiver().equals("王琦")).findFirst().get();
    }

    @Test
    public void orderDetail() throws IOException {
        String orderIds = "4793975713351181651A";
        for (String s : orderIds.split(",")) {
            OrderDetailParam param = OrderDetailParam.builder().orderId(s).build();
            DySignRequest<OrderDetailParam> request = DySignRequest.<OrderDetailParam>builder()
                    .accessToken("24f8e942-3423-417d-8a8c-f24fa27f84e5")
                    .businessParam(param).method(MethodConstant.ORDER_DETAIL).build();
            Map<String, String> paramMap = ParamUtil.buildParamMap(request);
            Call<DyResult<OldShopOrderDetailInfo>> dyResultCall = ORDER_API.detail(paramMap);
            DyResult<OldShopOrderDetailInfo> oldShopOrderDetail = dyResultCall.execute().body();
            log.info("oldShopOrderDetail: {}", JSON.toJSONString(oldShopOrderDetail));
        }
    }

    @Test
    public void commentList() throws IOException {
        CommentListParam param = CommentListParam.builder()
                .orderBy("update_time").isDesc("-1").build();
        DySignRequest<CommentListParam> request = DySignRequest.<CommentListParam>builder()
                .accessToken("fcc5856d-9e8e-44c5-bb55-5e3d91bd5b30")
                .businessParam(param).method(MethodConstant.COMMENT_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<CommentPageInfo>> dyResultCall = COMMENT_API.list(paramMap);
        DyResult<CommentPageInfo> commentPageInfo = dyResultCall.execute().body();
        log.info("commentPageInfo: {}", JSON.toJSONString(commentPageInfo));
    }

    @Test
    public void commentReply() throws IOException {
        CommentReplyParam param = CommentReplyParam.builder().commentId("137844687636578599")
                .content("谢谢您的光临,能让您满意真是太好了").build();
        DySignRequest<CommentReplyParam> request = DySignRequest.<CommentReplyParam>builder()
                .accessToken("3f828c6b-3329-4d48-b584-1f1826ae72ec")
                .businessParam(param).method(MethodConstant.COMMENT_REPLY).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<Void>> dyResultCall = COMMENT_API.reply(paramMap);
        DyResult<Void> commentReplay = dyResultCall.execute().body();
        log.info("commentReplay: {}", commentReplay);
    }

}
