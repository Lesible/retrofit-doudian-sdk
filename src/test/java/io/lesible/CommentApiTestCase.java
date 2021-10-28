package io.lesible;

import com.sumwhy.util.JsonUtil;
import io.lesible.api.CommentApi;
import io.lesible.common.constant.MethodConstants;
import io.lesible.model.request.DySignRequest;
import io.lesible.model.request.comment.CommentListParam;
import io.lesible.model.request.comment.CommentReplyParam;
import io.lesible.model.response.DyResult;
import io.lesible.model.response.comment.CommentPageInfo;
import io.lesible.util.ParamUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import retrofit2.Call;

import java.util.Map;

/**
 * <p> @date: 2021-06-11 15:16</p>
 *
 * @author 何嘉豪
 */
@Slf4j
public class CommentApiTestCase {

    private final CommentApi commentApi = ApiFactoryInitializer.COMMENT_API;

    /**
     * 评价列表查询
     */
    @Test
    @SneakyThrows
    public void commentList() {
        CommentListParam param = CommentListParam.builder()
                .orderBy("update_time").isDesc("-1").build();
        DySignRequest<CommentListParam> request = DySignRequest.<CommentListParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstants.COMMENT_LIST).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<CommentPageInfo>> dyResultCall = commentApi.list(paramMap);
        DyResult<CommentPageInfo> commentPageInfo = dyResultCall.execute().body();
        log.info("commentPageInfo: {}", JsonUtil.jsonValue(commentPageInfo));
    }

    /**
     * 回复评价
     */
    @Test
    @SneakyThrows
    public void commentReply() {
        CommentReplyParam param = CommentReplyParam.builder().commentId("137844687636578599")
                .content("谢谢您的光临,能让您满意真是太好了").build();
        DySignRequest<CommentReplyParam> request = DySignRequest.<CommentReplyParam>builder()
                .accessToken(ApiFactoryInitializer.GLOBAL_TOKEN)
                .businessParam(param).method(MethodConstants.COMMENT_REPLY).build();
        Map<String, String> paramMap = ParamUtil.buildParamMap(request);
        Call<DyResult<Void>> dyResultCall = commentApi.reply(paramMap);
        DyResult<Void> commentReplay = dyResultCall.execute().body();
        log.info("commentReplay: {}", commentReplay);
    }

}
