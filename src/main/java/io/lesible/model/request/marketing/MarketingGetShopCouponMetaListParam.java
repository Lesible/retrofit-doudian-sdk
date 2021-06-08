package io.lesible.model.request.marketing;

import io.lesible.model.enumeration.CouponType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> @date: 2021-06-03 11:56</p>
 *
 * @author 何嘉豪
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketingGetShopCouponMetaListParam {

    /**
     * 优惠券批次 id
     */
    private Long couponMetaId;

    /**
     * 开始生效时间
     * <p>
     * format: yyyy/MM/dd HH:mm
     */
    private String startTime;

    /**
     * 过期时间
     * <p>
     * format: yyyy/MM/dd HH:mm
     */
    private String expireTime;

    /**
     * 优惠券名称
     */
    private String couponName;

    /**
     * 优惠券类型
     *
     * @see io.lesible.model.enumeration.CouponType
     */
    private Integer type;
    /**
     * 偏移
     */
    private Integer offset;

    /**
     * 每页最大个数
     */
    private Integer limit;

    /**
     * 是否全网推广
     * 0:全网推广 1.自有渠道
     */
    private Integer isShow;

    public static MarketingGetShopCouponMetaListParamBuilder builder() {
        return new MarketingGetShopCouponMetaListParamBuilder();
    }

    @Data
    public static class MarketingGetShopCouponMetaListParamBuilder {
        private Long couponMetaId;
        private String startTime;
        private String expireTime;
        private String couponName;
        private Integer type;
        private Integer offset;
        private Integer limit;
        private Integer isShow;

        public MarketingGetShopCouponMetaListParamBuilder couponMetaId(Long couponMetaId) {
            this.couponMetaId = couponMetaId;
            return this;
        }

        public MarketingGetShopCouponMetaListParamBuilder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public MarketingGetShopCouponMetaListParamBuilder expireTime(String expireTime) {
            this.expireTime = expireTime;
            return this;
        }

        public MarketingGetShopCouponMetaListParamBuilder couponName(String couponName) {
            this.couponName = couponName;
            return this;
        }

        public MarketingGetShopCouponMetaListParamBuilder type(CouponType type) {
            this.type = type.value();
            return this;
        }

        public MarketingGetShopCouponMetaListParamBuilder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        public MarketingGetShopCouponMetaListParamBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public MarketingGetShopCouponMetaListParamBuilder isShow(Integer isShow) {
            this.isShow = isShow;
            return this;
        }

        public MarketingGetShopCouponMetaListParam build() {
            return new MarketingGetShopCouponMetaListParam(this.couponMetaId, this.startTime, this.expireTime, this.couponName, this.type, this.offset, this.limit, this.isShow);
        }

    }
}
