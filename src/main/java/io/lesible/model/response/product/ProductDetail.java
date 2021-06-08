package io.lesible.model.response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.lesible.model.enumeration.CheckStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * <p> @date: 2021-04-22 17:17</p>
 *
 * @author 何嘉豪
 */
@Data
public class ProductDetail {

    /**
     * 商品ID，整型格式
     */
    private Long productId;

    /**
     * 商品ID，字符串格式
     */
    private String productIdStr;

    /**
     * 商品外部ID
     */
    private Long outProductId;

    /**
     * open应用id （废弃）
     */
    private Long openUserId;

    /**
     * 推荐使用，外部商家编码，支持字符串和数字2种
     */
    private String outerProductId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 详情html
     */
    private String description;

    /**
     * 划线价，单位分
     */
    private Long marketPrice;

    /**
     * 售价，单位分
     */
    private Long discountPrice;

    /**
     * 商品上下架状态：0上架 1下架 2已删除
     */
    private Integer status;

    /**
     * 规格 id
     */
    private Long specId;

    /**
     * 商品审核状态：1未提审 2审核中 3审核通过 4审核驳回 5封禁 7审核通过，待上架状态
     *
     * @see CheckStatus
     */
    private Integer checkStatus;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 一级类目
     */
    private Long firstCid;

    /**
     * 二级类目
     */
    private Long secondCid;

    /**
     * 三级类目
     */
    private Long thirdCid;

    /**
     * 支持的支付方式：0货到付款 1在线支付 2两者都支持
     */
    private Integer payType;

    /**
     * 商家推荐语
     */
    private String recommendRemark;

    /**
     * 预售类型，1-全款预售，0-非预售，2-阶梯库存
     *
     * @see io.lesible.model.enumeration.PreSaleType
     */
    @JsonProperty("presell_type")
    private Integer preSellType;

    /**
     * 扩展字段
     */
    private String extra;

    /**
     * 已废弃，无业务意义
     */
    private Integer isCreate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 商品主图
     */
    private List<String> pic;

    /**
     * 属性名称|属性值
     * 之间用|分隔, 多组之间用^分开
     */
    private String productFormat;

    /**
     * 规格图片
     */
    private List<SpecPic> specPics;

    /**
     * sku详情，其中 id，规格id，spec_id，规格组id
     */
    private List<SpecPrice> specPrices;

    /**
     * 头图，主图第一张
     */
    private String img;

    /**
     * 新类目的详情
     */
    private CategoryDetail categoryDetail;

    /**
     * 每单最大可购买
     */
    private Integer maximumPerOrder;

    /**
     * 每人最大限购
     */
    private Integer limitPerBuyer;

    /**
     * 每单最小购买
     */
    private Integer minimumPerOrder;

    /**
     * 售后服务的信息 jsonStr
     */
    private String afterSaleService;


    private List<Spec> specs;

    private Integer priceHasTax;

    private List<Quality> qualityList;

    private LogisticsInfo logisticsInfo;

    private Integer appointDeliveryDay;
}
