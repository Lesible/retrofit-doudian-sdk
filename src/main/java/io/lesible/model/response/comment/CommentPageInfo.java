package io.lesible.model.response.comment;

import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-23 11:30</p>
 *
 * @author 何嘉豪
 */
@Data
public class CommentPageInfo {

    /**
     * 评价总条数
     */
    private Integer total;

    /**
     * 评论列表
     */
    private List<CommentInfo> comments;

}
