package io.lesible.model.response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Stone {

    @JsonProperty("remark")
    private String remark;
}