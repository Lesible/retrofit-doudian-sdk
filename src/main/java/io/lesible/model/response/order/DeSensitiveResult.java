package io.lesible.model.response.order;

import lombok.Data;

import java.util.List;

/**
 * 脱敏结果
 * <p> @date: 2021-07-21 11:20</p>
 *
 * @author 何嘉豪
 */
@Data
public class DeSensitiveResult {

    /**
     * 脱敏信息列表
     */
    private List<DecryptInfo> decryptInfos;

    /**
     * 业务错误
     */
    private CustomErr customErr;
}