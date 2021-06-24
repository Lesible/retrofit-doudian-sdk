package io.lesible;

import io.lesible.api.UserApi;
import io.lesible.model.constant.MethodConstant;
import io.lesible.model.request.DySignRequest;
import io.lesible.model.request.user.UserGetDoudianOpenIDParam;
import io.lesible.model.response.DyResult;
import io.lesible.model.response.user.DoudianOpenIdRet;
import io.lesible.util.ParamUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import retrofit2.Call;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
        List<String> openIds = Arrays.asList("234567765432", "123456654321");
        List<String> doudianOpenIds = openIds.stream().map(it -> {
            UserGetDoudianOpenIDParam param = UserGetDoudianOpenIDParam.builder().dyOpenId(it)
                    .dyClientKey("tt8227f49a1d0d8ab1").build();
            DySignRequest<UserGetDoudianOpenIDParam> request = DySignRequest.<UserGetDoudianOpenIDParam>builder()
                    .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                    .businessParam(param).method(MethodConstant.USER_GET_DOUDIAN_OPEN_ID).build();
            Map<String, String> paramMap = ParamUtil.buildParamMap(request);
            Call<DyResult<DoudianOpenIdRet>> dyResultCall = userApi.getDoudianOpenID(paramMap);
            DyResult<DoudianOpenIdRet> result = null;
            try {
                result = dyResultCall.execute().body();
            } catch (IOException e) {
                log.error("调用异常", e);
            }
            return result;
        }).filter(Objects::nonNull).map(DyResult::getData)
                .map(DoudianOpenIdRet::getDoudianOpenId).collect(Collectors.toList());
        log.info("doudianOpenIds: {}", doudianOpenIds);
    }

}
