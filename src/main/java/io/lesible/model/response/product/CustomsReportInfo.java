package io.lesible.model.response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * <p> @date: 2021-04-22 17:52</p>
 *
 * @author 何嘉豪
 */
@Data
public class CustomsReportInfo {

    private String unit;

    /**
     * 抖音不给文档
     */
    @JsonProperty("g_model")
    private String gModel;
    private Integer firstMeasureQty;
    private Integer secondMeasureQty;
    private String reportBrandName;
    private String usage;
    private String barCode;
    private String secondMeasureUnit;
    private String reportName;
    private String hsCode;
    private String firstMeasureUnit;
}
