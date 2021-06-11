package io.lesible;

import io.lesible.api.OrderApi;
import io.lesible.model.constant.MethodConstant;
import io.lesible.model.request.DySignRequest;
import io.lesible.model.request.order.OrderDetailParam;
import io.lesible.model.request.order.OrderListParam;
import io.lesible.model.request.order.OrderOrderDetailParam;
import io.lesible.model.request.order.OrderSearchListParam;
import io.lesible.model.response.DyResult;
import io.lesible.model.response.order.OldOrderPageInfo;
import io.lesible.model.response.order.OldShopOrderDetailInfo;
import io.lesible.model.response.order.OrderPageInfo;
import io.lesible.model.response.order.ShopOrderDetailInfo;
import io.lesible.util.JsonUtil;
import io.lesible.util.ParamUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import retrofit2.Call;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * <p> @date: 2021-06-11 15:13</p>
 *
 * @author 何嘉豪
 */
@Slf4j
public class OrderApiTestCase {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private final OrderApi orderApi = ApiFactoryInitializer.ORDER_API;

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
        OrderOrderDetailParam param = OrderOrderDetailParam.builder().shopOrderId("4807261687878395536").build();
        DySignRequest<OrderOrderDetailParam> request = DySignRequest.<OrderOrderDetailParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstant.ORDER_ORDER_DETAIL).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ShopOrderDetailInfo>> dyResultCall = orderApi.orderDetail(paramMap);
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
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstant.ORDER_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<OldOrderPageInfo>> dyResultCall = orderApi.list(paramMap);
        DyResult<OldOrderPageInfo> orderListResult = dyResultCall.execute().body();
        log.info("orderListResult: {}", orderListResult);
    }

    /**
     * 订单详情查询 即将废弃
     */
    @Test
    @SneakyThrows
    public void orderDetail() {
        String orderIds = "4807261687878395536A";
        for (String s : orderIds.split(",")) {
            OrderDetailParam param = OrderDetailParam.builder().orderId(s).build();
            DySignRequest<OrderDetailParam> request = DySignRequest.<OrderDetailParam>builder()
                    .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                    .businessParam(param).method(MethodConstant.ORDER_DETAIL).build();
            Map<String, String> paramMap = ParamUtil.buildParamMap(request);
            Call<DyResult<OldShopOrderDetailInfo>> dyResultCall = orderApi.detail(paramMap);
            DyResult<OldShopOrderDetailInfo> oldShopOrderDetail = dyResultCall.execute().body();
            log.info("oldShopOrderDetail: {}", oldShopOrderDetail);
            log.info("oldShopOrderDetail: {}", JsonUtil.jsonValue(oldShopOrderDetail));
        }
    }


}
