package io.lesible.model.response.order;

import lombok.Data;

@Data
public class CustomErr {

    private String errMsg;

    private Integer errCode;
}