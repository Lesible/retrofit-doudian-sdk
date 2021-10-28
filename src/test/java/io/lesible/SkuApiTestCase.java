package io.lesible;

import com.sumwhy.util.JsonUtil;
import io.lesible.api.SkuApi;
import io.lesible.common.constant.MethodConstants;
import io.lesible.model.request.DySignRequest;
import io.lesible.model.request.sku.SkuEditPriceParam;
import io.lesible.model.request.sku.SkuListParam;
import io.lesible.model.request.sku.SkuSyncStockParam;
import io.lesible.model.response.DyResult;
import io.lesible.model.response.sku.SkuListInfo;
import io.lesible.util.ParamUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import retrofit2.Call;

import java.util.List;
import java.util.Map;

/**
 * <p> @date: 2021-06-15 18:08</p>
 *
 * @author 何嘉豪
 */
@Slf4j
public class SkuApiTestCase {

    private final SkuApi skuApi = ApiFactoryInitializer.SKU_API;

    /**
     * sku 列表获取
     */
    @Test
    @SneakyThrows
    public void list() {
        Long productId = 3419599839250504560L;
        SkuListParam param = SkuListParam.builder().productId(productId).build();
        DySignRequest<SkuListParam> request = DySignRequest.<SkuListParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstants.SKU_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<List<SkuListInfo>>> dyResultCall = skuApi.list(paramMap);
        DyResult<List<SkuListInfo>> result = dyResultCall.execute().body();
        log.info("result: {}", JsonUtil.jsonValue(result));
    }


    /**
     * sku 价格修改
     */
    @Test
    @SneakyThrows
    public void editPrice() {
        Long skuId = 1698186066278423L;
        SkuEditPriceParam param = SkuEditPriceParam.builder().skuId(skuId).price(1980L).build();
        DySignRequest<SkuEditPriceParam> request = DySignRequest.<SkuEditPriceParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstants.SKU_EDIT_PRICE).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<Void>> dyResultCall = skuApi.editPrice(paramMap);
        DyResult<Void> result = dyResultCall.execute().body();
        log.info("result: {}", result);
    }

    /**
     * sku 库存修改
     */
    @Test
    @SneakyThrows
    public void syncStock() {
        Long skuId = 1698186066278423L;
        SkuSyncStockParam param = SkuSyncStockParam.builder().skuId(skuId).stockNum(994).build();
        DySignRequest<SkuSyncStockParam> request = DySignRequest.<SkuSyncStockParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstants.SKU_SYNC_STOCK).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<Void>> dyResultCall = skuApi.syncStock(paramMap);
        DyResult<Void> result = dyResultCall.execute().body();
        log.info("result: {}", result);
    }


}
