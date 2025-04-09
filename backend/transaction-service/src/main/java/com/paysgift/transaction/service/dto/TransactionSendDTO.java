package com.paysgift.transaction.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.transaction.domain.TransactionSend} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TransactionSendDTO implements Serializable {

    private Long id;

    @NotNull
    private Long transactionId;

    private String code;

    @NotNull
    private String pin;

    @NotNull
    private Long stickerId;

    private String senderName;

    private String message;

    private String sendType;

    private String contactType;

    private String recepientName;

    private String recepientContact;

    private String recepientContactHash;

    private Boolean isImmediately;

    private Instant sendSchedule;

    private String addressLabel;

    @NotNull
    private Long countryId;

    @NotNull
    private Long provinceId;

    @NotNull
    private Long cityId;

    @NotNull
    private Long districtId;

    @NotNull
    private Long villageId;

    private String zipcode;

    private String address;

    private String courierNote;

    private String longitude;

    private String latitude;

    private String referenceId;

    @NotNull
    private String sendBy;

    private BigDecimal deliveryPrice;

    private BigDecimal deliveryPriceUsd;

    private BigDecimal discDeliveryPrice;

    private BigDecimal discDeliveryPriceUsd;

    private BigDecimal totalDeliveryPrice;

    private BigDecimal totalDeliveryPriceUsd;

    private String statusDelivery;

    private String statusReason;

    private String blibliPackageId;

    private Boolean tryOpen;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Long getStickerId() {
        return stickerId;
    }

    public void setStickerId(Long stickerId) {
        this.stickerId = stickerId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getRecepientName() {
        return recepientName;
    }

    public void setRecepientName(String recepientName) {
        this.recepientName = recepientName;
    }

    public String getRecepientContact() {
        return recepientContact;
    }

    public void setRecepientContact(String recepientContact) {
        this.recepientContact = recepientContact;
    }

    public String getRecepientContactHash() {
        return recepientContactHash;
    }

    public void setRecepientContactHash(String recepientContactHash) {
        this.recepientContactHash = recepientContactHash;
    }

    public Boolean getIsImmediately() {
        return isImmediately;
    }

    public void setIsImmediately(Boolean isImmediately) {
        this.isImmediately = isImmediately;
    }

    public Instant getSendSchedule() {
        return sendSchedule;
    }

    public void setSendSchedule(Instant sendSchedule) {
        this.sendSchedule = sendSchedule;
    }

    public String getAddressLabel() {
        return addressLabel;
    }

    public void setAddressLabel(String addressLabel) {
        this.addressLabel = addressLabel;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getVillageId() {
        return villageId;
    }

    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourierNote() {
        return courierNote;
    }

    public void setCourierNote(String courierNote) {
        this.courierNote = courierNote;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getSendBy() {
        return sendBy;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
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

    public BigDecimal getTotalDeliveryPrice() {
        return totalDeliveryPrice;
    }

    public void setTotalDeliveryPrice(BigDecimal totalDeliveryPrice) {
        this.totalDeliveryPrice = totalDeliveryPrice;
    }

    public BigDecimal getTotalDeliveryPriceUsd() {
        return totalDeliveryPriceUsd;
    }

    public void setTotalDeliveryPriceUsd(BigDecimal totalDeliveryPriceUsd) {
        this.totalDeliveryPriceUsd = totalDeliveryPriceUsd;
    }

    public String getStatusDelivery() {
        return statusDelivery;
    }

    public void setStatusDelivery(String statusDelivery) {
        this.statusDelivery = statusDelivery;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public String getBlibliPackageId() {
        return blibliPackageId;
    }

    public void setBlibliPackageId(String blibliPackageId) {
        this.blibliPackageId = blibliPackageId;
    }

    public Boolean getTryOpen() {
        return tryOpen;
    }

    public void setTryOpen(Boolean tryOpen) {
        this.tryOpen = tryOpen;
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
        if (!(o instanceof TransactionSendDTO)) {
            return false;
        }

        TransactionSendDTO transactionSendDTO = (TransactionSendDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, transactionSendDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TransactionSendDTO{" +
            "id=" + getId() +
            ", transactionId=" + getTransactionId() +
            ", code='" + getCode() + "'" +
            ", pin='" + getPin() + "'" +
            ", stickerId=" + getStickerId() +
            ", senderName='" + getSenderName() + "'" +
            ", message='" + getMessage() + "'" +
            ", sendType='" + getSendType() + "'" +
            ", contactType='" + getContactType() + "'" +
            ", recepientName='" + getRecepientName() + "'" +
            ", recepientContact='" + getRecepientContact() + "'" +
            ", recepientContactHash='" + getRecepientContactHash() + "'" +
            ", isImmediately='" + getIsImmediately() + "'" +
            ", sendSchedule='" + getSendSchedule() + "'" +
            ", addressLabel='" + getAddressLabel() + "'" +
            ", countryId=" + getCountryId() +
            ", provinceId=" + getProvinceId() +
            ", cityId=" + getCityId() +
            ", districtId=" + getDistrictId() +
            ", villageId=" + getVillageId() +
            ", zipcode='" + getZipcode() + "'" +
            ", address='" + getAddress() + "'" +
            ", courierNote='" + getCourierNote() + "'" +
            ", longitude='" + getLongitude() + "'" +
            ", latitude='" + getLatitude() + "'" +
            ", referenceId='" + getReferenceId() + "'" +
            ", sendBy='" + getSendBy() + "'" +
            ", deliveryPrice=" + getDeliveryPrice() +
            ", deliveryPriceUsd=" + getDeliveryPriceUsd() +
            ", discDeliveryPrice=" + getDiscDeliveryPrice() +
            ", discDeliveryPriceUsd=" + getDiscDeliveryPriceUsd() +
            ", totalDeliveryPrice=" + getTotalDeliveryPrice() +
            ", totalDeliveryPriceUsd=" + getTotalDeliveryPriceUsd() +
            ", statusDelivery='" + getStatusDelivery() + "'" +
            ", statusReason='" + getStatusReason() + "'" +
            ", blibliPackageId='" + getBlibliPackageId() + "'" +
            ", tryOpen='" + getTryOpen() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            "}";
    }
}
