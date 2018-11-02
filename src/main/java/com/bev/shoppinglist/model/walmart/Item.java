
package com.bev.shoppinglist.model.walmart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "itemId",
    "parentItemId",
    "name",
    "msrp",
    "salePrice",
    "upc",
    "categoryPath",
    "shortDescription",
    "longDescription",
    "thumbnailImage",
    "mediumImage",
    "largeImage",
    "productTrackingUrl",
    "standardShipRate",
    "marketplace",
    "modelNumber",
    "productUrl",
    "customerRating",
    "numReviews",
    "customerRatingImage",
    "categoryNode",
    "rhid",
    "bundle",
    "stock",
    "addToCartUrl",
    "affiliateAddToCartUrl",
    "giftOptions",
    "imageEntities",
    "offerType",
    "isTwoDayShippingEligible",
    "availableOnline"
})
public class Item {

    @JsonProperty("itemId")
    private Integer itemId;
    @JsonProperty("parentItemId")
    private Integer parentItemId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("msrp")
    private Double msrp;
    @JsonProperty("salePrice")
    private Double salePrice;
    @JsonProperty("upc")
    private String upc;
    @JsonProperty("categoryPath")
    private String categoryPath;
    @JsonProperty("shortDescription")
    private String shortDescription;
    @JsonProperty("longDescription")
    private String longDescription;
    @JsonProperty("thumbnailImage")
    private String thumbnailImage;
    @JsonProperty("mediumImage")
    private String mediumImage;
    @JsonProperty("largeImage")
    private String largeImage;
    @JsonProperty("productTrackingUrl")
    private String productTrackingUrl;
    @JsonProperty("standardShipRate")
    private Double standardShipRate;
    @JsonProperty("marketplace")
    private Boolean marketplace;
    @JsonProperty("modelNumber")
    private String modelNumber;
    @JsonProperty("productUrl")
    private String productUrl;
    @JsonProperty("customerRating")
    private String customerRating;
    @JsonProperty("numReviews")
    private Integer numReviews;
    @JsonProperty("customerRatingImage")
    private String customerRatingImage;
    @JsonProperty("categoryNode")
    private String categoryNode;
    @JsonProperty("rhid")
    private String rhid;
    @JsonProperty("bundle")
    private Boolean bundle;
    @JsonProperty("stock")
    private String stock;
    @JsonProperty("addToCartUrl")
    private String addToCartUrl;
    @JsonProperty("affiliateAddToCartUrl")
    private String affiliateAddToCartUrl;
    @JsonProperty("giftOptions")
    private GiftOptions giftOptions;
    @JsonProperty("imageEntities")
    private List<ImageEntity> imageEntities = null;
    @JsonProperty("offerType")
    private String offerType;
    @JsonProperty("isTwoDayShippingEligible")
    private Boolean isTwoDayShippingEligible;
    @JsonProperty("availableOnline")
    private Boolean availableOnline;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("itemId")
    public Integer getItemId() {
        return itemId;
    }

    @JsonProperty("itemId")
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @JsonProperty("parentItemId")
    public Integer getParentItemId() {
        return parentItemId;
    }

    @JsonProperty("parentItemId")
    public void setParentItemId(Integer parentItemId) {
        this.parentItemId = parentItemId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("msrp")
    public Double getMsrp() {
        return msrp;
    }

    @JsonProperty("msrp")
    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }

    @JsonProperty("salePrice")
    public Double getSalePrice() {
        return salePrice;
    }

    @JsonProperty("salePrice")
    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    @JsonProperty("upc")
    public String getUpc() {
        return upc;
    }

    @JsonProperty("upc")
    public void setUpc(String upc) {
        this.upc = upc;
    }

    @JsonProperty("categoryPath")
    public String getCategoryPath() {
        return categoryPath;
    }

    @JsonProperty("categoryPath")
    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    @JsonProperty("shortDescription")
    public String getShortDescription() {
        return shortDescription;
    }

    @JsonProperty("shortDescription")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @JsonProperty("longDescription")
    public String getLongDescription() {
        return longDescription;
    }

    @JsonProperty("longDescription")
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @JsonProperty("thumbnailImage")
    public String getThumbnailImage() {
        return thumbnailImage;
    }

    @JsonProperty("thumbnailImage")
    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    @JsonProperty("mediumImage")
    public String getMediumImage() {
        return mediumImage;
    }

    @JsonProperty("mediumImage")
    public void setMediumImage(String mediumImage) {
        this.mediumImage = mediumImage;
    }

    @JsonProperty("largeImage")
    public String getLargeImage() {
        return largeImage;
    }

    @JsonProperty("largeImage")
    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    @JsonProperty("productTrackingUrl")
    public String getProductTrackingUrl() {
        return productTrackingUrl;
    }

    @JsonProperty("productTrackingUrl")
    public void setProductTrackingUrl(String productTrackingUrl) {
        this.productTrackingUrl = productTrackingUrl;
    }

    @JsonProperty("standardShipRate")
    public Double getStandardShipRate() {
        return standardShipRate;
    }

    @JsonProperty("standardShipRate")
    public void setStandardShipRate(Double standardShipRate) {
        this.standardShipRate = standardShipRate;
    }

    @JsonProperty("marketplace")
    public Boolean getMarketplace() {
        return marketplace;
    }

    @JsonProperty("marketplace")
    public void setMarketplace(Boolean marketplace) {
        this.marketplace = marketplace;
    }

    @JsonProperty("modelNumber")
    public String getModelNumber() {
        return modelNumber;
    }

    @JsonProperty("modelNumber")
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    @JsonProperty("productUrl")
    public String getProductUrl() {
        return productUrl;
    }

    @JsonProperty("productUrl")
    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    @JsonProperty("customerRating")
    public String getCustomerRating() {
        return customerRating;
    }

    @JsonProperty("customerRating")
    public void setCustomerRating(String customerRating) {
        this.customerRating = customerRating;
    }

    @JsonProperty("numReviews")
    public Integer getNumReviews() {
        return numReviews;
    }

    @JsonProperty("numReviews")
    public void setNumReviews(Integer numReviews) {
        this.numReviews = numReviews;
    }

    @JsonProperty("customerRatingImage")
    public String getCustomerRatingImage() {
        return customerRatingImage;
    }

    @JsonProperty("customerRatingImage")
    public void setCustomerRatingImage(String customerRatingImage) {
        this.customerRatingImage = customerRatingImage;
    }

    @JsonProperty("categoryNode")
    public String getCategoryNode() {
        return categoryNode;
    }

    @JsonProperty("categoryNode")
    public void setCategoryNode(String categoryNode) {
        this.categoryNode = categoryNode;
    }

    @JsonProperty("rhid")
    public String getRhid() {
        return rhid;
    }

    @JsonProperty("rhid")
    public void setRhid(String rhid) {
        this.rhid = rhid;
    }

    @JsonProperty("bundle")
    public Boolean getBundle() {
        return bundle;
    }

    @JsonProperty("bundle")
    public void setBundle(Boolean bundle) {
        this.bundle = bundle;
    }

    @JsonProperty("stock")
    public String getStock() {
        return stock;
    }

    @JsonProperty("stock")
    public void setStock(String stock) {
        this.stock = stock;
    }

    @JsonProperty("addToCartUrl")
    public String getAddToCartUrl() {
        return addToCartUrl;
    }

    @JsonProperty("addToCartUrl")
    public void setAddToCartUrl(String addToCartUrl) {
        this.addToCartUrl = addToCartUrl;
    }

    @JsonProperty("affiliateAddToCartUrl")
    public String getAffiliateAddToCartUrl() {
        return affiliateAddToCartUrl;
    }

    @JsonProperty("affiliateAddToCartUrl")
    public void setAffiliateAddToCartUrl(String affiliateAddToCartUrl) {
        this.affiliateAddToCartUrl = affiliateAddToCartUrl;
    }

    @JsonProperty("giftOptions")
    public GiftOptions getGiftOptions() {
        return giftOptions;
    }

    @JsonProperty("giftOptions")
    public void setGiftOptions(GiftOptions giftOptions) {
        this.giftOptions = giftOptions;
    }

    @JsonProperty("imageEntities")
    public List<ImageEntity> getImageEntities() {
        return imageEntities;
    }

    @JsonProperty("imageEntities")
    public void setImageEntities(List<ImageEntity> imageEntities) {
        this.imageEntities = imageEntities;
    }

    @JsonProperty("offerType")
    public String getOfferType() {
        return offerType;
    }

    @JsonProperty("offerType")
    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    @JsonProperty("isTwoDayShippingEligible")
    public Boolean getIsTwoDayShippingEligible() {
        return isTwoDayShippingEligible;
    }

    @JsonProperty("isTwoDayShippingEligible")
    public void setIsTwoDayShippingEligible(Boolean isTwoDayShippingEligible) {
        this.isTwoDayShippingEligible = isTwoDayShippingEligible;
    }

    @JsonProperty("availableOnline")
    public Boolean getAvailableOnline() {
        return availableOnline;
    }

    @JsonProperty("availableOnline")
    public void setAvailableOnline(Boolean availableOnline) {
        this.availableOnline = availableOnline;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
