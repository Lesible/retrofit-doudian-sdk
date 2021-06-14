package io.lesible.model.response.product;

import lombok.Data;

/**
 * <p> @date: 2021-04-23 12:07</p>
 *
 * @author 何嘉豪
 */
@Data
public class QualityAttachment {

    private Integer mediaType;

    /**
     * 报告 url
     */
    private String url;

}
