package io.lesible.model.response.shop;

import lombok.Data;

/**
 * <p> @date: 2021-05-25 10:29</p>
 *
 * @author 何嘉豪
 */
@Data
public class BrandInfo {

    /**
     * 品牌 id
     */
    private Long id;

    /**
     * 品牌英文名
     */
    private String brandEnglishName;

    /**
     * 品牌中文名
     */
    private String brandChineseName;

    /**
     * 商标注册号
     */
    private String brandRegNum;

}
