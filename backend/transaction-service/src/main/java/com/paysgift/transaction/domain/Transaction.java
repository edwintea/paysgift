package com.paysgift.transaction.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A Transaction.
 */
@Entity
@Table(name = "transaction")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @NotNull
    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @NotNull
    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @NotNull
    @Column(name = "channel_id", nullable = false)
    private Long channelId;

    @NotNull
    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    @NotNull
    @Column(name = "currency_id", nullable = false)
    private Long currencyId;

    @NotNull
    @Column(name = "currency_code", nullable = false)
    private String currencyCode;

    @Column(name = "currency_rate", precision = 21, scale = 2)
    private BigDecimal currencyRate;

    @NotNull
    @Column(name = "payment_id", nullable = false)
    private Long paymentId;

    @NotNull
    @Column(name = "coupon_code_id", nullable = false)
    private Long couponCodeId;

    @Column(name = "shopback_reference")
    private String shopbackReference;

    @Column(name = "code")
    private String code;

    @Column(name = "invoice_code")
    private String invoiceCode;

    @Column(name = "product_price", precision = 21, scale = 2)
    private BigDecimal productPrice;

    @Column(name = "product_price_usd", precision = 21, scale = 2)
    private BigDecimal productPriceUsd;

    @Column(name = "delivery_price", precision = 21, scale = 2)
    private BigDecimal deliveryPrice;

    @Column(name = "delivery_price_usd", precision = 21, scale = 2)
    private BigDecimal deliveryPriceUsd;

    @Column(name = "disc_product_price", precision = 21, scale = 2)
    private BigDecimal discProductPrice;

    @Column(name = "disc_product_price_usd", precision = 21, scale = 2)
    private BigDecimal discProductPriceUsd;

    @Column(name = "disc_delivery_price", precision = 21, scale = 2)
    private BigDecimal discDeliveryPrice;

    @Column(name = "disc_delivery_price_usd", precision = 21, scale = 2)
    private BigDecimal discDeliveryPriceUsd;

    @Column(name = "disc_coupon_price", precision = 21, scale = 2)
    private BigDecimal discCouponPrice;

    @Column(name = "disc_coupon_price_usd", precision = 21, scale = 2)
    private BigDecimal discCouponPriceUsd;

    @Column(name = "service_fee", precision = 21, scale = 2)
    private BigDecimal serviceFee;

    @Column(name = "service_fee_usd", precision = 21, scale = 2)
    private BigDecimal serviceFeeUsd;

    @Column(name = "total_payment", precision = 21, scale = 2)
    private BigDecimal totalPayment;

    @Column(name = "total_payment_usd", precision = 21, scale = 2)
    private BigDecimal totalPaymentUsd;

    @Column(name = "payment_number")
    private String paymentNumber;

    @Column(name = "payment_qr")
    private String paymentQr;

    @Column(name = "payment_link")
    private String paymentLink;

    @Column(name = "payment_status")
    private Boolean paymentStatus;

    @Column(name = "payment_expired")
    private Instant paymentExpired;

    @Column(name = "payment_reference_id")
    private String paymentReferenceId;

    @Column(name = "paided_at")
    private Instant paidedAt;

    @Column(name = "status")
    private String status;

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

    public Transaction id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public Transaction customerId(Long customerId) {
        this.setCustomerId(customerId);
        return this;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCountryId() {
        return this.countryId;
    }

    public Transaction countryId(Long countryId) {
        this.setCountryId(countryId);
        return this;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public Transaction clientId(Long clientId) {
        this.setClientId(clientId);
        return this;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getChannelId() {
        return this.channelId;
    }

    public Transaction channelId(Long channelId) {
        this.setChannelId(channelId);
        return this;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getBrandId() {
        return this.brandId;
    }

    public Transaction brandId(Long brandId) {
        this.setBrandId(brandId);
        return this;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCurrencyId() {
        return this.currencyId;
    }

    public Transaction currencyId(Long currencyId) {
        this.setCurrencyId(currencyId);
        return this;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public Transaction currencyCode(String currencyCode) {
        this.setCurrencyCode(currencyCode);
        return this;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getCurrencyRate() {
        return this.currencyRate;
    }

    public Transaction currencyRate(BigDecimal currencyRate) {
        this.setCurrencyRate(currencyRate);
        return this;
    }

    public void setCurrencyRate(BigDecimal currencyRate) {
        this.currencyRate = currencyRate;
    }

    public Long getPaymentId() {
        return this.paymentId;
    }

    public Transaction paymentId(Long paymentId) {
        this.setPaymentId(paymentId);
        return this;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getCouponCodeId() {
        return this.couponCodeId;
    }

    public Transaction couponCodeId(Long couponCodeId) {
        this.setCouponCodeId(couponCodeId);
        return this;
    }

    public void setCouponCodeId(Long couponCodeId) {
        this.couponCodeId = couponCodeId;
    }

    public String getShopbackReference() {
        return this.shopbackReference;
    }

    public Transaction shopbackReference(String shopbackReference) {
        this.setShopbackReference(shopbackReference);
        return this;
    }

    public void setShopbackReference(String shopbackReference) {
        this.shopbackReference = shopbackReference;
    }

    public String getCode() {
        return this.code;
    }

    public Transaction code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInvoiceCode() {
        return this.invoiceCode;
    }

    public Transaction invoiceCode(String invoiceCode) {
        this.setInvoiceCode(invoiceCode);
        return this;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public BigDecimal getProductPrice() {
        return this.productPrice;
    }

    public Transaction productPrice(BigDecimal productPrice) {
        this.setProductPrice(productPrice);
        return this;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductPriceUsd() {
        return this.productPriceUsd;
    }

    public Transaction productPriceUsd(BigDecimal productPriceUsd) {
        this.setProductPriceUsd(productPriceUsd);
        return this;
    }

    public void setProductPriceUsd(BigDecimal productPriceUsd) {
        this.productPriceUsd = productPriceUsd;
    }

    public BigDecimal getDeliveryPrice() {
        return this.deliveryPrice;
    }

    public Transaction deliveryPrice(BigDecimal deliveryPrice) {
        this.setDeliveryPrice(deliveryPrice);
        return this;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public BigDecimal getDeliveryPriceUsd() {
        return this.deliveryPriceUsd;
    }

    public Transaction deliveryPriceUsd(BigDecimal deliveryPriceUsd) {
        this.setDeliveryPriceUsd(deliveryPriceUsd);
        return this;
    }

    public void setDeliveryPriceUsd(BigDecimal deliveryPriceUsd) {
        this.deliveryPriceUsd = deliveryPriceUsd;
    }

    public BigDecimal getDiscProductPrice() {
        return this.discProductPrice;
    }

    public Transaction discProductPrice(BigDecimal discProductPrice) {
        this.setDiscProductPrice(discProductPrice);
        return this;
    }

    public void setDiscProductPrice(BigDecimal discProductPrice) {
        this.discProductPrice = discProductPrice;
    }

    public BigDecimal getDiscProductPriceUsd() {
        return this.discProductPriceUsd;
    }

    public Transaction discProductPriceUsd(BigDecimal discProductPriceUsd) {
        this.setDiscProductPriceUsd(discProductPriceUsd);
        return this;
    }

    public void setDiscProductPriceUsd(BigDecimal discProductPriceUsd) {
        this.discProductPriceUsd = discProductPriceUsd;
    }

    public BigDecimal getDiscDeliveryPrice() {
        return this.discDeliveryPrice;
    }

    public Transaction discDeliveryPrice(BigDecimal discDeliveryPrice) {
        this.setDiscDeliveryPrice(discDeliveryPrice);
        return this;
    }

    public void setDiscDeliveryPrice(BigDecimal discDeliveryPrice) {
        this.discDeliveryPrice = discDeliveryPrice;
    }

    public BigDecimal getDiscDeliveryPriceUsd() {
        return this.discDeliveryPriceUsd;
    }

    public Transaction discDeliveryPriceUsd(BigDecimal discDeliveryPriceUsd) {
        this.setDiscDeliveryPriceUsd(discDeliveryPriceUsd);
        return this;
    }

    public void setDiscDeliveryPriceUsd(BigDecimal discDeliveryPriceUsd) {
        this.discDeliveryPriceUsd = discDeliveryPriceUsd;
    }

    public BigDecimal getDiscCouponPrice() {
        return this.discCouponPrice;
    }

    public Transaction discCouponPrice(BigDecimal discCouponPrice) {
        this.setDiscCouponPrice(discCouponPrice);
        return this;
    }

    public void setDiscCouponPrice(BigDecimal discCouponPrice) {
        this.discCouponPrice = discCouponPrice;
    }

    public BigDecimal getDiscCouponPriceUsd() {
        return this.discCouponPriceUsd;
    }

    public Transaction discCouponPriceUsd(BigDecimal discCouponPriceUsd) {
        this.setDiscCouponPriceUsd(discCouponPriceUsd);
        return this;
    }

    public void setDiscCouponPriceUsd(BigDecimal discCouponPriceUsd) {
        this.discCouponPriceUsd = discCouponPriceUsd;
    }

    public BigDecimal getServiceFee() {
        return this.serviceFee;
    }

    public Transaction serviceFee(BigDecimal serviceFee) {
        this.setServiceFee(serviceFee);
        return this;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getServiceFeeUsd() {
        return this.serviceFeeUsd;
    }

    public Transaction serviceFeeUsd(BigDecimal serviceFeeUsd) {
        this.setServiceFeeUsd(serviceFeeUsd);
        return this;
    }

    public void setServiceFeeUsd(BigDecimal serviceFeeUsd) {
        this.serviceFeeUsd = serviceFeeUsd;
    }

    public BigDecimal getTotalPayment() {
        return this.totalPayment;
    }

    public Transaction totalPayment(BigDecimal totalPayment) {
        this.setTotalPayment(totalPayment);
        return this;
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }

    public BigDecimal getTotalPaymentUsd() {
        return this.totalPaymentUsd;
    }

    public Transaction totalPaymentUsd(BigDecimal totalPaymentUsd) {
        this.setTotalPaymentUsd(totalPaymentUsd);
        return this;
    }

    public void setTotalPaymentUsd(BigDecimal totalPaymentUsd) {
        this.totalPaymentUsd = totalPaymentUsd;
    }

    public String getPaymentNumber() {
        return this.paymentNumber;
    }

    public Transaction paymentNumber(String paymentNumber) {
        this.setPaymentNumber(paymentNumber);
        return this;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public String getPaymentQr() {
        return this.paymentQr;
    }

    public Transaction paymentQr(String paymentQr) {
        this.setPaymentQr(paymentQr);
        return this;
    }

    public void setPaymentQr(String paymentQr) {
        this.paymentQr = paymentQr;
    }

    public String getPaymentLink() {
        return this.paymentLink;
    }

    public Transaction paymentLink(String paymentLink) {
        this.setPaymentLink(paymentLink);
        return this;
    }

    public void setPaymentLink(String paymentLink) {
        this.paymentLink = paymentLink;
    }

    public Boolean getPaymentStatus() {
        return this.paymentStatus;
    }

    public Transaction paymentStatus(Boolean paymentStatus) {
        this.setPaymentStatus(paymentStatus);
        return this;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Instant getPaymentExpired() {
        return this.paymentExpired;
    }

    public Transaction paymentExpired(Instant paymentExpired) {
        this.setPaymentExpired(paymentExpired);
        return this;
    }

    public void setPaymentExpired(Instant paymentExpired) {
        this.paymentExpired = paymentExpired;
    }

    public String getPaymentReferenceId() {
        return this.paymentReferenceId;
    }

    public Transaction paymentReferenceId(String paymentReferenceId) {
        this.setPaymentReferenceId(paymentReferenceId);
        return this;
    }

    public void setPaymentReferenceId(String paymentReferenceId) {
        this.paymentReferenceId = paymentReferenceId;
    }

    public Instant getPaidedAt() {
        return this.paidedAt;
    }

    public Transaction paidedAt(Instant paidedAt) {
        this.setPaidedAt(paidedAt);
        return this;
    }

    public void setPaidedAt(Instant paidedAt) {
        this.paidedAt = paidedAt;
    }

    public String getStatus() {
        return this.status;
    }

    public Transaction status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Transaction createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public Transaction createdBy(Long createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public Transaction updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public Transaction updatedBy(Long updatedBy) {
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
        if (!(o instanceof Transaction)) {
            return false;
        }
        return getId() != null && getId().equals(((Transaction) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Transaction{" +
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
