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
 * <p> @date: 2021-04-22 17:33</p>
 *
 * @author 何嘉豪
 */
@JsonSerialize(using = PreSaleType.PreSaleTypeSerializer.class)
@JsonDeserialize(using = ProductType.ProductTypeDeserializer.class)
public enum PreSaleType {
    /**
     * 非预售
     */
    NO_PRE_SELL(0),

    /**
     * 全款预售
     */
    FULL_PAYMENT_PRE_SELL(1),

    /**
     * 阶梯库存
     */
    ECHELON_INVENTORY(2);

    private final Integer preSaleType;

    PreSaleType(Integer preSaleType) {
        this.preSaleType = preSaleType;
    }

    public static PreSaleType get(Integer preSaleType) {
        if (preSaleType == null) {
            return null;
        }
        return Arrays.stream(values()).filter(it -> it.preSaleType.equals(preSaleType))
                .findAny().orElse(null);
    }

    public Integer getPreSaleType() {
        return preSaleType;
    }

    static class PreSaleTypeDeserializer extends StdDeserializer<PreSaleType> {

        public PreSaleTypeDeserializer() {
            super(PreSaleType.class);
        }

        @Override
        public PreSaleType deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
            JsonNode node = p.getCodec().readTree(p);
            Integer preSaleType = node.asInt();
            return PreSaleType.get(preSaleType);
        }
    }

    static class PreSaleTypeSerializer extends StdSerializer<PreSaleType> {

        public PreSaleTypeSerializer() {
            super(PreSaleType.class);
        }

        @Override
        public void serialize(PreSaleType value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeNumber(value.preSaleType);
        }
    }
}
