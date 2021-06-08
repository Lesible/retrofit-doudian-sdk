package io.lesible.model.request.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.lesible.model.enumeration.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p> @date: 2021-04-21 17:18</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderSearchListParam {

    /**
     * 商品名称
     */
    private String product;

    /**
     * app渠道:
     * 0 站外 1 火山 2 抖音 3 头条 4 西瓜 5 微信 6 值点app 7 头条lite 8 懂车帝
     * 9 皮皮虾 11 抖音极速版 12 TikTok 13 musically 14 穿山甲 15 火山极速版 16 服务市场
     * 使用枚举类去赋值
     *
     * @see BType
     */
    private Integer bType;

    /**
     * 售后状态
     * 全部,售后中,退款中,退款成功,退款失败,换货成功,售后关闭
     * 使用枚举类去赋值
     *
     * @see AfterSaleStatusDesc
     */
    private String afterSaleStatusDesc;

    /**
     * 物流单号
     */
    private String trackingNo;

    /**
     * 预售类型
     *
     * @see io.lesible.model.enumeration.PreSaleType
     */
    @JsonProperty("presell_type")
    private Integer preSellType;

    /**
     * 订单类型
     */
    private Integer orderType;

    /**
     * 下单时间：开始
     * 时间戳 (second)
     */
    private Long createTimeStart;
    /**
     * 下单时间：截止
     * 时间戳 (second)
     */
    private Long createTimeEnd;

    /**
     * 异常订单
     * 使用枚举类去赋值
     *
     * @see AbnormalOrder
     */
    private Integer abnormalOrder;

    /**
     * 交易类型
     * 使用枚举类去赋值
     *
     * @see TradeType
     */
    private Integer tradeType;

    /**
     * 状态组合查询,直接输入状态码
     */
    private List<CombineStatus> combineStatus;

    /**
     * 更新时间：开始
     * 时间戳 (second)
     */
    private Long updateTimeStart;

    /**
     * 更新时间：开始
     * 时间戳 (second)
     */
    private Long updateTimeEnd;

    /**
     * 单页大小，限制100以内
     */
    private Integer size;

    /**
     * 页码，0页开始
     */
    private Integer page;

    /**
     * 排序条件
     */
    private String orderBy;

    /**
     * 排序类型，小到大或大到小，默认大到小
     */
    private Boolean orderAsc;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CombineStatus {

        /**
         * 订单状态，","分隔多个状态
         *
         * @see OrderStatus
         */
        private String orderStatus;

        /**
         * 主流程状态，","分隔多个状态
         *
         * @see OrderStatus
         */
        private String mainStatus;

    }
}
