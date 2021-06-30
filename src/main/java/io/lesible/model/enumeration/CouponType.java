package io.lesible.model.enumeration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Arrays;

/**
 * <p> @date: 2021-04-23 18:08</p>
 *
 * @author 何嘉豪
 */
@JsonSerialize(using = CouponType.CouponTypeSerializer.class)
@JsonDeserialize(using = CouponType.CouponTypeDeserializer.class)
public enum CouponType {

    /**
     * 平台折扣券
     */
    PLATFORM_DISCOUNT_COUPON(1),

    /**
     * 平台直减券
     */
    PLATFORM_DIRECT_DISCOUNT_COUPON(2),

    /**
     * 商家折扣券
     */
    PLATFORM_FULL_DISCOUNT_COUPON(3),

    /**
     * 商家折扣券
     */
    SHOP_DISCOUNT_COUPON(21),

    /**
     * 商家直减券
     */
    SHOP_DIRECT_DISCOUNT_COUPON(22),

    /**
     * 商家满减券
     */
    SHOP_FULL_DISCOUNT_COUPON(23),

    /**
     * 渠道折扣券
     */
    CHANNEL_DISCOUNT_COUPON(31),

    /**
     * 渠道直减券
     */
    CHANNEL_DIRECT_DISCOUNT_COUPON(32),

    /**
     * 渠道满减券
     */
    CHANNEL_FULL_DISCOUNT_COUPON(33),

    /**
     * 单品折扣券
     */
    ITEM_DISCOUNT_COUPON(41),

    /**
     * 单品直减券
     */
    ITEM_DIRECT_DISCOUNT_COUPON(42),

    /**
     * 单品满减券
     */
    ITEM_FULL_DISCOUNT_COUPON(43);

    private final Integer couponType;

    CouponType(Integer couponType) {
        this.couponType = couponType;
    }

    public static CouponType get(Integer couponType) {
        if (couponType == null) {
            return null;
        }
        return Arrays.stream(values()).filter(it -> it.couponType.equals(couponType))
                .findAny().orElse(null);
    }

    public Integer getCouponType() {
        return couponType;
    }

    static class CouponTypeDeserializer extends StdDeserializer<CouponType> {

        public CouponTypeDeserializer() {
            super(CouponType.class);
        }

        @Override
        public CouponType deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
            JsonNode node = p.getCodec().readTree(p);
            Integer couponType = node.asInt();
            return CouponType.get(couponType);
        }
    }

    static class CouponTypeSerializer extends StdSerializer<CouponType> {

        public CouponTypeSerializer() {
            super(CouponType.class);
        }

        @Override
        public void serialize(CouponType value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeNumber(value.couponType);
        }
    }

}
