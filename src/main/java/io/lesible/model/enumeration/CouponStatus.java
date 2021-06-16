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
 * <p> @date: 2021-06-11 11:33</p>
 *
 * @author 何嘉豪
 */
@JsonSerialize(using = CouponStatus.CouponStatusSerializer.class)
@JsonDeserialize(using = CouponStatus.CouponStatusDeserializer.class)
public enum CouponStatus {

    /**
     * 未生效
     */
    INACTIVATED(1),

    /**
     * 作废状态
     */
    DISABLED(2),

    /**
     * 启用状态
     */
    ACTIVATED(3),

    /**
     * 已过期
     */
    EXPIRED(4);

    /**
     * 优惠券状态
     */
    private final Integer couponStatus;


    CouponStatus(Integer couponStatus) {
        this.couponStatus = couponStatus;
    }

    public static CouponStatus get(Integer couponStatus) {
        if (couponStatus == null) {
            return null;
        }
        return Arrays.stream(values()).filter(it -> it.couponStatus.equals(couponStatus))
                .findAny().orElse(null);
    }

    public Integer getCouponStatus() {
        return couponStatus;
    }

    static class CouponStatusSerializer extends StdSerializer<CouponStatus> {

        public CouponStatusSerializer() {
            super(CouponStatus.class);
        }

        @Override
        public void serialize(CouponStatus value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeNumber(value.couponStatus);
        }
    }

    static class CouponStatusDeserializer extends StdDeserializer<CouponStatus> {

        public CouponStatusDeserializer() {
            super(CouponStatus.class);
        }

        @Override
        public CouponStatus deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
            JsonNode node = p.getCodec().readTree(p);
            Integer couponStatus = node.asInt();
            return CouponStatus.get(couponStatus);
        }
    }

}
