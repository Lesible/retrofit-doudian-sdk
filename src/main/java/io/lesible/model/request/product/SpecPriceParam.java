package io.lesible.model.request.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SpecPriceParam {
    private Long outSkuId;
    @JsonProperty("spec_detail_name1")
    private String specDetailName1;
    @JsonProperty("spec_detail_name2")
    private String specDetailName2;
    @JsonProperty("spec_detail_name3")
    private String specDetailName3;
    private String code;
    private Long price;
    private Integer stockNum;
    private Integer stepStockNum;
    private Long supplierId;
}
