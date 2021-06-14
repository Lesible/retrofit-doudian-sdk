package io.lesible.model.response.comment;

import lombok.Data;

import java.util.List;

/**
 * <p> @date: 2021-04-23 11:30</p>
 *
 * @author 何嘉豪
 */
@Data
public class CommentInfo {

    /**
     * 评价id
     */
    private Long commentId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 子订单号
     */
    private Long orderId;

    /**
     * 评价时间
     */
    private String commentTime;

    /**
     * 评价更新时间
     */
    private String updateTime;

    /**
     * 评价等级，1差评/ 2中评/ 3好评
     */
    private Integer rate;

    /**
     * 评价内容
     */
    private String content;

    /**
     * 评价图片
     */
    private List<Photo> photos;

    /**
     * 追加的评价内容
     */
    private String appendContent;

    /**
     * 追加的评价图片
     */
    private List<Photo> appendPhotos;

    /**
     * 追加评价时间
     */
    private String appendTime;

    /**
     * 是否已修改的评价
     */
    private Boolean isChanged;

    /**
     * 商家回复状态
     */
    private Boolean isReply;

    /**
     * 卖家回复的评论
     */
    private String replyContent;

}
