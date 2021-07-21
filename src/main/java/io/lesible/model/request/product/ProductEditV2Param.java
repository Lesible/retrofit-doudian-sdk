package io.lesible.model.request.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lesible.model.enumeration.PreSaleType;
import io.lesible.model.enumeration.ProductType;
import io.lesible.model.response.product.Quality;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p> @date: 2021-07-21 09:47</p>
 *
 * @author lesible
 */
@Data
public class ProductEditV2Param {

    /**
     * 商品 ID
     */
    private Long productId;

    /**
     * 0-普通，3-虚拟，6玉石闪购，7云闪购.
     */
    private ProductType productType;

    /**
     * 商品类目子节点 id
     */
    private Long categoryLeafId;

    /**
     * 一级分类 id
     */
    private Long firstCid;

    /**
     * 二级分类 id
     */
    private Long secondCid;

    /**
     * 三级分类 id
     */
    private Long thirdCid;

    /**
     * 属性名称|属性值 之间用|分隔, 多组之间用^分开
     */
    private String productFormat;

    /**
     * 商品名称，最多60个字符(30个汉字)，不能含 emoji 表情
     */
    private String name;

    /**
     * 商家推荐语，不能含 emoji 表情
     */
    private String recommendRemark;

    /**
     * 商品轮播图，多张图片用 "|" 分开，第一张图为主图，最多5张，至少600x600，大小不超过1M
     * 注："pic"、"description"、"spec_pic"这三个字段里的传入的图片数量总和，不得超过50张。超过会报错：图片转链失败
     */
    private String pic;

    /**
     * 商品描述，目前只支持图片。多张图片用 "|" 分开。不能用其他网站的文本粘贴，这样会出现css样式不兼容 注："pic"、
     * "description"、"spec_pic"这三个字段里的传入的图片数量总和，不得超过50张。超过会报错：图片转链失败
     */
    private String description;

    /**
     * 支付方式，
     * 0 货到付款
     * 1 在线支付，
     * 2 货到付款+在线支付
     */
    private Integer payType;

    /**
     * 划线价，单位分
     */
    private Long marketPrice;
    /**
     * 售价，单位分
     */
    private Long discountPrice;

    /**
     * 减库存类型：1-拍下减库存 2-付款减库存
     */
    private Integer reduceType;

    /**
     * 同店商品推荐：为空表示使用系统推荐；
     * 多个product_id使用“|”分开
     */
    private String assocIds;

    /**
     * 运费模板id，传0表示包邮
     */
    private Long freightId;

    /**
     * 重量
     */
    private Integer weight;
    /**
     * 重量单位，0-kg, 1-g
     */
    private Integer weightUnit;

    /**
     * 承诺发货时间，单位是天
     * 不传则默认为2天，presell_type为0或2均只支持传入2，
     * presell_type为1时支持可选值为: 2、3、5、7、10、15
     */
    private Integer deliveryDelayDay;

    /**
     * 发货模式，0-现货发货，1-预售发货，2-阶梯发货，默认0
     */
    @JsonProperty("presell_type")
    private PreSaleType preSaleType;

    /**
     * 预售模式下结束后，几天发货/阶梯模式下阶梯发货时间，2-15
     */
    @JsonProperty("presell_delay")
    private Integer presellDelay;

    /**
     * 预售结束时间，格式2020-02-21 18:54:27
     * 最多支持设置距离当前30天
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("presell_end_time")
    private LocalDateTime presellEndTime;

    /**
     * 是否支持7天无理由，0不支持，1支持，2支持（拆封后不支持）
     */
    private Integer supply7DayReturn;

    /**
     * 客服电话号码
     */
    private String mobile;

    /**
     * false仅保存，true保存+提审
     */
    private String commit;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     * 商家可见备注
     */
    private String remark;
    /**
     * 商品创建和编辑操作支持设置质检报告链接,多个图片以逗号分隔
     */
    private String qualityReport;
    /**
     * 商品创建和编辑操作支持设置品类资质链接,多个图片以逗号分隔
     */
    private String classQuality;
    /**
     * 系统资质列表,类目与商品资质的映射关系
     */
    private List<Quality> qualityList;

    /**
     * 外部product_id
     */
    private Long outProductId;
    /**
     * 如果不填，则规格名为各级规格名用 "-" 自动生成
     */
    private String specName;
    /**
     * 店铺通用规格，能被同类商品通用。多规格用^分隔，规格与规格值用|分隔，多个规格值用,分隔
     */
    private String specs;

    /**
     * sku详情，数量应该等于规格1规格2规格3，sku数量和规格组合数必须一致
     * sku不可售时，库存可设置为0。
     *
     * @see SpecPriceParam
     */
    private String specPrices;

    /**
     * 如颜色-尺寸, 颜色就是主规格, 颜色如黑,白,黄,它们图片url以逗号分隔 注："pic"、"description"、
     * "spec_pic"这三个字段里的传入的图片数量总和，不得超过50张。超过会报错：图片转链失败图片数量和规格数量对应
     */
    private String specPic;

    /**
     * 每个用户每次下单限购件数
     */
    private Integer maximumPerOrder;

    /**
     * 每个用户累计限购件数
     */
    private Integer limitPerBuyer;

    /**
     * 每个用户每次下单至少购买的件数
     */
    private Integer minimumPerOrder;

    private ProductEditV2Param(ProductEditV2ParamBuilder builder) {
        this.productId = builder.productId;
        this.productType = builder.productType;
        this.categoryLeafId = builder.categoryLeafId;
        this.firstCid = builder.firstCid;
        this.secondCid = builder.secondCid;
        this.thirdCid = builder.thirdCid;
        this.productFormat = builder.productFormat;
        this.name = builder.name;
        this.recommendRemark = builder.recommendRemark;
        this.pic = builder.pic;
        this.description = builder.description;
        this.payType = builder.payType;
        this.marketPrice = builder.marketPrice;
        this.discountPrice = builder.discountPrice;
        this.reduceType = builder.reduceType;
        this.assocIds = builder.assocIds;
        this.freightId = builder.freightId;
        this.weight = builder.weight;
        this.weightUnit = builder.weightUnit;
        this.deliveryDelayDay = builder.deliveryDelayDay;
        this.preSaleType = builder.preSaleType;
        this.presellDelay = builder.presellDelay;
        this.presellEndTime = builder.presellEndTime;
        this.supply7DayReturn = builder.supply7DayReturn;
        this.mobile = builder.mobile;
        this.commit = builder.commit;
        this.brandId = builder.brandId;
        this.remark = builder.remark;
        this.qualityReport = builder.qualityReport;
        this.classQuality = builder.classQuality;
        this.qualityList = builder.qualityList;
        this.outProductId = builder.outProductId;
        this.specName = builder.specName;
        this.specs = builder.specs;
        this.specPrices = builder.specPrices;
        this.specPic = builder.specPic;
        this.maximumPerOrder = builder.maximumPerOrder;
        this.limitPerBuyer = builder.limitPerBuyer;
        this.minimumPerOrder = builder.minimumPerOrder;
    }

    public static ProductEditV2Param.ProductEditV2ParamBuilder builder(Long productId, ProductType productType, String commit) {
        return new ProductEditV2Param.ProductEditV2ParamBuilder(productId, productType, commit);
    }

    public static class ProductEditV2ParamBuilder {
        private final Long productId;
        private final ProductType productType;
        private final String commit;
        private Long categoryLeafId;
        private Long firstCid;
        private Long secondCid;
        private Long thirdCid;
        private String productFormat;
        private String name;
        private String recommendRemark;
        private String pic;
        private String description;
        private Integer payType;
        private Long marketPrice;
        private Long discountPrice;
        private Integer reduceType;
        private String assocIds;
        private Long freightId;
        private Integer weight;
        private Integer weightUnit;
        private Integer deliveryDelayDay;
        private PreSaleType preSaleType;
        private Integer presellDelay;
        private LocalDateTime presellEndTime;
        private Integer supply7DayReturn;
        private String mobile;
        private Long brandId;
        private String remark;
        private String qualityReport;
        private String classQuality;
        private List<Quality> qualityList;
        private Long outProductId;
        private String specName;
        private String specs;
        private String specPrices;
        private String specPic;
        private Integer maximumPerOrder;
        private Integer limitPerBuyer;
        private Integer minimumPerOrder;

        private ProductEditV2ParamBuilder(Long productId, ProductType productType, String commit) {
            this.productId = productId;
            this.productType = productType;
            this.commit = commit;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder categoryLeafId(Long categoryLeafId) {
            this.categoryLeafId = categoryLeafId;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder firstCid(Long firstCid) {
            this.firstCid = firstCid;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder secondCid(Long secondCid) {
            this.secondCid = secondCid;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder thirdCid(Long thirdCid) {
            this.thirdCid = thirdCid;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder productFormat(String productFormat) {
            this.productFormat = productFormat;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder recommendRemark(String recommendRemark) {
            this.recommendRemark = recommendRemark;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder pic(String pic) {
            this.pic = pic;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder payType(Integer payType) {
            this.payType = payType;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder marketPrice(Long marketPrice) {
            this.marketPrice = marketPrice;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder discountPrice(Long discountPrice) {
            this.discountPrice = discountPrice;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder reduceType(Integer reduceType) {
            this.reduceType = reduceType;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder assocIds(String assocIds) {
            this.assocIds = assocIds;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder freightId(Long freightId) {
            this.freightId = freightId;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder weight(Integer weight) {
            this.weight = weight;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder weightUnit(Integer weightUnit) {
            this.weightUnit = weightUnit;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder deliveryDelayDay(Integer deliveryDelayDay) {
            this.deliveryDelayDay = deliveryDelayDay;
            return this;
        }

        @JsonProperty("presell_type")
        public ProductEditV2Param.ProductEditV2ParamBuilder preSaleType(PreSaleType preSaleType) {
            this.preSaleType = preSaleType;
            return this;
        }

        @JsonProperty("presell_delay")
        public ProductEditV2Param.ProductEditV2ParamBuilder presellDelay(Integer presellDelay) {
            this.presellDelay = presellDelay;
            return this;
        }

        @JsonFormat(
                pattern = "yyyy-MM-dd HH:mm:ss"
        )
        @JsonProperty("presell_end_time")
        public ProductEditV2Param.ProductEditV2ParamBuilder presellEndTime(LocalDateTime presellEndTime) {
            this.presellEndTime = presellEndTime;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder supply7DayReturn(Integer supply7DayReturn) {
            this.supply7DayReturn = supply7DayReturn;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder brandId(Long brandId) {
            this.brandId = brandId;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder remark(String remark) {
            this.remark = remark;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder qualityReport(String qualityReport) {
            this.qualityReport = qualityReport;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder classQuality(String classQuality) {
            this.classQuality = classQuality;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder qualityList(List<Quality> qualityList) {
            this.qualityList = qualityList;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder outProductId(Long outProductId) {
            this.outProductId = outProductId;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder specName(String specName) {
            this.specName = specName;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder specs(String specs) {
            this.specs = specs;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder specPrices(String specPrices) {
            this.specPrices = specPrices;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder specPic(String specPic) {
            this.specPic = specPic;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder maximumPerOrder(Integer maximumPerOrder) {
            this.maximumPerOrder = maximumPerOrder;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder limitPerBuyer(Integer limitPerBuyer) {
            this.limitPerBuyer = limitPerBuyer;
            return this;
        }

        public ProductEditV2Param.ProductEditV2ParamBuilder minimumPerOrder(Integer minimumPerOrder) {
            this.minimumPerOrder = minimumPerOrder;
            return this;
        }

        public ProductEditV2Param build() {
            return new ProductEditV2Param(this);
        }

    }
}
