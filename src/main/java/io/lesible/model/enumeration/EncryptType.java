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
 * <p>  </p>
 * <p> created at 2021-11-11 16:53 by lesible </p>
 *
 * @author 何嘉豪
 */
@JsonSerialize(using = EncryptType.EncryptTypeSerializer.class)
@JsonDeserialize(using = EncryptType.EncryptTypeDeserializer.class)
public enum EncryptType {
    ADDRESS_ENCRYPT(1),
    NAME_ENCRYPT(2),
    PHONE_NUM_ENCRYPT(3);

    private final int encryptType;

    EncryptType(Integer encryptType) {
        this.encryptType = encryptType;
    }

    public static EncryptType get(int encryptType) {
        return Arrays.stream(values()).filter(it -> it.encryptType == encryptType)
                .findAny().orElse(null);
    }

    public int getEncryptType() {
        return encryptType;
    }

    static class EncryptTypeSerializer extends StdSerializer<EncryptType> {

        public EncryptTypeSerializer() {
            super(EncryptType.class);
        }

        @Override
        public void serialize(EncryptType value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeNumber(value.encryptType);
        }

    }


    static class EncryptTypeDeserializer extends StdDeserializer<EncryptType> {

        public EncryptTypeDeserializer() {
            super(EncryptType.class);
        }

        @Override
        public EncryptType deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
            JsonNode node = p.getCodec().readTree(p);
            int promoteType = node.asInt();
            return EncryptType.get(promoteType);
        }
    }
}
