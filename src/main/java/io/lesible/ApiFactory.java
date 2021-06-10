package io.lesible;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.lesible.config.ApiFactoryConfig;
import io.lesible.model.Authorization;
import io.lesible.model.request.DySignRequest;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * <p> @date: 2021-04-19 16:07</p>
 *
 * @author 何嘉豪
 */
public class ApiFactory {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
//        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.findAndRegisterModules();
        OBJECT_MAPPER.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
        OBJECT_MAPPER.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
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