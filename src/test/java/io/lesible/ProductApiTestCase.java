package io.lesible;

import com.sumwhy.util.JsonUtil;
import io.lesible.api.ProductApi;
import io.lesible.common.constant.MethodConstants;
import io.lesible.model.enumeration.ProductType;
import io.lesible.model.request.DySignRequest;
import io.lesible.model.request.product.ProductDetailParam;
import io.lesible.model.request.product.ProductEditV2Param;
import io.lesible.model.request.product.ProductListParam;
import io.lesible.model.response.DyResult;
import io.lesible.model.response.product.ProductDetail;
import io.lesible.model.response.product.ProductInfo;
import io.lesible.model.response.product.ProductPageInfo;
import io.lesible.util.ParamUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p> @date: 2021-06-11 15:10</p>
 *
 * @author 何嘉豪
 */
public class ProductApiTestCase {

    private static final Logger log = LoggerFactory.getLogger(ProductApiTestCase.class);

    private final ProductApi productApi = ApiFactoryInitializer.PRODUCT_API;

    /**
     * 商品列表查询
     */
    @Test
    @SneakyThrows
    public void productList() {
        ProductListParam productListParam = ProductListParam.builder().page(0)
                .size(100).build();
        DySignRequest<ProductListParam> request = DySignRequest.<ProductListParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(productListParam).method(MethodConstants.PRODUCT_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ProductPageInfo>> dyResultCall = productApi.list(paramMap);
        DyResult<ProductPageInfo> body = dyResultCall.execute().body();
        assert body != null;
        List<String> productIds = body.getData().getData().stream()
                .map(ProductInfo::getProductId)
                .map(it -> "'" + it + "'").collect(Collectors.toList());
        log.info("productIds: {}", productIds);
//        log.info("body: {}", JsonUtil.jsonValue(body));
    }

    /**
     * 商品详情查询
     */
    @Test
    @SneakyThrows
    public void productDetail() {
        ProductDetailParam productDetailParam = ProductDetailParam.builder()
                .productId(3481940313990424094L).build();
        DySignRequest<ProductDetailParam> request = DySignRequest.<ProductDetailParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN).businessParam(productDetailParam)
                .method(MethodConstants.PRODUCT_DETAIL).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<ProductDetail>> dyResultCall = productApi.detail(paramMap);
        DyResult<ProductDetail> body = dyResultCall.execute().body();
        log.info("body: {}", JsonUtil.jsonValue(body));
    }

    /**
     * 编辑商品信息
     */
    @Test
    @SneakyThrows
    public void productEditV2() {
        ProductEditV2Param productDetailParam = ProductEditV2Param
                .builder(3477885072382806635L, ProductType.NORMAL, "true")
                .marketPrice(4280L).discountPrice(2010L).build();
        DySignRequest<ProductEditV2Param> request = DySignRequest.<ProductEditV2Param>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN).businessParam(productDetailParam)
                .method(MethodConstants.PRODUCT_EDIT_V2).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<Boolean>> dyResultCall = productApi.editV2(paramMap);
        DyResult<Boolean> body = dyResultCall.execute().body();
        log.info("body: {}", body);
    }

}
