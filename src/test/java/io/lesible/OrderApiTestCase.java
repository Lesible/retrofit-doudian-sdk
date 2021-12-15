package io.lesible;

import com.sumwhy.util.JsonUtil;
import io.lesible.api.OrderApi;
import io.lesible.common.constant.MethodConstants;
import io.lesible.model.enumeration.EncryptType;
import io.lesible.model.request.DySignRequest;
import io.lesible.model.request.order.*;
import io.lesible.model.response.DyResult;
import io.lesible.model.response.order.*;
import io.lesible.util.ParamUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import retrofit2.Call;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collections;
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
        LocalDateTime oldTime = LocalDateTime.of(2021, 8, 15, 0, 0);
//        LocalDateTime newTime = LocalDateTime.of(2020, 4, 1, 0, 0);
//        LocalDateTime oldTime = LocalDateTime.now().minusDays(10L);
        LocalDateTime newTime = LocalDateTime.now();
        long begin = 1630544438L;
        log.info("begin: {}", begin);
        long end = 1630548038L;
        log.info("end: {}", end);
        OrderSearchListParam param = OrderSearchListParam.builder()
                .updateTimeStart(begin)
                .updateTimeEnd(end)
                .page(0).size(100)
                .orderBy("create_time")
                .orderAsc(true)
                .build();
        DySignRequest<OrderSearchListParam> request = DySignRequest.<OrderSearchListParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstants.ORDER_SEARCH_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<OrderPageInfo>> dyResultCall = orderApi.searchList(paramMap);
        DyResult<OrderPageInfo> body = dyResultCall.execute().body();
        log.info("body: {}", JsonUtil.jsonValue(body));
    }

    /**
     * 订单详情查询
     */
    @Test
    @SneakyThrows
    public void orderOrderDetail() {
        List<Long> orderIds = Collections.singletonList(4872325627760834469L);
        for (Long orderId : orderIds) {
            OrderOrderDetailParam param = OrderOrderDetailParam.builder().shopOrderId(orderId).build();
//        Authorization auth = new Authorization("6840999917109446151", "dbcb95bb-9aff-4dff-9caa-3be62008b773");
            DySignRequest<OrderOrderDetailParam> request = DySignRequest.<OrderOrderDetailParam>builder()
                    .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                    .businessParam(param).method(MethodConstants.ORDER_ORDER_DETAIL).build();
            Map<String, String> paramMap = ParamUtil.buildParamMap(request);
            Call<DyResult<ShopOrderDetailInfo>> dyResultCall = orderApi.orderDetail(paramMap);
            DyResult<ShopOrderDetailInfo> orderDetailInfo = dyResultCall.execute().body();
            log.info("orderId: {}", orderId);
            log.info("orderDetailInfo: {}", JsonUtil.jsonValue(orderDetailInfo));
        }
    }

    /**
     * 订单解密
     */
    @Test
    @SneakyThrows
    public void orderBatchDecrypt() {
        OrderOrderDetailParam param = OrderOrderDetailParam.builder().shopOrderId(4807510692898733727L).build();
        DySignRequest<OrderOrderDetailParam> request = DySignRequest.<OrderOrderDetailParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstants.ORDER_ORDER_DETAIL).build();
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
                    .businessParam(innerParam).method(MethodConstants.ORDER_BATCH_DECRYPT).build();
            Map<String, String> innerParamMap = ParamUtil.buildParamMap(innerRequest);
            Call<String> result = orderApi.batchDecrypt(innerParamMap);
            String body = result.execute().body();
            log.info("body: {}", body);
        }
    }

    /**
     * 订单脱敏
     */
    @Test
    @SneakyThrows
    public void orderBatchSensitive() {
        OrderOrderDetailParam param = OrderOrderDetailParam.builder().shopOrderId(4807510692898733727L).build();
        DySignRequest<OrderOrderDetailParam> request = DySignRequest.<OrderOrderDetailParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstants.ORDER_ORDER_DETAIL).build();
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
            OrderBatchSensitiveParam innerParam = OrderBatchSensitiveParam.builder().cipherInfos(cipherInfos).build();
            DySignRequest<OrderBatchSensitiveParam> innerRequest = DySignRequest.<OrderBatchSensitiveParam>builder()
                    .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                    .businessParam(innerParam).method(MethodConstants.ORDER_BATCH_SENSITIVE).build();
            Map<String, String> innerParamMap = ParamUtil.buildParamMap(innerRequest);
            Call<DyResult<DeSensitiveResult>> result = orderApi.batchSensitive(innerParamMap);
            DyResult<DeSensitiveResult> body = result.execute().body();
            log.info("body: {}", JsonUtil.jsonValue(body));
        }
    }

    @Test
    @SneakyThrows
    public void orderBatchSearchIndex() {
        OrderBatchSearchIndexParam param = OrderBatchSearchIndexParam.builder().plainTextList(Collections.singletonList(
                EncryptText.builder().plainText("15728046568")
                        .encryptType(EncryptType.PHONE_NUM_ENCRYPT).build())).build();
        DySignRequest<OrderBatchSearchIndexParam> request = DySignRequest.<OrderBatchSearchIndexParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstants.ORDER_BATCH_SEARCH_INDEX).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<SearchIndexResult>> dyResultCall = orderApi.batchSearchIndex(paramMap);
        DyResult<SearchIndexResult> body = dyResultCall.execute().body();
        log.info("body: {}", JsonUtil.jsonValue(body));
    }

    @Test
    @SneakyThrows
    public void antiSpamOrderSend() {
        AntiSpamParam param = AntiSpamParam.builder()
                .eventTime(System.currentTimeMillis())
                .params("{}").build();
        DySignRequest<AntiSpamParam> request = DySignRequest.<AntiSpamParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstants.ORDER_ANTI_SPAM_ORDER_SEND).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<AntiSpamResult>> dyResultCall = orderApi.antiSpamOrderSend(paramMap);
        DyResult<AntiSpamResult> body = dyResultCall.execute().body();
        if (body != null && body.isSuccess()) {
            Decision decision = body.getData().getDecision();
            log.info("decision:{}", decision);
        }
    }

}
