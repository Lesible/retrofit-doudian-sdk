package io.lesible.model.request.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> @date: 2021-04-23 10:34</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentListParam {

    /**
     * 创建时间
     */
    public static final String CREATE_TIME = "create_time";

    /**
     * 更新时间
     */
    public static final String UPDATE_TIME = "update_time";

    /**
     * 顺序排列
     */
    public static final String asc = "0";

    /**
     * 倒序排列
     */
    public static final String desc = "1";


    /**
     * 商品 id
     */
    private String productId;

    /**
     * 订单号，可以是子订单id号
     */
    private String orderId;

    /**
     * 评价开始时间。如果只输入开始时间，那么能返回开始时间之后的评价数据。
     * <p>
     * format: yyyy-MM-dd HH:mm:ss
     */
    private String startTime;

    /**
     * 评价结束时间。如果只输入结束时间，那么全部返回所有评价数据。
     * <p>
     * format: yyyy-MM-dd HH:mm:ss
     */
    private String endTime;

    /**
     * 或者update_time，默认create_time
     */
    private String orderBy;

    /**
     * 是否倒序排列, 默认1
     */
    private String isDesc;

    /**
     * 评价等级，1差评/ 2中评/ 3好评
     */
    private Integer rate;

    /**
     * 商家回复状态
     */
    private Boolean isReply;

    /**
     * 页数，第1页从0开始
     */
    private Integer page;

    /**
     * 每页条数，最大100
     */
    private Integer size;

}
