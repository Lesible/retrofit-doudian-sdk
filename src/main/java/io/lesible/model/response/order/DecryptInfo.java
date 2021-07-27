package io.lesible.model.response.order;

import lombok.Data;

/**
 * 解密后的信息
 * <p> @date: 2021-07-21 11:20</p>
 *
 * @author 何嘉豪
 */
@Data
public class DecryptInfo {

    /**
     * 业务标识，value 为抖音订单号
     */
    private Long authId;

    /**
     * 密文
     */
    private String cipherText;

    /**
     * 解密/脱敏结果
     */
    private String decryptText;

    /**
     * 错误码
     */
    private Integer errNo;

    /**
     * 错误描述
     */
    private String errMsg;

}
