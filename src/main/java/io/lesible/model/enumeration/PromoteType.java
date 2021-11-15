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
 * <p> @date: 2021-06-10 17:14</p>
 *
 * @author 何嘉豪
 */
@JsonSerialize(using = PromoteType.PromoteTypeSerializer.class)
@JsonDeserialize(using = PromoteType.PromoteTypeTypeDeserializer.class)
public enum PromoteType {

    /**
     * 全网店铺推广
     */
    PLATFORM_PROMOTE(0),

    /**
     * 自有渠道推广
     */
    SELF_CHANNEL_PROMOTE(1),

    /**
     * 新客专享
     */
    NEW_CUSTOMER_PROMOTE(2),

    /**
     * 定向券
     */
    DIRECT_COUPON_PROMOTE(3),

    /**
     * 单品广告推广券
     */
    SINGLE_ITEM_PROMOTE(4),

    /**
     * 评价返券
     */
    COMMENT_COUPON_PROMOTE(5),

    /**
     * 会员开卡礼
     */
    MEMBER_CREATE_CARD_PROMOTE(9);

    private final Integer promoteType;

    PromoteType(Integer promoteType) {
        this.promoteType = promoteType;
    }

    public static PromoteType get(Integer promoteType) {
        if (promoteType == null) {
            return null;
        }
        return Arrays.stream(values()).filter(it -> it.promoteType.equals(promoteType))
                .findAny().orElse(null);
    }

    public Integer getPromoteType() {
        return promoteType;
    }

    static class PromoteTypeSerializer extends StdSerializer<PromoteType> {

        public PromoteTypeSerializer() {
            super(PromoteType.class);
        }

        @Override
        public void serialize(PromoteType value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeNumber(value.promoteType);
        }

    }


    static class PromoteTypeTypeDeserializer extends StdDeserializer<PromoteType> {

        public PromoteTypeTypeDeserializer() {
            super(PromoteType.class);
        }

        @Override
        public PromoteType deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
            JsonNode node = p.getCodec().readTree(p);
            Integer promoteType = node.asInt();
            return PromoteType.get(promoteType);
        }
    }
}
