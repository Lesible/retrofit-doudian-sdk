package io.lesible.model.response.billing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-06-15 11:45</p>
 *
 * @author 何嘉豪
 */
@Data
public class AllianceRet {

    /**
     * 返回编码
     */
    private String code;

    /**
     * 返回信息
     */
    private String codeMsg;

    /**
     * 订单明细数据
     */
    @JsonProperty("datas")
    private List<AllianceInfo> allianceInfoList;

}
