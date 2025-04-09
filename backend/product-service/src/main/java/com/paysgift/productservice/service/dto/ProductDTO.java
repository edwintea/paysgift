package com.paysgift.productservice.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.productservice.domain.Product} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProductDTO implements Serializable {

    private Long id;

    @NotNull
    private Long countryId;

    @NotNull
    private Long brandId;

    @NotNull
    private String code;

    private String parentCode;

    private String skuCode;

    private String name;

    private String nameEn;

    private String description;

    private String descriptionEn;

    private String tnc;

    private String tncEn;

    private String howToClaim;

    private String howToClaimEn;

    @NotNull
    private BigDecimal denom;

    @NotNull
    private BigDecimal buyingPrice;

    @NotNull
    private BigDecimal price;

    private Boolean isUnlimited;

    private Integer qty;

    private Integer purchaseQty;

    private Integer remainingQty;

    private Integer validityPurchase;

    private Instant validityStartDate;

    private Instant validityEndDate;

    private String tag;

    private Boolean isDelivery;

    private Boolean isActive;

    private Boolean isDelete;

    private String permalink;

    private String updatedSync;

    private Instant createdAt;

    private Long createdBy;

    private Instant updatedAt;

    private Long updatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getTnc() {
        return tnc;
    }

    public void setTnc(String tnc) {
        this.tnc = tnc;
    }

    public String getTncEn() {
        return tncEn;
    }

    public void setTncEn(String tncEn) {
        this.tncEn = tncEn;
    }

    public String getHowToClaim() {
        return howToClaim;
    }

    public void setHowToClaim(String howToClaim) {
        this.howToClaim = howToClaim;
    }

    public String getHowToClaimEn() {
        return howToClaimEn;
    }

    public void setHowToClaimEn(String howToClaimEn) {
        this.howToClaimEn = howToClaimEn;
    }

    public BigDecimal getDenom() {
        return denom;
    }

    public void setDenom(BigDecimal denom) {
        this.denom = denom;
    }

    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getIsUnlimited() {
        return isUnlimited;
    }

    public void setIsUnlimited(Boolean isUnlimited) {
        this.isUnlimited = isUnlimited;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getPurchaseQty() {
        return purchaseQty;
    }

    public void setPurchaseQty(Integer purchaseQty) {
        this.purchaseQty = purchaseQty;
    }

    public Integer getRemainingQty() {
        return remainingQty;
    }

    public void setRemainingQty(Integer remainingQty) {
        this.remainingQty = remainingQty;
    }

    public Integer getValidityPurchase() {
        return validityPurchase;
    }

    public void setValidityPurchase(Integer validityPurchase) {
        this.validityPurchase = validityPurchase;
    }

    public Instant getValidityStartDate() {
        return validityStartDate;
    }

    public void setValidityStartDate(Instant validityStartDate) {
        this.validityStartDate = validityStartDate;
    }

    public Instant getValidityEndDate() {
        return validityEndDate;
    }

    public void setValidityEndDate(Instant validityEndDate) {
        this.validityEndDate = validityEndDate;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Boolean getIsDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(Boolean isDelivery) {
        this.isDelivery = isDelivery;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getUpdatedSync() {
        return updatedSync;
    }

    public void setUpdatedSync(String updatedSync) {
        this.updatedSync = updatedSync;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductDTO)) {
            return false;
        }

        ProductDTO productDTO = (ProductDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, productDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + getId() +
            ", countryId=" + getCountryId() +
            ", brandId=" + getBrandId() +
            ", code='" + getCode() + "'" +
            ", parentCode='" + getParentCode() + "'" +
            ", skuCode='" + getSkuCode() + "'" +
            ", name='" + getName() + "'" +
            ", nameEn='" + getNameEn() + "'" +
            ", description='" + getDescription() + "'" +
            ", descriptionEn='" + getDescriptionEn() + "'" +
            ", tnc='" + getTnc() + "'" +
            ", tncEn='" + getTncEn() + "'" +
            ", howToClaim='" + getHowToClaim() + "'" +
            ", howToClaimEn='" + getHowToClaimEn() + "'" +
            ", denom=" + getDenom() +
            ", buyingPrice=" + getBuyingPrice() +
            ", price=" + getPrice() +
            ", isUnlimited='" + getIsUnlimited() + "'" +
            ", qty=" + getQty() +
            ", purchaseQty=" + getPurchaseQty() +
            ", remainingQty=" + getRemainingQty() +
            ", validityPurchase=" + getValidityPurchase() +
            ", validityStartDate='" + getValidityStartDate() + "'" +
            ", validityEndDate='" + getValidityEndDate() + "'" +
            ", tag='" + getTag() + "'" +
            ", isDelivery='" + getIsDelivery() + "'" +
            ", isActive='" + getIsActive() + "'" +
            ", isDelete='" + getIsDelete() + "'" +
            ", permalink='" + getPermalink() + "'" +
            ", updatedSync='" + getUpdatedSync() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            "}";
    }
}
