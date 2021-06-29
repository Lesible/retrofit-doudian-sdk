package io.lesible;

import io.lesible.api.UserApi;
import io.lesible.model.constant.MethodConstant;
import io.lesible.model.request.DySignRequest;
import io.lesible.model.request.user.UserGetDoudianOpenIDParam;
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
     * 抖店 openId 获取
     */
    @Test
    @SneakyThrows
    public void getDoudianOpenID() {
//        String dyOpenId = "6f2a9427-c9aa-4aa3-b9ff-e7b918dffcdb";
//        String dyOpenId = "535a20b6-0eba-4c5b-bc44-96d1b00e56d0";
        String dyOpenId = "2B.f0Ec-40smnyK7";
        UserGetDoudianOpenIDParam param = UserGetDoudianOpenIDParam.builder().dyOpenId(dyOpenId)
                .dyClientKey("tt8227f49a1d0d8ab1").build();
        DySignRequest<UserGetDoudianOpenIDParam> request = DySignRequest.<UserGetDoudianOpenIDParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstant.USER_GET_DOUDIAN_OPEN_ID).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<DoudianOpenIdRet>> dyResultCall = userApi.getDoudianOpenID(paramMap);
        DyResult<DoudianOpenIdRet> result = dyResultCall.execute().body();
        log.info("result: {}", JsonUtil.jsonValue(result));
    }

}
