package com.paysgift.productservice.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.productservice.domain.CouponCode} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CouponCodeDTO implements Serializable {

    private Long id;

    @NotNull
    private Long couponId;

    @NotNull
    private Long productId;

    @NotNull
    private String code;

    private Boolean useValidity;

    private Instant validFrom;

    @NotNull
    private Instant validTo;

    private Integer count;

    private Integer countRemaining;

    private Boolean uniquePerCustomer;

    private BigDecimal subtotal;

    private String discountType;

    private BigDecimal discountAmount;

    private BigDecimal discountMaxAmount;

    private Boolean isActive;

    private Boolean isDelete;

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

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getUseValidity() {
        return useValidity;
    }

    public void setUseValidity(Boolean useValidity) {
        this.useValidity = useValidity;
    }

    public Instant getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Instant validFrom) {
        this.validFrom = validFrom;
    }

    public Instant getValidTo() {
        return validTo;
    }

    public void setValidTo(Instant validTo) {
        this.validTo = validTo;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCountRemaining() {
        return countRemaining;
    }

    public void setCountRemaining(Integer countRemaining) {
        this.countRemaining = countRemaining;
    }

    public Boolean getUniquePerCustomer() {
        return uniquePerCustomer;
    }

    public void setUniquePerCustomer(Boolean uniquePerCustomer) {
        this.uniquePerCustomer = uniquePerCustomer;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getDiscountMaxAmount() {
        return discountMaxAmount;
    }

    public void setDiscountMaxAmount(BigDecimal discountMaxAmount) {
        this.discountMaxAmount = discountMaxAmount;
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
        if (!(o instanceof CouponCodeDTO)) {
            return false;
        }

        CouponCodeDTO couponCodeDTO = (CouponCodeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, couponCodeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CouponCodeDTO{" +
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
