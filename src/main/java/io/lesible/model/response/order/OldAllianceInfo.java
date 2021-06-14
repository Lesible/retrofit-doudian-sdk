package io.lesible.model.response.order;

import lombok.Data;

/**
 * <p> @date: 2021-04-28 14:11</p>
 *
 * @author 何嘉豪
 */
@Data
@Deprecated
public class OldAllianceInfo {

    private Integer estimatedCommission;
    private Integer realCommission;
    private String allianceBizType;
    private Integer commissionRate;
    private Long phaseId;
    private String shortId;
    private String authorAccount;

}
