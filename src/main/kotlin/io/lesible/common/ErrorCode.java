package io.lesible.common;

/**
 * <p> @date: 2021-04-21 11:31</p>
 *
 * @author 何嘉豪
 */
public enum ErrorCode {

    /**
     * 成功
     */
    SUCCESS(0),

    /**
     * 请登录后再操作
     */
    OPERATE_AFTER_LOGIN(1),

    /**
     * 无权限
     */
    No_PERMISSION(2),

    /**
     * 缺少参数
     */
    MISSING_ARGS(3),

    /**
     * 错误参数
     */
    WRONG_ARGS(4),

    /**
     * 非法参数
     */
    ILLEGAL_ARGS(5),

    /**
     * 业务参数json解析失败, 所有参数需为string类型
     */
    BUSINESS_PARSE_ERROR(6),

    /**
     * 服务器错误
     */
    SERVER_ERROR(7),

    /**
     * 服务器繁忙
     */
    SERVER_IS_BUSY(8),

    /**
     * 访问太频繁
     */
    TOO_MANY_REQUEST(9),

    /**
     * 需要使用 post 方式请求
     */
    ONLY_POST_METHOD_ALLOWED(10),

    /**
     * 签名校验失败
     */
    SIGN_VERIFY_FAILED(11),

    /**
     * 版本太旧,请升级
     */
    VERSION_IS_TOO_OLD(12),

    /**
     * 找不到 userId
     */
    USER_ID_CAN_NOT_BE_FIND(302),

    /**
     * 认证失败，app_key格式不正确，应为19位纯数字
     * 认证失败，app_key不存在
     * 认证失败，access_token不能为空
     */
    AUTH_FAILED(30001),

    /**
     * access_token已过期
     */
    ACCESS_TOKEN_EXPIRED(30002),

    /**
     * 店铺授权已失效，请重新引导商家完成店铺授权
     */
    AUTHORIZATION_EXPIRED(30003),

    /**
     * 应用已被系统禁用
     */
    APP_FORBID_BY_SYS(30004),

    /**
     * access_token不存在，请使用最新的access_token访问
     */
    ACCESS_TOKEN_NOT_EXIST(30005),

    /**
     * 店铺授权已被关闭，请联系商家打开授权开关
     */
    AUTHORIZATION_IS_CLOSED(30006),

    /**
     * app_key和access_token不匹配，请仔细检查
     */
    APP_KEY_NOT_MATCH_ACCESS_TOKEN(30007);

    /**
     * 错误代码
     */
    private final int errorCode;

    ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public static ErrorCode get(int errNo) {
        for (ErrorCode value : values()) {
            if (value.value() == errNo) {
                return value;
            }
        }
        return null;
    }

    /**
     * 获取当前枚举的错误编码
     *
     * @return errorCode
     */
    public int value() {
        return errorCode;
    }
}
