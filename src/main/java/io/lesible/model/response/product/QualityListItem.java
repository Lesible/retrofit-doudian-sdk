package io.lesible.model.response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class QualityListItem {

    @JsonProperty("quality_name")
    private String qualityName;

    @JsonProperty("quality_attachments")
    private List<Object> qualityAttachments;

    @JsonProperty("quality_key")
    private String qualityKey;
}