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
 * <p> @date: 2021-07-21 12:58</p>
 *
 * @author lesible
 */
@JsonSerialize(using = ProductType.ProductTypeSerializer.class)
@JsonDeserialize(using = ProductType.ProductTypeDeserializer.class)
public enum ProductType {

    /**
     * 普通类型
     */
    NORMAL(0),

    /**
     * 虚拟类型
     */
    VIRTUAL(3),

    /**
     * 玉石闪购
     */
    JADE(6),

    /**
     * 云闪购
     */
    CLOUD(7);

    private final Integer productType;

    ProductType(Integer productType) {
        this.productType = productType;
    }

    public static ProductType get(Integer productType) {
        if (productType == null) {
            return null;
        }
        return Arrays.stream(values()).filter(it -> it.productType.equals(productType))
                .findAny().orElse(null);
    }

    public Integer getProductType() {
        return productType;
    }

    static class ProductTypeDeserializer extends StdDeserializer<ProductType> {

        public ProductTypeDeserializer() {
            super(ProductType.class);
        }

        @Override
        public ProductType deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
            JsonNode node = p.getCodec().readTree(p);
            Integer productType = node.asInt();
            return ProductType.get(productType);
        }
    }

    static class ProductTypeSerializer extends StdSerializer<ProductType> {

        public ProductTypeSerializer() {
            super(ProductType.class);
        }

        @Override
        public void serialize(ProductType value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeNumber(value.productType);
        }
    }
}
