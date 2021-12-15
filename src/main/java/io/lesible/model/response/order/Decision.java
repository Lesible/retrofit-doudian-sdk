package io.lesible.model.response.order;

import lombok.Data;

@Data
public class Decision{
    private String hitStatus;
    private String decision;
    private String decisionDetail;
}
