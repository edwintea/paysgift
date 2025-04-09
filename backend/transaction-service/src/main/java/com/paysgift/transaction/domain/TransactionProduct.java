package com.paysgift.transaction.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A TransactionProduct.
 */
@Entity
@Table(name = "transaction_product")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TransactionProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "transaction_id", nullable = false)
    private Long transactionId;

    @NotNull
    @Column(name = "transaction_send_id", nullable = false)
    private Long transactionSendId;

    @NotNull
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @NotNull
    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @NotNull
    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    @Column(name = "code")
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

    @Column(name = "image")
    private String image;

    @Column(name = "denom", precision = 21, scale = 2)
    private BigDecimal denom;

    @Column(name = "buying_price", precision = 21, scale = 2)
    private BigDecimal buyingPrice;

    @Column(name = "buying_price_usd", precision = 21, scale = 2)
    private BigDecimal buyingPriceUsd;

    @Column(name = "price", precision = 21, scale = 2)
    private BigDecimal price;

    @Column(name = "price_usd", precision = 21, scale = 2)
    private BigDecimal priceUsd;

    @Column(name = "disc_price", precision = 21, scale = 2)
    private BigDecimal discPrice;

    @Column(name = "disc_price_usd", precision = 21, scale = 2)
    private BigDecimal discPriceUsd;

    @Column(name = "total_price", precision = 21, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "total_price_usd", precision = 21, scale = 2)
    private BigDecimal totalPriceUsd;

    @Column(name = "is_delivery")
    private Boolean isDelivery;

    @Column(name = "payment_status")
    private Boolean paymentStatus;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "is_code")
    private Boolean isCode;

    @Column(name = "voucher_link")
    private String voucherLink;

    @Column(name = "voucher_code")
    private String voucherCode;

    @Column(name = "voucher_pin")
    private String voucherPin;

    @Column(name = "voucher_issuance")
    private String voucherIssuance;

    @Column(name = "voucher_expired")
    private Instant voucherExpired;

    @Column(name = "voucher_reference")
    private String voucherReference;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "error_code")
    private String errorCode;

    @Column(name = "error_reason")
    private String errorReason;

    @Column(name = "retry")
    private Boolean retry;

    @Column(name = "blibli_item_id")
    private Boolean blibliItemId;

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

    public TransactionProduct id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public TransactionProduct transactionId(Long transactionId) {
        this.setTransactionId(transactionId);
        return this;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTransactionSendId() {
        return this.transactionSendId;
    }

    public TransactionProduct transactionSendId(Long transactionSendId) {
        this.setTransactionSendId(transactionSendId);
        return this;
    }

    public void setTransactionSendId(Long transactionSendId) {
        this.transactionSendId = transactionSendId;
    }

    public Long getProductId() {
        return this.productId;
    }

    public TransactionProduct productId(Long productId) {
        this.setProductId(productId);
        return this;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCountryId() {
        return this.countryId;
    }

    public TransactionProduct countryId(Long countryId) {
        this.setCountryId(countryId);
        return this;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getBrandId() {
        return this.brandId;
    }

    public TransactionProduct brandId(Long brandId) {
        this.setBrandId(brandId);
        return this;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getCode() {
        return this.code;
    }

    public TransactionProduct code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public TransactionProduct parentCode(String parentCode) {
        this.setParentCode(parentCode);
        return this;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getSkuCode() {
        return this.skuCode;
    }

    public TransactionProduct skuCode(String skuCode) {
        this.setSkuCode(skuCode);
        return this;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getName() {
        return this.name;
    }

    public TransactionProduct name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return this.nameEn;
    }

    public TransactionProduct nameEn(String nameEn) {
        this.setNameEn(nameEn);
        return this;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getDescription() {
        return this.description;
    }

    public TransactionProduct description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionEn() {
        return this.descriptionEn;
    }

    public TransactionProduct descriptionEn(String descriptionEn) {
        this.setDescriptionEn(descriptionEn);
        return this;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getTnc() {
        return this.tnc;
    }

    public TransactionProduct tnc(String tnc) {
        this.setTnc(tnc);
        return this;
    }

    public void setTnc(String tnc) {
        this.tnc = tnc;
    }

    public String getTncEn() {
        return this.tncEn;
    }

    public TransactionProduct tncEn(String tncEn) {
        this.setTncEn(tncEn);
        return this;
    }

    public void setTncEn(String tncEn) {
        this.tncEn = tncEn;
    }

    public String getHowToClaim() {
        return this.howToClaim;
    }

    public TransactionProduct howToClaim(String howToClaim) {
        this.setHowToClaim(howToClaim);
        return this;
    }

    public void setHowToClaim(String howToClaim) {
        this.howToClaim = howToClaim;
    }

    public String getHowToClaimEn() {
        return this.howToClaimEn;
    }

    public TransactionProduct howToClaimEn(String howToClaimEn) {
        this.setHowToClaimEn(howToClaimEn);
        return this;
    }

    public void setHowToClaimEn(String howToClaimEn) {
        this.howToClaimEn = howToClaimEn;
    }

    public String getImage() {
        return this.image;
    }

    public TransactionProduct image(String image) {
        this.setImage(image);
        return this;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getDenom() {
        return this.denom;
    }

    public TransactionProduct denom(BigDecimal denom) {
        this.setDenom(denom);
        return this;
    }

    public void setDenom(BigDecimal denom) {
        this.denom = denom;
    }

    public BigDecimal getBuyingPrice() {
        return this.buyingPrice;
    }

    public TransactionProduct buyingPrice(BigDecimal buyingPrice) {
        this.setBuyingPrice(buyingPrice);
        return this;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public BigDecimal getBuyingPriceUsd() {
        return this.buyingPriceUsd;
    }

    public TransactionProduct buyingPriceUsd(BigDecimal buyingPriceUsd) {
        this.setBuyingPriceUsd(buyingPriceUsd);
        return this;
    }

    public void setBuyingPriceUsd(BigDecimal buyingPriceUsd) {
        this.buyingPriceUsd = buyingPriceUsd;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public TransactionProduct price(BigDecimal price) {
        this.setPrice(price);
        return this;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceUsd() {
        return this.priceUsd;
    }

    public TransactionProduct priceUsd(BigDecimal priceUsd) {
        this.setPriceUsd(priceUsd);
        return this;
    }

    public void setPriceUsd(BigDecimal priceUsd) {
        this.priceUsd = priceUsd;
    }

    public BigDecimal getDiscPrice() {
        return this.discPrice;
    }

    public TransactionProduct discPrice(BigDecimal discPrice) {
        this.setDiscPrice(discPrice);
        return this;
    }

    public void setDiscPrice(BigDecimal discPrice) {
        this.discPrice = discPrice;
    }

    public BigDecimal getDiscPriceUsd() {
        return this.discPriceUsd;
    }

    public TransactionProduct discPriceUsd(BigDecimal discPriceUsd) {
        this.setDiscPriceUsd(discPriceUsd);
        return this;
    }

    public void setDiscPriceUsd(BigDecimal discPriceUsd) {
        this.discPriceUsd = discPriceUsd;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public TransactionProduct totalPrice(BigDecimal totalPrice) {
        this.setTotalPrice(totalPrice);
        return this;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPriceUsd() {
        return this.totalPriceUsd;
    }

    public TransactionProduct totalPriceUsd(BigDecimal totalPriceUsd) {
        this.setTotalPriceUsd(totalPriceUsd);
        return this;
    }

    public void setTotalPriceUsd(BigDecimal totalPriceUsd) {
        this.totalPriceUsd = totalPriceUsd;
    }

    public Boolean getIsDelivery() {
        return this.isDelivery;
    }

    public TransactionProduct isDelivery(Boolean isDelivery) {
        this.setIsDelivery(isDelivery);
        return this;
    }

    public void setIsDelivery(Boolean isDelivery) {
        this.isDelivery = isDelivery;
    }

    public Boolean getPaymentStatus() {
        return this.paymentStatus;
    }

    public TransactionProduct paymentStatus(Boolean paymentStatus) {
        this.setPaymentStatus(paymentStatus);
        return this;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public TransactionProduct status(Boolean status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getIsCode() {
        return this.isCode;
    }

    public TransactionProduct isCode(Boolean isCode) {
        this.setIsCode(isCode);
        return this;
    }

    public void setIsCode(Boolean isCode) {
        this.isCode = isCode;
    }

    public String getVoucherLink() {
        return this.voucherLink;
    }

    public TransactionProduct voucherLink(String voucherLink) {
        this.setVoucherLink(voucherLink);
        return this;
    }

    public void setVoucherLink(String voucherLink) {
        this.voucherLink = voucherLink;
    }

    public String getVoucherCode() {
        return this.voucherCode;
    }

    public TransactionProduct voucherCode(String voucherCode) {
        this.setVoucherCode(voucherCode);
        return this;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getVoucherPin() {
        return this.voucherPin;
    }

    public TransactionProduct voucherPin(String voucherPin) {
        this.setVoucherPin(voucherPin);
        return this;
    }

    public void setVoucherPin(String voucherPin) {
        this.voucherPin = voucherPin;
    }

    public String getVoucherIssuance() {
        return this.voucherIssuance;
    }

    public TransactionProduct voucherIssuance(String voucherIssuance) {
        this.setVoucherIssuance(voucherIssuance);
        return this;
    }

    public void setVoucherIssuance(String voucherIssuance) {
        this.voucherIssuance = voucherIssuance;
    }

    public Instant getVoucherExpired() {
        return this.voucherExpired;
    }

    public TransactionProduct voucherExpired(Instant voucherExpired) {
        this.setVoucherExpired(voucherExpired);
        return this;
    }

    public void setVoucherExpired(Instant voucherExpired) {
        this.voucherExpired = voucherExpired;
    }

    public String getVoucherReference() {
        return this.voucherReference;
    }

    public TransactionProduct voucherReference(String voucherReference) {
        this.setVoucherReference(voucherReference);
        return this;
    }

    public void setVoucherReference(String voucherReference) {
        this.voucherReference = voucherReference;
    }

    public String getReferenceNumber() {
        return this.referenceNumber;
    }

    public TransactionProduct referenceNumber(String referenceNumber) {
        this.setReferenceNumber(referenceNumber);
        return this;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public TransactionProduct errorCode(String errorCode) {
        this.setErrorCode(errorCode);
        return this;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorReason() {
        return this.errorReason;
    }

    public TransactionProduct errorReason(String errorReason) {
        this.setErrorReason(errorReason);
        return this;
    }

    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    public Boolean getRetry() {
        return this.retry;
    }

    public TransactionProduct retry(Boolean retry) {
        this.setRetry(retry);
        return this;
    }

    public void setRetry(Boolean retry) {
        this.retry = retry;
    }

    public Boolean getBlibliItemId() {
        return this.blibliItemId;
    }

    public TransactionProduct blibliItemId(Boolean blibliItemId) {
        this.setBlibliItemId(blibliItemId);
        return this;
    }

    public void setBlibliItemId(Boolean blibliItemId) {
        this.blibliItemId = blibliItemId;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public TransactionProduct createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public TransactionProduct createdBy(Long createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public TransactionProduct updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public TransactionProduct updatedBy(Long updatedBy) {
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
        if (!(o instanceof TransactionProduct)) {
            return false;
        }
        return getId() != null && getId().equals(((TransactionProduct) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TransactionProduct{" +
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
