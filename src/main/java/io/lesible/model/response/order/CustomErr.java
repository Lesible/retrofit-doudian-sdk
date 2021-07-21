package io.lesible.model.response.order;

import lombok.Data;

/**
 * 业务错误
 * <p> @date: 2021-07-21 11:20</p>
 *
 * @author 何嘉豪
 */
@Data
public class CustomErr {

    /**
     * 错误码
     */
    private Integer errCode;

    /**
     * 错误描述
     */
    private String errMsg;
}
