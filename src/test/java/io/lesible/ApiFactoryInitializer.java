package io.lesible;

import io.lesible.api.*;
import io.lesible.model.Authorization;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * <p> @date: 2021-06-11 15:07</p>
 *
 * @author 何嘉豪
 */
public class ApiFactoryInitializer {

    //    public static final String GLOBAL_TOKEN = "2f0136ed-67ea-4d53-857b-7dd6e739f3ce";
    public static final String GLOBAL_TOKEN = "2b3f08cc-6d8f-451b-9142-8f46b17d5151";
    public static OrderApi ORDER_API;
    public static ProductApi PRODUCT_API;
    public static CommentApi COMMENT_API;
    public static AuthApi AUTH_API;
    public static ShopApi SHOP_API;
    public static MarketingApi MARKETING_API;

    static {
        Authorization authorization = new Authorization("6873668517658347022", "601f6adf-f7df-42bf-8789-1b3a90979c50");
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(50, 30, TimeUnit.SECONDS))
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://openapi-fxg.jinritemai.com/")
                .addConverterFactory(JacksonConverterFactory.create(ApiFactory.OBJECT_MAPPER))
                .client(client).build();
        ApiFactory API_FACTORY = new ApiFactory(retrofit, authorization);
        ORDER_API = API_FACTORY.generateApi(OrderApi.class);
        PRODUCT_API = API_FACTORY.generateApi(ProductApi.class);
        COMMENT_API = API_FACTORY.generateApi(CommentApi.class);
        AUTH_API = API_FACTORY.generateApi(AuthApi.class);
        SHOP_API = API_FACTORY.generateApi(ShopApi.class);
        MARKETING_API = API_FACTORY.generateApi(MarketingApi.class);
    }


}
