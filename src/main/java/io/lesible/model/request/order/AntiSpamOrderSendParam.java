package io.lesible.model.request.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AntiSpamOrderSendParam {

    private Long eventTime;

    private User user;

    private String params;

}
