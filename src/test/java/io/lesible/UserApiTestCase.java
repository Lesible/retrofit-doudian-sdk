package io.lesible;

import io.lesible.api.UserApi;
import io.lesible.model.constant.MethodConstant;
import io.lesible.model.request.DySignRequest;
import io.lesible.model.request.user.GetDoudianOpenIDParam;
import io.lesible.model.response.DyResult;
import io.lesible.model.response.user.DoudianOpenIdRet;
import io.lesible.util.JsonUtil;
import io.lesible.util.ParamUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import retrofit2.Call;

import java.util.Map;

/**
 * <p> @date: 2021-06-15 18:08</p>
 *
 * @author 何嘉豪
 */
@Slf4j
public class UserApiTestCase {

    private final UserApi userApi = ApiFactoryInitializer.USER_API;

    /**
     * 品牌列表查询
     */
    @Test
    @SneakyThrows
    public void getDoudianOpenID() {
        //f6ca36f3-6c17-450b-9254-93467a1d9f88
        GetDoudianOpenIDParam param = GetDoudianOpenIDParam.builder().dyOpenId("2B.f0Ec-40smnyK7").build();
        DySignRequest<GetDoudianOpenIDParam> request = DySignRequest.<GetDoudianOpenIDParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstant.USER_GET_DOUDIAN_OPEN_ID).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<DoudianOpenIdRet>> dyResultCall = userApi.getDoudianOpenID(paramMap);
        DyResult<DoudianOpenIdRet> result = dyResultCall.execute().body();
        log.info("result: {}", JsonUtil.jsonValue(result));
    }

}
