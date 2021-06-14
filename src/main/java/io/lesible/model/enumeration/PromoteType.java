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
    SELF_CHANNEL_PROMOTE(1);

    private final int promoteType;

    PromoteType(int promoteType) {
        this.promoteType = promoteType;
    }

    public static PromoteType get(int promoteType) {
        return Arrays.stream(values()).filter(it -> it.promoteType == promoteType)
                .findAny().orElse(null);
    }

    public int getPromoteType() {
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
            int promoteType = node.asInt();
            return PromoteType.get(promoteType);
        }
    }
}
