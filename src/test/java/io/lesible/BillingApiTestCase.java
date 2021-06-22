package io.lesible;

import io.lesible.api.BillingApi;
import io.lesible.model.constant.MethodConstant;
import io.lesible.model.request.DySignRequest;
import io.lesible.model.request.billing.BillingAllianceGetOrderListParam;
import io.lesible.model.response.DyResult;
import io.lesible.model.response.billing.AllianceRet;
import io.lesible.util.JsonUtil;
import io.lesible.util.ParamUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import retrofit2.Call;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p> @date: 2021-06-15 11:59</p>
 *
 * @author 何嘉豪
 */
@Slf4j
public class BillingApiTestCase {

    private final BillingApi billingApi = ApiFactoryInitializer.BILLING_API;

    /**
     * 查询联盟订单明细
     */
    @Test
    @SneakyThrows
    public void allianceGetOrderList() {
        List<String> orderIds = Arrays.asList("4734623817994603826", "4802293664846406720", "4805809714063770624",
                "4797685392571649936", "4807371617569799445", "4794035868666855074", "4793997153835708116");
        BillingAllianceGetOrderListParam param = BillingAllianceGetOrderListParam.builder()
                .orderIds(orderIds).build();
        DySignRequest<BillingAllianceGetOrderListParam> request = DySignRequest.<BillingAllianceGetOrderListParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstant.ALLIANCE_GET_ORDER_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<AllianceRet>> dyResultCall = billingApi.list(paramMap);
        DyResult<AllianceRet> allianceRet = dyResultCall.execute().body();
        log.info("allianceRet: {}", JsonUtil.jsonValue(allianceRet));
    }

}
