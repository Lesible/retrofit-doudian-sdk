package io.lesible.model.response.order;

import lombok.Data;

@Data
public class PostAddr {

    /**
     * 省
     */
    private InnerAddress province;

    /**
     * 市
     */
    private InnerAddress city;

    /**
     * 区/县
     */
    private InnerAddress town;

    /**
     * 街道
     */
    private InnerAddress street;

    /**
     *
     */
    private String encryptDetail;

    /**
     * 详细地址
     */
    private String detail;
}
