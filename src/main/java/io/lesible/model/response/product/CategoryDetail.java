package io.lesible.model.response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoryDetail {

    @JsonProperty("first_cid")
    private Long firstCid;

    @JsonProperty("first_cname")
    private String firstCname;

    @JsonProperty("second_cid")
    private Long secondCid;

    @JsonProperty("second_cname")
    private String secondCname;

    @JsonProperty("third_cid")
    private Long thirdCid;

    @JsonProperty("third_cname")
    private String thirdCname;

    @JsonProperty("fourth_cid")
    private Integer fourthCid;

    @JsonProperty("fourth_cname")
    private String fourthCname;

    @JsonProperty("is_leaf")
    private Boolean isLeaf;

}