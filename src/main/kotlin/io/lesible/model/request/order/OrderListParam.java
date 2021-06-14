package io.lesible.model.request.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> @date: 2021-04-27 14:56</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@Deprecated
@NoArgsConstructor
@AllArgsConstructor
public class OrderListParam {

    /**
     * 子订单状态
     *
     * @see io.lesible.model.enumeration.OrderStatus
     */
    private String orderStatus;

    /**
     * 开始时间
     * format 2018/06/03 00:00:00
     */
    private String startTime;

    /**
     * 结束时间，必须大于等于开始时间
     * format 2018/06/03 00:01:00
     */
    private String endTime;

    /**
     * 默认按订单创建时间搜索
     * create_time / update_time
     */
    private String orderBy;

    /**
     * 订单排序方式：0按时间升序， 1按时间降序
     */
    private Integer isDesc;

    /**
     * 页数（默认为0，第一页从0开始）
     */
    private Integer page;

    /**
     * 每页订单数（默认为10，最大100）
     */
    private Integer size;


}
