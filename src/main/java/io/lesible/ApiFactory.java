package io.lesible;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.lesible.config.ApiFactoryConfig;
import io.lesible.model.Authorization;
import io.lesible.model.request.DySignRequest;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.TimeZone;

/**
 * <p> @date: 2021-04-19 16:07</p>
 *
 * @author 何嘉豪
 */
public class ApiFactory {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
        OBJECT_MAPPER.setTimeZone(TimeZone.getDefault());
        // 出现额外的字段时不失败
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 空字符串解析为 null
        OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        // 键使用字典排序
        OBJECT_MAPPER.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
        OBJECT_MAPPER.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        // 空 bean 时不失败
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }

    private final Retrofit retrofit;

    public ApiFactory(ApiFactoryConfig apiFactoryConfig) {
        DySignRequest.DEFAULT_AUTHORIZATION = new Authorization(apiFactoryConfig
                .getDefaultKey(), apiFactoryConfig.getDefaultSecret());
        this.retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create(OBJECT_MAPPER))
                .baseUrl(apiFactoryConfig.getBaseUrl()).build();
    }

    public ApiFactory(Retrofit retrofit, Authorization defaultAuthorization) {
        DySignRequest.DEFAULT_AUTHORIZATION = defaultAuthorization;
        this.retrofit = retrofit;
    }

    public <T> T generateApi(Class<T> apiClass) {
        return retrofit.create(apiClass);
    }
}