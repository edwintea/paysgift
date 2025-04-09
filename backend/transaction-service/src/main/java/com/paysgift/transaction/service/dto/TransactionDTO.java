package com.paysgift.transaction.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.transaction.domain.Transaction} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TransactionDTO implements Serializable {

    private Long id;

    @NotNull
    private Long customerId;

    @NotNull
    private Long countryId;

    @NotNull
    private Long clientId;

    @NotNull
    private Long channelId;

    @NotNull
    private Long brandId;

    @NotNull
    private Long currencyId;

    @NotNull
    private String currencyCode;

    private BigDecimal currencyRate;

    @NotNull
    private Long paymentId;

    @NotNull
    private Long couponCodeId;

    private String shopbackReference;

    private String code;

    private String invoiceCode;

    private BigDecimal productPrice;

    private BigDecimal productPriceUsd;

    private BigDecimal deliveryPrice;

    private BigDecimal deliveryPriceUsd;

    private BigDecimal discProductPrice;

    private BigDecimal discProductPriceUsd;

    private BigDecimal discDeliveryPrice;

    private BigDecimal discDeliveryPriceUsd;

    private BigDecimal discCouponPrice;

    private BigDecimal discCouponPriceUsd;

    private BigDecimal serviceFee;

    private BigDecimal serviceFeeUsd;

    private BigDecimal totalPayment;

    private BigDecimal totalPaymentUsd;

    private String paymentNumber;

    private String paymentQr;

    private String paymentLink;

    private Boolean paymentStatus;

    private Instant paymentExpired;

    private String paymentReferenceId;

    private Instant paidedAt;

    private String status;

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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(BigDecimal currencyRate) {
        this.currencyRate = currencyRate;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getCouponCodeId() {
        return couponCodeId;
    }

    public void setCouponCodeId(Long couponCodeId) {
        this.couponCodeId = couponCodeId;
    }

    public String getShopbackReference() {
        return shopbackReference;
    }

    public void setShopbackReference(String shopbackReference) {
        this.shopbackReference = shopbackReference;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductPriceUsd() {
        return productPriceUsd;
    }

    public void setProductPriceUsd(BigDecimal productPriceUsd) {
        this.productPriceUsd = productPriceUsd;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public BigDecimal getDeliveryPriceUsd() {
        return deliveryPriceUsd;
    }

    public void setDeliveryPriceUsd(BigDecimal deliveryPriceUsd) {
        this.deliveryPriceUsd = deliveryPriceUsd;
    }

    public BigDecimal getDiscProductPrice() {
        return discProductPrice;
    }

    public void setDiscProductPrice(BigDecimal discProductPrice) {
        this.discProductPrice = discProductPrice;
    }

    public BigDecimal getDiscProductPriceUsd() {
        return discProductPriceUsd;
    }

    public void setDiscProductPriceUsd(BigDecimal discProductPriceUsd) {
        this.discProductPriceUsd = discProductPriceUsd;
    }

    public BigDecimal getDiscDeliveryPrice() {
        return discDeliveryPrice;
    }

    public void setDiscDeliveryPrice(BigDecimal discDeliveryPrice) {
        this.discDeliveryPrice = discDeliveryPrice;
    }

    public BigDecimal getDiscDeliveryPriceUsd() {
        return discDeliveryPriceUsd;
    }

    public void setDiscDeliveryPriceUsd(BigDecimal discDeliveryPriceUsd) {
        this.discDeliveryPriceUsd = discDeliveryPriceUsd;
    }

    public BigDecimal getDiscCouponPrice() {
        return discCouponPrice;
    }

    public void setDiscCouponPrice(BigDecimal discCouponPrice) {
        this.discCouponPrice = discCouponPrice;
    }

    public BigDecimal getDiscCouponPriceUsd() {
        return discCouponPriceUsd;
    }

    public void setDiscCouponPriceUsd(BigDecimal discCouponPriceUsd) {
        this.discCouponPriceUsd = discCouponPriceUsd;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getServiceFeeUsd() {
        return serviceFeeUsd;
    }

    public void setServiceFeeUsd(BigDecimal serviceFeeUsd) {
        this.serviceFeeUsd = serviceFeeUsd;
    }

    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }

    public BigDecimal getTotalPaymentUsd() {
        return totalPaymentUsd;
    }

    public void setTotalPaymentUsd(BigDecimal totalPaymentUsd) {
        this.totalPaymentUsd = totalPaymentUsd;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public String getPaymentQr() {
        return paymentQr;
    }

    public void setPaymentQr(String paymentQr) {
        this.paymentQr = paymentQr;
    }

    public String getPaymentLink() {
        return paymentLink;
    }

    public void setPaymentLink(String paymentLink) {
        this.paymentLink = paymentLink;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Instant getPaymentExpired() {
        return paymentExpired;
    }

    public void setPaymentExpired(Instant paymentExpired) {
        this.paymentExpired = paymentExpired;
    }

    public String getPaymentReferenceId() {
        return paymentReferenceId;
    }

    public void setPaymentReferenceId(String paymentReferenceId) {
        this.paymentReferenceId = paymentReferenceId;
    }

    public Instant getPaidedAt() {
        return paidedAt;
    }

    public void setPaidedAt(Instant paidedAt) {
        this.paidedAt = paidedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(o instanceof TransactionDTO)) {
            return false;
        }

        TransactionDTO transactionDTO = (TransactionDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, transactionDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TransactionDTO{" +
            "id=" + getId() +
            ", customerId=" + getCustomerId() +
            ", countryId=" + getCountryId() +
            ", clientId=" + getClientId() +
            ", channelId=" + getChannelId() +
            ", brandId=" + getBrandId() +
            ", currencyId=" + getCurrencyId() +
            ", currencyCode='" + getCurrencyCode() + "'" +
            ", currencyRate=" + getCurrencyRate() +
            ", paymentId=" + getPaymentId() +
            ", couponCodeId=" + getCouponCodeId() +
            ", shopbackReference='" + getShopbackReference() + "'" +
            ", code='" + getCode() + "'" +
            ", invoiceCode='" + getInvoiceCode() + "'" +
            ", productPrice=" + getProductPrice() +
            ", productPriceUsd=" + getProductPriceUsd() +
            ", deliveryPrice=" + getDeliveryPrice() +
            ", deliveryPriceUsd=" + getDeliveryPriceUsd() +
            ", discProductPrice=" + getDiscProductPrice() +
            ", discProductPriceUsd=" + getDiscProductPriceUsd() +
            ", discDeliveryPrice=" + getDiscDeliveryPrice() +
            ", discDeliveryPriceUsd=" + getDiscDeliveryPriceUsd() +
            ", discCouponPrice=" + getDiscCouponPrice() +
            ", discCouponPriceUsd=" + getDiscCouponPriceUsd() +
            ", serviceFee=" + getServiceFee() +
            ", serviceFeeUsd=" + getServiceFeeUsd() +
            ", totalPayment=" + getTotalPayment() +
            ", totalPaymentUsd=" + getTotalPaymentUsd() +
            ", paymentNumber='" + getPaymentNumber() + "'" +
            ", paymentQr='" + getPaymentQr() + "'" +
            ", paymentLink='" + getPaymentLink() + "'" +
            ", paymentStatus='" + getPaymentStatus() + "'" +
            ", paymentExpired='" + getPaymentExpired() + "'" +
            ", paymentReferenceId='" + getPaymentReferenceId() + "'" +
            ", paidedAt='" + getPaidedAt() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            "}";
    }
}
