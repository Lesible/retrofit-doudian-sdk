package io.lesible.model.constant;

/**
 * <p> @date: 2021-04-21 18:04</p>
 *
 * @author 何嘉豪
 */
public class MethodConstant {

    /**
     * 获取商品列表
     */
    public static final String PRODUCT_LIST = "product.list";

    /**
     * 获取商品详情
     */
    public static final String PRODUCT_DETAIL = "product.detail";

    /**
     * 订单列表查询
     */
    public static final String ORDER_SEARCH_LIST = "order.searchList";

    /**
     * 订单列表
     */
    @Deprecated
    public static final String ORDER_LIST = "order.list";

    /**
     * 订单详情
     */
    @Deprecated
    public static final String ORDER_DETAIL = "order.detail";

    /**
     * 获取订单详情
     */
    public static final String ORDER_ORDER_DETAIL = "order.orderDetail";

    /**
     * 获取店铺的评论列表
     */
    public static final String COMMENT_LIST = "comment.list";

    /**
     * 卖家回复买家的评论
     */
    public static final String COMMENT_REPLY = "comment.reply";

    /**
     * 获取店铺的已授权品牌列表
     */
    public static final String SHOP_BRAND_LIST = "shop.brandList";

    /**
     * 获取供商家发布商品的类目
     */
    public static final String SHOP_GET_SHOP_CATEGORY = "shop.getShopCategory";

    /**
     * 查询已创建的优惠券列表
     */
    public static final String MARKETING_GET_SHOP_COUPON_META_LIST = "marketing.GetShopCouponMetaList";

    /**
     * 查询指定优惠券详情信息
     */
    public static final String MARKETING_GET_COUPON_DETAIL = "marketing.GetCouponDetail";

    /**
     * 创建优惠券
     */
    public static final String MARKETING_CREATE_COUPON = "marketing.createCoupon";

    /**
     * 启用/作废优惠券
     */
    public static final String MARKETING_ABLE_COUPON_META = "marketing.AbleCouponMeta";

    /**
     * 修改优惠券库存
     */
    public static final String MARKETING_ADJUST_SHOP_COUPON4_META = "marketing.AdjustShopCouponMeta";

    /**
     * 发放优惠券
     */
    public static final String MARKETING_APPLY_COUPON = "marketing.ApplyCoupon";

    /**
     * 查询联盟订单详细
     */
    public static final String ALLIANCE_GET_ORDER_LIST = "alliance.getOrderList";

    /**
     * 获取抖店 openId
     */
    public static final String USER_GET_DOUDIAN_OPEN_ID = "user.getDoudianOpenID";


}
