package io.lesible.model.request.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> @date: 2021-04-23 18:47</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentReplyParam {

    /**
     * 评价ID，通过comment/list接口可获取
     */
    private String commentId;

    /**
     * 回复内容，最大不超过100个汉字
     */
    private String content;

}
