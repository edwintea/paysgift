package com.paysgift.paymentservice.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.paymentservice.domain.PaymentList} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentListDTO implements Serializable {

    private Long id;

    @NotNull
    private String status;

    private String type;

    private String code;

    private String name;

    @NotNull
    private Long paymentProviderId;

    private BigDecimal paymentFeePercentage;

    private BigDecimal paymentFeeNominal;

    private String paymentNotes;

    private String imageUrl;

    private String howToPay;

    private String note;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPaymentProviderId() {
        return paymentProviderId;
    }

    public void setPaymentProviderId(Long paymentProviderId) {
        this.paymentProviderId = paymentProviderId;
    }

    public BigDecimal getPaymentFeePercentage() {
        return paymentFeePercentage;
    }

    public void setPaymentFeePercentage(BigDecimal paymentFeePercentage) {
        this.paymentFeePercentage = paymentFeePercentage;
    }

    public BigDecimal getPaymentFeeNominal() {
        return paymentFeeNominal;
    }

    public void setPaymentFeeNominal(BigDecimal paymentFeeNominal) {
        this.paymentFeeNominal = paymentFeeNominal;
    }

    public String getPaymentNotes() {
        return paymentNotes;
    }

    public void setPaymentNotes(String paymentNotes) {
        this.paymentNotes = paymentNotes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHowToPay() {
        return howToPay;
    }

    public void setHowToPay(String howToPay) {
        this.howToPay = howToPay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        if (!(o instanceof PaymentListDTO)) {
            return false;
        }

        PaymentListDTO paymentListDTO = (PaymentListDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, paymentListDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaymentListDTO{" +
            "id=" + getId() +
            ", status='" + getStatus() + "'" +
            ", type='" + getType() + "'" +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", paymentProviderId=" + getPaymentProviderId() +
            ", paymentFeePercentage=" + getPaymentFeePercentage() +
            ", paymentFeeNominal=" + getPaymentFeeNominal() +
            ", paymentNotes='" + getPaymentNotes() + "'" +
            ", imageUrl='" + getImageUrl() + "'" +
            ", howToPay='" + getHowToPay() + "'" +
            ", note='" + getNote() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            "}";
    }
}
