package com.paysgift.productservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A CouponCode.
 */
@Entity
@Table(name = "coupon_code")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CouponCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "coupon_id", nullable = false)
    private Long couponId;

    @NotNull
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "use_validity")
    private Boolean useValidity;

    @Column(name = "valid_from")
    private Instant validFrom;

    @NotNull
    @Column(name = "valid_to", nullable = false)
    private Instant validTo;

    @Column(name = "count")
    private Integer count;

    @Column(name = "count_remaining")
    private Integer countRemaining;

    @Column(name = "unique_per_customer")
    private Boolean uniquePerCustomer;

    @Column(name = "subtotal", precision = 21, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "discount_type")
    private String discountType;

    @Column(name = "discount_amount", precision = 21, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "discount_max_amount", precision = 21, scale = 2)
    private BigDecimal discountMaxAmount;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;

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

    public CouponCode id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCouponId() {
        return this.couponId;
    }

    public CouponCode couponId(Long couponId) {
        this.setCouponId(couponId);
        return this;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Long getProductId() {
        return this.productId;
    }

    public CouponCode productId(Long productId) {
        this.setProductId(productId);
        return this;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCode() {
        return this.code;
    }

    public CouponCode code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getUseValidity() {
        return this.useValidity;
    }

    public CouponCode useValidity(Boolean useValidity) {
        this.setUseValidity(useValidity);
        return this;
    }

    public void setUseValidity(Boolean useValidity) {
        this.useValidity = useValidity;
    }

    public Instant getValidFrom() {
        return this.validFrom;
    }

    public CouponCode validFrom(Instant validFrom) {
        this.setValidFrom(validFrom);
        return this;
    }

    public void setValidFrom(Instant validFrom) {
        this.validFrom = validFrom;
    }

    public Instant getValidTo() {
        return this.validTo;
    }

    public CouponCode validTo(Instant validTo) {
        this.setValidTo(validTo);
        return this;
    }

    public void setValidTo(Instant validTo) {
        this.validTo = validTo;
    }

    public Integer getCount() {
        return this.count;
    }

    public CouponCode count(Integer count) {
        this.setCount(count);
        return this;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCountRemaining() {
        return this.countRemaining;
    }

    public CouponCode countRemaining(Integer countRemaining) {
        this.setCountRemaining(countRemaining);
        return this;
    }

    public void setCountRemaining(Integer countRemaining) {
        this.countRemaining = countRemaining;
    }

    public Boolean getUniquePerCustomer() {
        return this.uniquePerCustomer;
    }

    public CouponCode uniquePerCustomer(Boolean uniquePerCustomer) {
        this.setUniquePerCustomer(uniquePerCustomer);
        return this;
    }

    public void setUniquePerCustomer(Boolean uniquePerCustomer) {
        this.uniquePerCustomer = uniquePerCustomer;
    }

    public BigDecimal getSubtotal() {
        return this.subtotal;
    }

    public CouponCode subtotal(BigDecimal subtotal) {
        this.setSubtotal(subtotal);
        return this;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public String getDiscountType() {
        return this.discountType;
    }

    public CouponCode discountType(String discountType) {
        this.setDiscountType(discountType);
        return this;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getDiscountAmount() {
        return this.discountAmount;
    }

    public CouponCode discountAmount(BigDecimal discountAmount) {
        this.setDiscountAmount(discountAmount);
        return this;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getDiscountMaxAmount() {
        return this.discountMaxAmount;
    }

    public CouponCode discountMaxAmount(BigDecimal discountMaxAmount) {
        this.setDiscountMaxAmount(discountMaxAmount);
        return this;
    }

    public void setDiscountMaxAmount(BigDecimal discountMaxAmount) {
        this.discountMaxAmount = discountMaxAmount;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public CouponCode isActive(Boolean isActive) {
        this.setIsActive(isActive);
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsDelete() {
        return this.isDelete;
    }

    public CouponCode isDelete(Boolean isDelete) {
        this.setIsDelete(isDelete);
        return this;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public CouponCode createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public CouponCode createdBy(Long createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public CouponCode updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public CouponCode updatedBy(Long updatedBy) {
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
        if (!(o instanceof CouponCode)) {
            return false;
        }
        return getId() != null && getId().equals(((CouponCode) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CouponCode{" +
            "id=" + getId() +
            ", couponId=" + getCouponId() +
            ", productId=" + getProductId() +
            ", code='" + getCode() + "'" +
            ", useValidity='" + getUseValidity() + "'" +
            ", validFrom='" + getValidFrom() + "'" +
            ", validTo='" + getValidTo() + "'" +
            ", count=" + getCount() +
            ", countRemaining=" + getCountRemaining() +
            ", uniquePerCustomer='" + getUniquePerCustomer() + "'" +
            ", subtotal=" + getSubtotal() +
            ", discountType='" + getDiscountType() + "'" +
            ", discountAmount=" + getDiscountAmount() +
            ", discountMaxAmount=" + getDiscountMaxAmount() +
            ", isActive='" + getIsActive() + "'" +
            ", isDelete='" + getIsDelete() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            "}";
    }
}
