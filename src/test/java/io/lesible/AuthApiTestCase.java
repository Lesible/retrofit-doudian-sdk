package io.lesible;

import com.sumwhy.util.JsonUtil;
import io.lesible.api.AuthApi;
import io.lesible.model.response.DyResult;
import io.lesible.model.response.auth.AccessTokenInfo;
import io.lesible.util.ParamUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import retrofit2.Call;

import java.util.Map;

/**
 * <p> @date: 2021-06-11 15:08</p>
 *
 * @author 何嘉豪
 */
@Slf4j
public class AuthApiTestCase {

    private final AuthApi authApi = ApiFactoryInitializer.AUTH_API;

    /**
     * 获取授权
     */
    @Test
    @SneakyThrows
    public void oauth2AccessToken() {
        Map<String, String> paramMap = ParamUtil.buildGetAccessTokenMap("c5c4a4ad-34c6-4667-bd7c-0d17df13fea5");
        Call<DyResult<AccessTokenInfo>> call = authApi.accessToken(paramMap);
        DyResult<AccessTokenInfo> body = call.execute().body();
        log.info("body: {}", body);
    }

    /**
     * 刷新 token
     */
    @Test
    @SneakyThrows
    public void oauth2RefreshToken() {
        Map<String, String> paramMap = ParamUtil.buildRefreshTokenMap("1b9d0222-1be8-49f3-82a0-8c919548124a");
        Call<DyResult<AccessTokenInfo>> call = authApi.refreshToken(paramMap);
        DyResult<AccessTokenInfo> body = call.execute().body();
        log.info("body: {}", JsonUtil.jsonValue(body));
    }

}
