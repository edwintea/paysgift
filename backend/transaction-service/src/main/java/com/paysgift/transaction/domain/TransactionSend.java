package com.paysgift.transaction.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A TransactionSend.
 */
@Entity
@Table(name = "transaction_send")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TransactionSend implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "transaction_id", nullable = false)
    private Long transactionId;

    @Column(name = "code")
    private String code;

    @NotNull
    @Column(name = "pin", nullable = false)
    private String pin;

    @NotNull
    @Column(name = "sticker_id", nullable = false)
    private Long stickerId;

    @Column(name = "sender_name")
    private String senderName;

    @Column(name = "message")
    private String message;

    @Column(name = "send_type")
    private String sendType;

    @Column(name = "contact_type")
    private String contactType;

    @Column(name = "recepient_name")
    private String recepientName;

    @Column(name = "recepient_contact")
    private String recepientContact;

    @Column(name = "recepient_contact_hash")
    private String recepientContactHash;

    @Column(name = "is_immediately")
    private Boolean isImmediately;

    @Column(name = "send_schedule")
    private Instant sendSchedule;

    @Column(name = "address_label")
    private String addressLabel;

    @NotNull
    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @NotNull
    @Column(name = "province_id", nullable = false)
    private Long provinceId;

    @NotNull
    @Column(name = "city_id", nullable = false)
    private Long cityId;

    @NotNull
    @Column(name = "district_id", nullable = false)
    private Long districtId;

    @NotNull
    @Column(name = "village_id", nullable = false)
    private Long villageId;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "address")
    private String address;

    @Column(name = "courier_note")
    private String courierNote;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "reference_id")
    private String referenceId;

    @NotNull
    @Column(name = "send_by", nullable = false)
    private String sendBy;

    @Column(name = "delivery_price", precision = 21, scale = 2)
    private BigDecimal deliveryPrice;

    @Column(name = "delivery_price_usd", precision = 21, scale = 2)
    private BigDecimal deliveryPriceUsd;

    @Column(name = "disc_delivery_price", precision = 21, scale = 2)
    private BigDecimal discDeliveryPrice;

    @Column(name = "disc_delivery_price_usd", precision = 21, scale = 2)
    private BigDecimal discDeliveryPriceUsd;

    @Column(name = "total_delivery_price", precision = 21, scale = 2)
    private BigDecimal totalDeliveryPrice;

    @Column(name = "total_delivery_price_usd", precision = 21, scale = 2)
    private BigDecimal totalDeliveryPriceUsd;

    @Column(name = "status_delivery")
    private String statusDelivery;

    @Column(name = "status_reason")
    private String statusReason;

    @Column(name = "blibli_package_id")
    private String blibliPackageId;

    @Column(name = "try_open")
    private Boolean tryOpen;

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

    public TransactionSend id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public TransactionSend transactionId(Long transactionId) {
        this.setTransactionId(transactionId);
        return this;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getCode() {
        return this.code;
    }

    public TransactionSend code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPin() {
        return this.pin;
    }

    public TransactionSend pin(String pin) {
        this.setPin(pin);
        return this;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Long getStickerId() {
        return this.stickerId;
    }

    public TransactionSend stickerId(Long stickerId) {
        this.setStickerId(stickerId);
        return this;
    }

    public void setStickerId(Long stickerId) {
        this.stickerId = stickerId;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public TransactionSend senderName(String senderName) {
        this.setSenderName(senderName);
        return this;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessage() {
        return this.message;
    }

    public TransactionSend message(String message) {
        this.setMessage(message);
        return this;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendType() {
        return this.sendType;
    }

    public TransactionSend sendType(String sendType) {
        this.setSendType(sendType);
        return this;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getContactType() {
        return this.contactType;
    }

    public TransactionSend contactType(String contactType) {
        this.setContactType(contactType);
        return this;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getRecepientName() {
        return this.recepientName;
    }

    public TransactionSend recepientName(String recepientName) {
        this.setRecepientName(recepientName);
        return this;
    }

    public void setRecepientName(String recepientName) {
        this.recepientName = recepientName;
    }

    public String getRecepientContact() {
        return this.recepientContact;
    }

    public TransactionSend recepientContact(String recepientContact) {
        this.setRecepientContact(recepientContact);
        return this;
    }

    public void setRecepientContact(String recepientContact) {
        this.recepientContact = recepientContact;
    }

    public String getRecepientContactHash() {
        return this.recepientContactHash;
    }

    public TransactionSend recepientContactHash(String recepientContactHash) {
        this.setRecepientContactHash(recepientContactHash);
        return this;
    }

    public void setRecepientContactHash(String recepientContactHash) {
        this.recepientContactHash = recepientContactHash;
    }

    public Boolean getIsImmediately() {
        return this.isImmediately;
    }

    public TransactionSend isImmediately(Boolean isImmediately) {
        this.setIsImmediately(isImmediately);
        return this;
    }

    public void setIsImmediately(Boolean isImmediately) {
        this.isImmediately = isImmediately;
    }

    public Instant getSendSchedule() {
        return this.sendSchedule;
    }

    public TransactionSend sendSchedule(Instant sendSchedule) {
        this.setSendSchedule(sendSchedule);
        return this;
    }

    public void setSendSchedule(Instant sendSchedule) {
        this.sendSchedule = sendSchedule;
    }

    public String getAddressLabel() {
        return this.addressLabel;
    }

    public TransactionSend addressLabel(String addressLabel) {
        this.setAddressLabel(addressLabel);
        return this;
    }

    public void setAddressLabel(String addressLabel) {
        this.addressLabel = addressLabel;
    }

    public Long getCountryId() {
        return this.countryId;
    }

    public TransactionSend countryId(Long countryId) {
        this.setCountryId(countryId);
        return this;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getProvinceId() {
        return this.provinceId;
    }

    public TransactionSend provinceId(Long provinceId) {
        this.setProvinceId(provinceId);
        return this;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return this.cityId;
    }

    public TransactionSend cityId(Long cityId) {
        this.setCityId(cityId);
        return this;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getDistrictId() {
        return this.districtId;
    }

    public TransactionSend districtId(Long districtId) {
        this.setDistrictId(districtId);
        return this;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getVillageId() {
        return this.villageId;
    }

    public TransactionSend villageId(Long villageId) {
        this.setVillageId(villageId);
        return this;
    }

    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public TransactionSend zipcode(String zipcode) {
        this.setZipcode(zipcode);
        return this;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return this.address;
    }

    public TransactionSend address(String address) {
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourierNote() {
        return this.courierNote;
    }

    public TransactionSend courierNote(String courierNote) {
        this.setCourierNote(courierNote);
        return this;
    }

    public void setCourierNote(String courierNote) {
        this.courierNote = courierNote;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public TransactionSend longitude(String longitude) {
        this.setLongitude(longitude);
        return this;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public TransactionSend latitude(String latitude) {
        this.setLatitude(latitude);
        return this;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public TransactionSend referenceId(String referenceId) {
        this.setReferenceId(referenceId);
        return this;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getSendBy() {
        return this.sendBy;
    }

    public TransactionSend sendBy(String sendBy) {
        this.setSendBy(sendBy);
        return this;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }

    public BigDecimal getDeliveryPrice() {
        return this.deliveryPrice;
    }

    public TransactionSend deliveryPrice(BigDecimal deliveryPrice) {
        this.setDeliveryPrice(deliveryPrice);
        return this;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public BigDecimal getDeliveryPriceUsd() {
        return this.deliveryPriceUsd;
    }

    public TransactionSend deliveryPriceUsd(BigDecimal deliveryPriceUsd) {
        this.setDeliveryPriceUsd(deliveryPriceUsd);
        return this;
    }

    public void setDeliveryPriceUsd(BigDecimal deliveryPriceUsd) {
        this.deliveryPriceUsd = deliveryPriceUsd;
    }

    public BigDecimal getDiscDeliveryPrice() {
        return this.discDeliveryPrice;
    }

    public TransactionSend discDeliveryPrice(BigDecimal discDeliveryPrice) {
        this.setDiscDeliveryPrice(discDeliveryPrice);
        return this;
    }

    public void setDiscDeliveryPrice(BigDecimal discDeliveryPrice) {
        this.discDeliveryPrice = discDeliveryPrice;
    }

    public BigDecimal getDiscDeliveryPriceUsd() {
        return this.discDeliveryPriceUsd;
    }

    public TransactionSend discDeliveryPriceUsd(BigDecimal discDeliveryPriceUsd) {
        this.setDiscDeliveryPriceUsd(discDeliveryPriceUsd);
        return this;
    }

    public void setDiscDeliveryPriceUsd(BigDecimal discDeliveryPriceUsd) {
        this.discDeliveryPriceUsd = discDeliveryPriceUsd;
    }

    public BigDecimal getTotalDeliveryPrice() {
        return this.totalDeliveryPrice;
    }

    public TransactionSend totalDeliveryPrice(BigDecimal totalDeliveryPrice) {
        this.setTotalDeliveryPrice(totalDeliveryPrice);
        return this;
    }

    public void setTotalDeliveryPrice(BigDecimal totalDeliveryPrice) {
        this.totalDeliveryPrice = totalDeliveryPrice;
    }

    public BigDecimal getTotalDeliveryPriceUsd() {
        return this.totalDeliveryPriceUsd;
    }

    public TransactionSend totalDeliveryPriceUsd(BigDecimal totalDeliveryPriceUsd) {
        this.setTotalDeliveryPriceUsd(totalDeliveryPriceUsd);
        return this;
    }

    public void setTotalDeliveryPriceUsd(BigDecimal totalDeliveryPriceUsd) {
        this.totalDeliveryPriceUsd = totalDeliveryPriceUsd;
    }

    public String getStatusDelivery() {
        return this.statusDelivery;
    }

    public TransactionSend statusDelivery(String statusDelivery) {
        this.setStatusDelivery(statusDelivery);
        return this;
    }

    public void setStatusDelivery(String statusDelivery) {
        this.statusDelivery = statusDelivery;
    }

    public String getStatusReason() {
        return this.statusReason;
    }

    public TransactionSend statusReason(String statusReason) {
        this.setStatusReason(statusReason);
        return this;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public String getBlibliPackageId() {
        return this.blibliPackageId;
    }

    public TransactionSend blibliPackageId(String blibliPackageId) {
        this.setBlibliPackageId(blibliPackageId);
        return this;
    }

    public void setBlibliPackageId(String blibliPackageId) {
        this.blibliPackageId = blibliPackageId;
    }

    public Boolean getTryOpen() {
        return this.tryOpen;
    }

    public TransactionSend tryOpen(Boolean tryOpen) {
        this.setTryOpen(tryOpen);
        return this;
    }

    public void setTryOpen(Boolean tryOpen) {
        this.tryOpen = tryOpen;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public TransactionSend createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public TransactionSend createdBy(Long createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public TransactionSend updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public TransactionSend updatedBy(Long updatedBy) {
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
        if (!(o instanceof TransactionSend)) {
            return false;
        }
        return getId() != null && getId().equals(((TransactionSend) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TransactionSend{" +
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
