package io.lesible.api;

import io.lesible.model.response.DyResult;
import io.lesible.model.response.comment.CommentPageInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * <p> @date: 2021-04-23 10:56</p>
 *
 * @author 何嘉豪
 */
public interface CommentApi {

    /**
     * 获取满足条件的评价列表
     *
     * @param queryMap 查询参数列表
     * @return 评价列表结果
     */
    @GET("comment/list")
    Call<DyResult<CommentPageInfo>> list(@QueryMap Map<String, String> queryMap);

    /**
     * 回复评价
     *
     * @param queryMap 回复参数列表
     * @return 回复结果
     */
    @GET("comment/reply")
    Call<DyResult<Void>> reply(@QueryMap Map<String, String> queryMap);
}
