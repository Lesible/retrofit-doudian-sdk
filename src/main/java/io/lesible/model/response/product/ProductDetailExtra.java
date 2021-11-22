package io.lesible.model.response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductDetailExtra {

    @JsonProperty("category_detail")
    private CategoryDetail categoryDetail;

    @JsonProperty("quality_list")
    private List<QualityListItem> qualityList;

    @JsonProperty("class_quality")
    private String classQuality;

    @JsonProperty("quality_report")
    private String qualityReport;

    @JsonProperty("is_publish")
    private Integer isPublish;

    @JsonProperty("stone")
    private Stone stone;
}