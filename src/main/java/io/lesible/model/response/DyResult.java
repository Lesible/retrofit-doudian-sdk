package io.lesible.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import io.lesible.common.ErrorCode;
import lombok.Data;

/**
 * <p> @date: 2021-04-20 11:32</p>
 *
 * @author 何嘉豪
 */
@Data
public class DyResult<R> {

    private R data;

    /**
     * 错误编号
     */
    @JSONField(name = "err_no")
    private int errNo;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 判断是否请求成功
     *
     * @return return ture if invoke successfully,otherwise false
     */
    public boolean isSuccess() {
        return ErrorCode.SUCCESS.equals(ErrorCode.get(errNo));
    }

}