package io.lesible;

import io.lesible.api.ProductApi;
import io.lesible.model.constant.MethodConstant;
import io.lesible.model.request.DySignRequest;
import io.lesible.model.request.product.ProductDetailParam;
import io.lesible.model.request.product.ProductListParam;
import io.lesible.model.response.DyResult;
import io.lesible.model.response.product.ProductDetail;
import io.lesible.model.response.product.ProductPageInfo;
import io.lesible.util.ParamUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import retrofit2.Call;

import java.util.Map;

/**
 * <p> @date: 2021-06-11 15:10</p>
 *
 * @author 何嘉豪
 */
@Slf4j
public class ProductApiTestCase {

    private final ProductApi productApi = ApiFactoryInitializer.PRODUCT_API;

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
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(productListParam).method(MethodConstant.PRODUCT_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ProductPageInfo>> dyResultCall = productApi.list(paramMap);
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
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN).businessParam(productDetailParam)
                .method(MethodConstant.PRODUCT_DETAIL).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ProductDetail>> dyResultCall = productApi.detail(paramMap);
        DyResult<ProductDetail> body = dyResultCall.execute().body();
        log.info("body: {}", body);
    }


}
