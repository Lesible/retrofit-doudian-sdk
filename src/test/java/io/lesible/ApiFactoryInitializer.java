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

    //900000074
//    public static final String GLOBAL_TOKEN = "a6948eff-c087-4364-a70e-7ce0a0ff554d";
    // 900000021
    public static final String GLOBAL_TOKEN = "b694c740-3b09-4f80-b8ca-688b58d261b7";
    // 900000001
//    public static final String GLOBAL_TOKEN = "7aa1abb3-b501-45fb-806a-6a3a61e51f65";
    public static OrderApi ORDER_API;
    public static ProductApi PRODUCT_API;
    public static CommentApi COMMENT_API;
    public static AuthApi AUTH_API;
    public static ShopApi SHOP_API;
    public static MarketingApi MARKETING_API;
    public static BillingApi BILLING_API;
    public static UserApi USER_API;

    static {
        Authorization authorization = new Authorization("6873668517658347022", "601f6adf-f7df-42bf-8789-1b3a90979c50");
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(50, 30, TimeUnit.SECONDS))
//                .addInterceptor(interceptor)
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
        BILLING_API = API_FACTORY.generateApi(BillingApi.class);
        USER_API = API_FACTORY.generateApi(UserApi.class);
    }


}
