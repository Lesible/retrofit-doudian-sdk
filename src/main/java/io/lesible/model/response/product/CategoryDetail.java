package io.lesible.model.response.product;

import lombok.Data;

/**
 * <p> @date: 2021-04-20 11:51</p>
 *
 * @author 何嘉豪
 */
@Data
public class CategoryDetail {

    /**
     * 新一级类目
     */
    private Long firstCid;

    /**
     * 新二级类目
     */
    private Long secondCid;

    /**
     * 新三级类目
     */
    private Long thirdCid;

    /**
     * 新四级类目
     */
    private Long fourthCid;

    /**
     * 一级类目名称
     */
    private String firstCname;

    /**
     * 二级类目名称
     */
    private String secondCname;

    /**
     * 三级类目名称
     */
    private String thirdCname;

    /**
     * 四级类目名称
     */
    private String fourthCname;

}
