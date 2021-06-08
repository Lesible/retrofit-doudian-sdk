package io.lesible.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> @date: 2021-06-08 20:11</p>
 *
 * @author 何嘉豪
 */
@Slf4j
public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String jsonValue(Object o, ObjectMapper objectMapper) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("转换 json 出错", e);
            return "{}";
        }
    }

    public static String jsonValue(Object o) {
        return jsonValue(o, OBJECT_MAPPER);
    }

}
