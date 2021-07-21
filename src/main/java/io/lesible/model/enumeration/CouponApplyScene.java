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
 * <p> @date: 2021-06-10 17:05</p>
 *
 * @author 何嘉豪
 */
@JsonSerialize(using = CouponApplyScene.CouponApplySceneSerializer.class)
@JsonDeserialize(using = CouponApplyScene.CouponApplySceneDeserializer.class)
public enum CouponApplyScene {

    /**
     * 货到付款
     */
    PAY_ON_DELIVERY(0),

    /**
     * 在线支付
     */
    PAY_ONLINE(1),

    /**
     * 两种场景都支持
     */
    MIXED(2);

    private final Integer couponApplyScene;

    CouponApplyScene(Integer couponApplyScene) {
        this.couponApplyScene = couponApplyScene;
    }

    public static CouponApplyScene get(Integer couponApplyScene) {
        if (couponApplyScene == null) {
            return null;
        }
        return Arrays.stream(values()).filter(it -> it.couponApplyScene.equals(couponApplyScene))
                .findAny().orElse(null);
    }

    public Integer getCouponApplyScene() {
        return couponApplyScene;
    }

    static class CouponApplySceneSerializer extends StdSerializer<CouponApplyScene> {

        public CouponApplySceneSerializer() {
            super(CouponApplyScene.class);
        }

        @Override
        public void serialize(CouponApplyScene value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeNumber(value.couponApplyScene);
        }

    }

    static class CouponApplySceneDeserializer extends StdDeserializer<CouponApplyScene> {

        public CouponApplySceneDeserializer() {
            super(CouponApplyScene.class);
        }

        @Override
        public CouponApplyScene deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
            JsonNode node = p.getCodec().readTree(p);
            Integer couponApplyScene = node.asInt();
            return CouponApplyScene.get(couponApplyScene);
        }
    }
}


