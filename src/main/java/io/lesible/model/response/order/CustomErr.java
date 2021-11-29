package io.lesible.model.response.order;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomErr {

    @JsonProperty("err_msg")
    private String errMsg;

    @JsonProperty("err_code")
    private Integer errCode;
}