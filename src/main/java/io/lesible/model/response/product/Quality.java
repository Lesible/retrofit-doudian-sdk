package io.lesible.model.response.product;

import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-22 18:25</p>
 *
 * @author 何嘉豪
 */
@Data
public class Quality {

    private String qualityName;
    private List<QualityAttachment> qualityAttachments;
    private String qualityKey;

}
