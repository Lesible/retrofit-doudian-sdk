package io.lesible.model.response.order;

import lombok.Data;

/**
 * <p> @date: 2021-05-27 17:40</p>
 * 售后信息
 *
 * @author 何嘉豪
 */
@Data
public class AfterSaleInfo {

    /**
     * 售后状态:
     * 0-售后初始化， 6-售后申请， 7-售后退货中
     * 27-拒绝售后申请， 12-售后成功， 28-售后失败
     * 11-售后已发货， 29-退货后拒绝退款， 13-售后换货商家发货
     * 14-售后换货用户收货， 51-取消成功， 53-逆向交易完成
     *
     * @see io.lesible.model.enumeration.AfterSaleStatus
     */
    private Integer afterSaleStatus;

    /**
     * 售后类型
     * <p>
     * 0售后退货退款，1售后仅退款，2售前仅退款
     *
     * @see io.lesible.model.enumeration.AfterSaleType
     */
    private Integer afterSaleType;

    /**
     * 退款类型 0: Origin, 原路退回
     * 1: Offline, 线下退款
     * 2: ImPreset,预付款退款
     * 3: Pledge,保证金退款
     * 4: None,无需退款
     * 5: RefundTypeAll, 所有
     *
     * @see io.lesible.model.enumeration.RefundStatus
     */
    private Integer refundStatus;

}
