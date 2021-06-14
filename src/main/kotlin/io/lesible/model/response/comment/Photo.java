package io.lesible.model.response.comment;

import lombok.Data;

/**
 * <p> @date: 2021-04-23 11:58</p>
 *
 * @author 何嘉豪
 */
@Data
public class Photo {

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 大图
     */
    private String url;
}
