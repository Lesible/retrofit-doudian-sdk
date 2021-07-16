package io.lesible;

import io.lesible.api.OrderApi;
import io.lesible.model.constant.MethodConstant;
import io.lesible.model.request.DySignRequest;
import io.lesible.model.request.order.CipherInfo;
import io.lesible.model.request.order.OrderBatchDecryptParam;
import io.lesible.model.request.order.OrderOrderDetailParam;
import io.lesible.model.request.order.OrderSearchListParam;
import io.lesible.model.response.DyResult;
import io.lesible.model.response.order.OrderPageInfo;
import io.lesible.model.response.order.ShopOrderDetail;
import io.lesible.model.response.order.ShopOrderDetailInfo;
import io.lesible.util.JsonUtil;
import io.lesible.util.ParamUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import retrofit2.Call;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p> @date: 2021-06-11 15:13</p>
 *
 * @author 何嘉豪
 */
@Slf4j
public class OrderApiTestCase {

    private final OrderApi orderApi = ApiFactoryInitializer.ORDER_API;

    /**
     * 订单列表查询
     */
    @Test
    @SneakyThrows
    public void orderSearchList() {
        ZoneOffset defaultZoneOffset = ZoneOffset.of("+8");
        LocalDateTime oldTime = LocalDateTime.of(2019, 7, 1, 0, 0);
        LocalDateTime newTime = LocalDateTime.of(2021, 4, 1, 0, 0);
        LocalDateTime yesterday = LocalDateTime.now().minusDays(10L);
        LocalDateTime localDateTime = LocalDateTime.now();
        long begin = oldTime.toEpochSecond(defaultZoneOffset);
        log.info("begin: {}", begin);
        long end = newTime.toEpochSecond(defaultZoneOffset);
        log.info("end: {}", end);
        OrderSearchListParam param = OrderSearchListParam.builder()
                .updateTimeStart(begin)
                .updateTimeEnd(end)
                .page(0).size(100)
                .orderBy("update_time")
                .orderAsc(true)
                .build();
        DySignRequest<OrderSearchListParam> request = DySignRequest.<OrderSearchListParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstant.ORDER_SEARCH_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<OrderPageInfo>> dyResultCall = orderApi.searchList(paramMap);
        DyResult<OrderPageInfo> body = dyResultCall.execute().body();
        log.info("body: {}", body);
    }

    /**
     * 订单详情查询
     */
    @Test
    @SneakyThrows
    public void orderOrderDetail() {
        OrderOrderDetailParam param = OrderOrderDetailParam.builder().shopOrderId(4650086736908665410L).build();
        DySignRequest<OrderOrderDetailParam> request = DySignRequest.<OrderOrderDetailParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstant.ORDER_ORDER_DETAIL).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ShopOrderDetailInfo>> dyResultCall = orderApi.orderDetail(paramMap);
        DyResult<ShopOrderDetailInfo> orderDetailInfo = dyResultCall.execute().body();
        log.info("orderDetailInfo: {}", JsonUtil.jsonValue(orderDetailInfo));
    }

    /**
     * 订单解密
     */
    @Test
    @SneakyThrows
    public void orderBatchDecrypt() {
        OrderOrderDetailParam param = OrderOrderDetailParam.builder().shopOrderId(4810079117705565473L).build();
        DySignRequest<OrderOrderDetailParam> request = DySignRequest.<OrderOrderDetailParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstant.ORDER_ORDER_DETAIL).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ShopOrderDetailInfo>> dyResultCall = orderApi.orderDetail(paramMap);
        DyResult<ShopOrderDetailInfo> orderDetailInfo = dyResultCall.execute().body();
        if (orderDetailInfo != null && orderDetailInfo.isSuccess()) {
            ShopOrderDetail shopOrderDetail = orderDetailInfo.getData().getShopOrderDetail();
            String encryptPostReceiver = shopOrderDetail.getEncryptPostReceiver();
            String encryptPostTel = shopOrderDetail.getEncryptPostTel();
            Long orderId = shopOrderDetail.getOrderId();
            List<CipherInfo> cipherInfos = Arrays.asList(
                    CipherInfo.builder().authId(orderId).cipherText(encryptPostReceiver).build(),
                    CipherInfo.builder().authId(orderId).cipherText(encryptPostTel).build());
            OrderBatchDecryptParam innerParam = OrderBatchDecryptParam.builder().cipherInfos(cipherInfos).build();
            DySignRequest<OrderBatchDecryptParam> innerRequest = DySignRequest.<OrderBatchDecryptParam>builder()
                    .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                    .businessParam(innerParam).method(MethodConstant.ORDER_BATCH_DECRYPT).build();
            Map<String, String> innerParamMap = ParamUtil.buildParamMap(innerRequest);
            Call<String> result = orderApi.batchDecrypt(innerParamMap);
            String body = result.execute().body();
            log.info("body: {}", body);
        }
    }

}
