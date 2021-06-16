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
 * <p> @date: 2021-06-10 15:47</p>
 * 优惠券类型
 *
 * @author 何嘉豪
 */
@JsonSerialize(using = CouponPeriodType.CouponPeriodTypeSerializer.class)
@JsonDeserialize(using = CouponPeriodType.CouponPeriodTypeDeserializer.class)
public enum CouponPeriodType {
    /**
     * 固定有效期
     */
    FIXED_PERIOD(1),

    /**
     * 浮动有效期
     */
    FLOAT_PERIOD(2);

    private final Integer periodType;

    CouponPeriodType(Integer periodType) {
        this.periodType = periodType;
    }

    public static CouponPeriodType get(Integer periodType) {
        if (periodType == null) {
            return null;
        }
        return Arrays.stream(values()).filter(it -> it.periodType.equals(periodType))
                .findAny().orElse(null);
    }

    private Integer getPeriodType() {
        return periodType;
    }

    static class CouponPeriodTypeSerializer extends StdSerializer<CouponPeriodType> {

        public CouponPeriodTypeSerializer() {
            super(CouponPeriodType.class);
        }

        @Override
        public void serialize(CouponPeriodType value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeNumber(value.periodType);
        }

    }


    static class CouponPeriodTypeDeserializer extends StdDeserializer<CouponPeriodType> {

        public CouponPeriodTypeDeserializer() {
            super(CouponPeriodType.class);
        }

        @Override
        public CouponPeriodType deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
            JsonNode node = p.getCodec().readTree(p);
            Integer couponPeriodType = node.asInt();
            return CouponPeriodType.get(couponPeriodType);
        }
    }

}
