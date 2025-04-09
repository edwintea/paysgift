package com.paysgift.productservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A Product.
 */
@Entity
@Table(name = "product")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @NotNull
    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "parent_code")
    private String parentCode;

    @Column(name = "sku_code")
    private String skuCode;

    @Column(name = "name")
    private String name;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "description")
    private String description;

    @Column(name = "description_en")
    private String descriptionEn;

    @Column(name = "tnc")
    private String tnc;

    @Column(name = "tnc_en")
    private String tncEn;

    @Column(name = "how_to_claim")
    private String howToClaim;

    @Column(name = "how_to_claim_en")
    private String howToClaimEn;

    @NotNull
    @Column(name = "denom", precision = 21, scale = 2, nullable = false)
    private BigDecimal denom;

    @NotNull
    @Column(name = "buying_price", precision = 21, scale = 2, nullable = false)
    private BigDecimal buyingPrice;

    @NotNull
    @Column(name = "price", precision = 21, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "is_unlimited")
    private Boolean isUnlimited;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "purchase_qty")
    private Integer purchaseQty;

    @Column(name = "remaining_qty")
    private Integer remainingQty;

    @Column(name = "validity_purchase")
    private Integer validityPurchase;

    @Column(name = "validity_start_date")
    private Instant validityStartDate;

    @Column(name = "validity_end_date")
    private Instant validityEndDate;

    @Column(name = "tag")
    private String tag;

    @Column(name = "is_delivery")
    private Boolean isDelivery;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "permalink")
    private String permalink;

    @Column(name = "updated_sync")
    private String updatedSync;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "updated_by")
    private Long updatedBy;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Product id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCountryId() {
        return this.countryId;
    }

    public Product countryId(Long countryId) {
        this.setCountryId(countryId);
        return this;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getBrandId() {
        return this.brandId;
    }

    public Product brandId(Long brandId) {
        this.setBrandId(brandId);
        return this;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getCode() {
        return this.code;
    }

    public Product code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public Product parentCode(String parentCode) {
        this.setParentCode(parentCode);
        return this;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getSkuCode() {
        return this.skuCode;
    }

    public Product skuCode(String skuCode) {
        this.setSkuCode(skuCode);
        return this;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getName() {
        return this.name;
    }

    public Product name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return this.nameEn;
    }

    public Product nameEn(String nameEn) {
        this.setNameEn(nameEn);
        return this;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getDescription() {
        return this.description;
    }

    public Product description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionEn() {
        return this.descriptionEn;
    }

    public Product descriptionEn(String descriptionEn) {
        this.setDescriptionEn(descriptionEn);
        return this;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getTnc() {
        return this.tnc;
    }

    public Product tnc(String tnc) {
        this.setTnc(tnc);
        return this;
    }

    public void setTnc(String tnc) {
        this.tnc = tnc;
    }

    public String getTncEn() {
        return this.tncEn;
    }

    public Product tncEn(String tncEn) {
        this.setTncEn(tncEn);
        return this;
    }

    public void setTncEn(String tncEn) {
        this.tncEn = tncEn;
    }

    public String getHowToClaim() {
        return this.howToClaim;
    }

    public Product howToClaim(String howToClaim) {
        this.setHowToClaim(howToClaim);
        return this;
    }

    public void setHowToClaim(String howToClaim) {
        this.howToClaim = howToClaim;
    }

    public String getHowToClaimEn() {
        return this.howToClaimEn;
    }

    public Product howToClaimEn(String howToClaimEn) {
        this.setHowToClaimEn(howToClaimEn);
        return this;
    }

    public void setHowToClaimEn(String howToClaimEn) {
        this.howToClaimEn = howToClaimEn;
    }

    public BigDecimal getDenom() {
        return this.denom;
    }

    public Product denom(BigDecimal denom) {
        this.setDenom(denom);
        return this;
    }

    public void setDenom(BigDecimal denom) {
        this.denom = denom;
    }

    public BigDecimal getBuyingPrice() {
        return this.buyingPrice;
    }

    public Product buyingPrice(BigDecimal buyingPrice) {
        this.setBuyingPrice(buyingPrice);
        return this;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public Product price(BigDecimal price) {
        this.setPrice(price);
        return this;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getIsUnlimited() {
        return this.isUnlimited;
    }

    public Product isUnlimited(Boolean isUnlimited) {
        this.setIsUnlimited(isUnlimited);
        return this;
    }

    public void setIsUnlimited(Boolean isUnlimited) {
        this.isUnlimited = isUnlimited;
    }

    public Integer getQty() {
        return this.qty;
    }

    public Product qty(Integer qty) {
        this.setQty(qty);
        return this;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getPurchaseQty() {
        return this.purchaseQty;
    }

    public Product purchaseQty(Integer purchaseQty) {
        this.setPurchaseQty(purchaseQty);
        return this;
    }

    public void setPurchaseQty(Integer purchaseQty) {
        this.purchaseQty = purchaseQty;
    }

    public Integer getRemainingQty() {
        return this.remainingQty;
    }

    public Product remainingQty(Integer remainingQty) {
        this.setRemainingQty(remainingQty);
        return this;
    }

    public void setRemainingQty(Integer remainingQty) {
        this.remainingQty = remainingQty;
    }

    public Integer getValidityPurchase() {
        return this.validityPurchase;
    }

    public Product validityPurchase(Integer validityPurchase) {
        this.setValidityPurchase(validityPurchase);
        return this;
    }

    public void setValidityPurchase(Integer validityPurchase) {
        this.validityPurchase = validityPurchase;
    }

    public Instant getValidityStartDate() {
        return this.validityStartDate;
    }

    public Product validityStartDate(Instant validityStartDate) {
        this.setValidityStartDate(validityStartDate);
        return this;
    }

    public void setValidityStartDate(Instant validityStartDate) {
        this.validityStartDate = validityStartDate;
    }

    public Instant getValidityEndDate() {
        return this.validityEndDate;
    }

    public Product validityEndDate(Instant validityEndDate) {
        this.setValidityEndDate(validityEndDate);
        return this;
    }

    public void setValidityEndDate(Instant validityEndDate) {
        this.validityEndDate = validityEndDate;
    }

    public String getTag() {
        return this.tag;
    }

    public Product tag(String tag) {
        this.setTag(tag);
        return this;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Boolean getIsDelivery() {
        return this.isDelivery;
    }

    public Product isDelivery(Boolean isDelivery) {
        this.setIsDelivery(isDelivery);
        return this;
    }

    public void setIsDelivery(Boolean isDelivery) {
        this.isDelivery = isDelivery;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public Product isActive(Boolean isActive) {
        this.setIsActive(isActive);
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsDelete() {
        return this.isDelete;
    }

    public Product isDelete(Boolean isDelete) {
        this.setIsDelete(isDelete);
        return this;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getPermalink() {
        return this.permalink;
    }

    public Product permalink(String permalink) {
        this.setPermalink(permalink);
        return this;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getUpdatedSync() {
        return this.updatedSync;
    }

    public Product updatedSync(String updatedSync) {
        this.setUpdatedSync(updatedSync);
        return this;
    }

    public void setUpdatedSync(String updatedSync) {
        this.updatedSync = updatedSync;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Product createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public Product createdBy(Long createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public Product updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public Product updatedBy(Long updatedBy) {
        this.setUpdatedBy(updatedBy);
        return this;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        return getId() != null && getId().equals(((Product) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Product{" +
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
