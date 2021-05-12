package io.lesible.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.parser.ParserConfig;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

/**
 * <p> @date: 2021-04-20 19:51</p>
 *
 * @author 何嘉豪
 */
public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Type type;

    private final ParserConfig parserConfig;

    public FastJsonResponseBodyConverter(Type type) {
        this.type = type;
        this.parserConfig = new ParserConfig();
        parserConfig.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        return JSON.parseObject(value.byteStream(), StandardCharsets.UTF_8, type, parserConfig);
    }
}
