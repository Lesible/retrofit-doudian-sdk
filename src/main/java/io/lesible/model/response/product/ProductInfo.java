package io.lesible.model.response.product;

import lombok.Data;

import java.util.Date;

/**
 * <p> @date: 2021-04-20 11:40</p>
 *
 * @author 何嘉豪
 */
@Data
public class ProductInfo {

    /**
     * 商品 ID
     */
    private Long productId;

    /**
     * 字符串类型商品 id
     */
    private String productIdStr;

    /**
     * 外部商家编码
     */
    private Long outProductId;

    /**
     * 外部商家编码，支持字符串和数字 2 种
     */
    private String outerProductId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品图
     */
    private String img;

    /**
     * 划线价 单位分
     */
    private Long marketPrice;

    /**
     * 售价 单位分
     */
    private Long discountPrice;


    private Long settlementPrice;

    /**
     * 商品上下架状态：0上架 1下架
     */
    private Integer status;

    /**
     * 规格id
     */
    private Long specId;

    /**
     * 商品审核状态：1未提审 2审核中 3审核通过 4审核驳回 5封禁
     */
    private Integer checkStatus;

    /**
     * 手机号
     */
    private String mobile;

    private Double cosRatio;

    private String usp;

    /**
     * 旧一级类目
     */
    private Long firstCid;

    /**
     * 旧二级类目
     */
    private Long secondCid;

    /**
     * 旧三级类目
     */
    private Long thirdCid;

    /**
     * 类目信息
     */
    private CategoryDetail categoryDetail;

    /**
     * 支持的支付方式：0货到付款 1在线支付 2两者都支持
     */
    private Integer payType;

    /**
     * 商家推荐语
     */
    private String recommendRemark;

    /**
     * 额外信息
     */
    private String extra;

    /**
     * 商品创建时间
     */
    private Date createTime;

    /**
     * 商品更新时间
     */
    private Date updateTime;

}
