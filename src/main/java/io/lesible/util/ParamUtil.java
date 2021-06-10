package io.lesible.util;

import io.lesible.ApiFactory;
import io.lesible.model.request.DySignRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * <p> @date: 2021-04-19 17:04</p>
 *
 * @author 何嘉豪
 */
@Slf4j
public class ParamUtil {

    /**
     * 时间格式化方式 1970-01-01 00:00:00
     */
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 默认的授权方式,授权码
     */
    private static final String DEFAULT_GRANT_TYPE = "authorization_code";

    /**
     * 使用 refreshToken 授权方式
     */
    private static final String REFRESH_GRANT_TYPE = "refresh_token";

    /**
     * 通过 code 去获取授权码
     */
    private static final int GET_ACCESS_TOKEN = 1;

    /**
     * 通过 refreshToken 去获取授权码
     */
    private static final int REFRESH_ACCESS_TOKEN = 2;

    public static Map<String, String> buildParamMap(DySignRequest<?> dySignRequest) {
        // 校验请求
        checkRequest(dySignRequest);
        String paramJson = JsonUtil.jsonValue(dySignRequest.getBusinessParam(), ApiFactory.OBJECT_MAPPER);
        log.info("paramJson: {}", paramJson);
        // 使用 treeMap,保证参数的字母顺序
        Map<String, String> paramMap = new TreeMap<>();
        // 不传入 appKey, secret 就使用默认的
        String appKey = dySignRequest.getAppKey();
        String secret = dySignRequest.getAppSecret();
        paramMap.put("app_key", StringUtils.isBlank(appKey) ? DySignRequest.DEFAULT_AUTHORIZATION.getAppKey() : appKey);
        paramMap.put("method", dySignRequest.getMethod());
        paramMap.put("param_json", paramJson);
        paramMap.put("timestamp", FORMATTER.format(LocalDateTime.now()));
        paramMap.put("v", "2");
        // 不要改变生成签名的位置, 签名只需要前面 5 个属性
        String sign = generateSignStr(paramMap, StringUtils.isBlank(secret) ? DySignRequest.DEFAULT_AUTHORIZATION.getAppSecret() : secret);
        paramMap.put("sign", sign);
        paramMap.put("access_token", dySignRequest.getAccessToken());
        return paramMap;
    }

    /**
     * 参数校验
     *
     * @param dySignRequest dySignRequest
     */
    private static void checkRequest(DySignRequest<?> dySignRequest) {
        String method = dySignRequest.getMethod();
        String accessToken = dySignRequest.getAccessToken();
        String appKey = dySignRequest.getAppKey();
        String secret = dySignRequest.getAppSecret();
        if (StringUtils.isBlank(method)) {
            throw new IllegalArgumentException("method can not be blank");
        }
        if (StringUtils.isBlank(accessToken)) {
            throw new IllegalArgumentException("accessToken can not be blank");
        }
        if (StringUtils.isBlank(appKey) && StringUtils.isBlank(DySignRequest.DEFAULT_AUTHORIZATION.getAppKey())) {
            throw new IllegalArgumentException("appKey can not be blank");
        }
        if (StringUtils.isBlank(secret) && StringUtils.isBlank(DySignRequest.DEFAULT_AUTHORIZATION.getAppSecret())) {
            throw new IllegalArgumentException("secret can not be blank");
        }
    }

    private static String generateSignStr(Map<String, String> paramMap, String secret) {
        String sb = secret + paramMap.entrySet().stream().map(entry -> entry.getKey() + entry.getValue())
                .collect(Collectors.joining()).replaceAll("\\\\+", "%2b") + secret;
        return DigestUtils.md5Hex(sb);
    }

    /**
     * 构建授权参数用于获取/刷新 accessToken
     *
     * @param codeOrRefreshToken code / refreshToken
     * @param type               如果为1,code,获取 accessToken,如果为 2,refreshToken,刷新 accessToken
     * @return map
     */
    private static Map<String, String> buildAuthMap(String codeOrRefreshToken, int type) {
        if (type != GET_ACCESS_TOKEN && type != REFRESH_ACCESS_TOKEN) {
            throw new IllegalArgumentException("unsupported fetch accessToken type");
        }
        Map<String, String> paramMap = new TreeMap<>();
        String appKey = DySignRequest.DEFAULT_AUTHORIZATION.getAppKey();
        String authSecret = DySignRequest.DEFAULT_AUTHORIZATION.getAppSecret();
        if (StringUtils.isAnyBlank(appKey, authSecret)) {
            throw new IllegalArgumentException("any of appKey and appSecret can not be null");
        }
        paramMap.put("app_id", appKey);
        paramMap.put("app_secret", authSecret);
        if (type == GET_ACCESS_TOKEN) {
            paramMap.put("code", codeOrRefreshToken);
            paramMap.put("grant_type", DEFAULT_GRANT_TYPE);
        }
        if (type == REFRESH_ACCESS_TOKEN) {
            paramMap.put("refresh_token", codeOrRefreshToken);
            paramMap.put("grant_type", REFRESH_GRANT_TYPE);
        }
        return paramMap;
    }

    /**
     * 根据 code 获取 accessToken
     *
     * @param code 授权码
     * @return 请求参数
     */
    public static Map<String, String> buildGetAccessTokenMap(String code) {
        return buildAuthMap(code, GET_ACCESS_TOKEN);
    }

    /**
     * 根据 refreshToken 获取 token
     *
     * @param refreshToken 刷新 token
     * @return 请求参数
     */
    public static Map<String, String> buildRefreshTokenMap(String refreshToken) {
        return buildAuthMap(refreshToken, REFRESH_ACCESS_TOKEN);
    }

}
