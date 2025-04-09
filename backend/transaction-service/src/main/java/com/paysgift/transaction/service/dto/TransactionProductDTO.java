package com.paysgift.transaction.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.transaction.domain.TransactionProduct} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TransactionProductDTO implements Serializable {

    private Long id;

    @NotNull
    private Long transactionId;

    @NotNull
    private Long transactionSendId;

    @NotNull
    private Long productId;

    @NotNull
    private Long countryId;

    @NotNull
    private Long brandId;

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

    private String image;

    private BigDecimal denom;

    private BigDecimal buyingPrice;

    private BigDecimal buyingPriceUsd;

    private BigDecimal price;

    private BigDecimal priceUsd;

    private BigDecimal discPrice;

    private BigDecimal discPriceUsd;

    private BigDecimal totalPrice;

    private BigDecimal totalPriceUsd;

    private Boolean isDelivery;

    private Boolean paymentStatus;

    private Boolean status;

    private Boolean isCode;

    private String voucherLink;

    private String voucherCode;

    private String voucherPin;

    private String voucherIssuance;

    private Instant voucherExpired;

    private String voucherReference;

    private String referenceNumber;

    private String errorCode;

    private String errorReason;

    private Boolean retry;

    private Boolean blibliItemId;

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

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTransactionSendId() {
        return transactionSendId;
    }

    public void setTransactionSendId(Long transactionSendId) {
        this.transactionSendId = transactionSendId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public BigDecimal getBuyingPriceUsd() {
        return buyingPriceUsd;
    }

    public void setBuyingPriceUsd(BigDecimal buyingPriceUsd) {
        this.buyingPriceUsd = buyingPriceUsd;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(BigDecimal priceUsd) {
        this.priceUsd = priceUsd;
    }

    public BigDecimal getDiscPrice() {
        return discPrice;
    }

    public void setDiscPrice(BigDecimal discPrice) {
        this.discPrice = discPrice;
    }

    public BigDecimal getDiscPriceUsd() {
        return discPriceUsd;
    }

    public void setDiscPriceUsd(BigDecimal discPriceUsd) {
        this.discPriceUsd = discPriceUsd;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPriceUsd() {
        return totalPriceUsd;
    }

    public void setTotalPriceUsd(BigDecimal totalPriceUsd) {
        this.totalPriceUsd = totalPriceUsd;
    }

    public Boolean getIsDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(Boolean isDelivery) {
        this.isDelivery = isDelivery;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getIsCode() {
        return isCode;
    }

    public void setIsCode(Boolean isCode) {
        this.isCode = isCode;
    }

    public String getVoucherLink() {
        return voucherLink;
    }

    public void setVoucherLink(String voucherLink) {
        this.voucherLink = voucherLink;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getVoucherPin() {
        return voucherPin;
    }

    public void setVoucherPin(String voucherPin) {
        this.voucherPin = voucherPin;
    }

    public String getVoucherIssuance() {
        return voucherIssuance;
    }

    public void setVoucherIssuance(String voucherIssuance) {
        this.voucherIssuance = voucherIssuance;
    }

    public Instant getVoucherExpired() {
        return voucherExpired;
    }

    public void setVoucherExpired(Instant voucherExpired) {
        this.voucherExpired = voucherExpired;
    }

    public String getVoucherReference() {
        return voucherReference;
    }

    public void setVoucherReference(String voucherReference) {
        this.voucherReference = voucherReference;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorReason() {
        return errorReason;
    }

    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    public Boolean getRetry() {
        return retry;
    }

    public void setRetry(Boolean retry) {
        this.retry = retry;
    }

    public Boolean getBlibliItemId() {
        return blibliItemId;
    }

    public void setBlibliItemId(Boolean blibliItemId) {
        this.blibliItemId = blibliItemId;
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
        if (!(o instanceof TransactionProductDTO)) {
            return false;
        }

        TransactionProductDTO transactionProductDTO = (TransactionProductDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, transactionProductDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TransactionProductDTO{" +
            "id=" + getId() +
            ", transactionId=" + getTransactionId() +
            ", transactionSendId=" + getTransactionSendId() +
            ", productId=" + getProductId() +
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
            ", image='" + getImage() + "'" +
            ", denom=" + getDenom() +
            ", buyingPrice=" + getBuyingPrice() +
            ", buyingPriceUsd=" + getBuyingPriceUsd() +
            ", price=" + getPrice() +
            ", priceUsd=" + getPriceUsd() +
            ", discPrice=" + getDiscPrice() +
            ", discPriceUsd=" + getDiscPriceUsd() +
            ", totalPrice=" + getTotalPrice() +
            ", totalPriceUsd=" + getTotalPriceUsd() +
            ", isDelivery='" + getIsDelivery() + "'" +
            ", paymentStatus='" + getPaymentStatus() + "'" +
            ", status='" + getStatus() + "'" +
            ", isCode='" + getIsCode() + "'" +
            ", voucherLink='" + getVoucherLink() + "'" +
            ", voucherCode='" + getVoucherCode() + "'" +
            ", voucherPin='" + getVoucherPin() + "'" +
            ", voucherIssuance='" + getVoucherIssuance() + "'" +
            ", voucherExpired='" + getVoucherExpired() + "'" +
            ", voucherReference='" + getVoucherReference() + "'" +
            ", referenceNumber='" + getReferenceNumber() + "'" +
            ", errorCode='" + getErrorCode() + "'" +
            ", errorReason='" + getErrorReason() + "'" +
            ", retry='" + getRetry() + "'" +
            ", blibliItemId='" + getBlibliItemId() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            "}";
    }
}
