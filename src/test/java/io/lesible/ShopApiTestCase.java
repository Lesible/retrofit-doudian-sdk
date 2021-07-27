package io.lesible;

import io.lesible.api.ShopApi;
import io.lesible.common.constant.MethodConstants;
import io.lesible.model.request.DySignRequest;
import io.lesible.model.request.shop.ShopBrandListParam;
import io.lesible.model.request.shop.ShopGetShopCategoryParam;
import io.lesible.model.response.DyResult;
import io.lesible.model.response.shop.BrandInfo;
import io.lesible.model.response.shop.CategoryInfo;
import io.lesible.util.ParamUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import retrofit2.Call;

import java.util.List;
import java.util.Map;

/**
 * <p> @date: 2021-06-11 15:17</p>
 *
 * @author 何嘉豪
 */
@Slf4j
public class ShopApiTestCase {

    private final ShopApi shopApi = ApiFactoryInitializer.SHOP_API;

    /**
     * 品牌列表查询
     */
    @Test
    @SneakyThrows
    public void brandList() {
        //f6ca36f3-6c17-450b-9254-93467a1d9f88
        ShopBrandListParam param = ShopBrandListParam.builder().build();
        DySignRequest<ShopBrandListParam> request = DySignRequest.<ShopBrandListParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstants.SHOP_BRAND_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<List<BrandInfo>>> dyResultCall = shopApi.brandList(paramMap);
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
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstants.SHOP_GET_SHOP_CATEGORY).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<List<CategoryInfo>>> shopCategory = shopApi.getShopCategory(paramMap);
        DyResult<List<CategoryInfo>> result = shopCategory.execute().body();
        log.info("result: {}", result);
    }

}
