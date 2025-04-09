package com.paysgift.paymentservice.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.paymentservice.domain.PaymentTransactionCampaign} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentTransactionCampaignDTO implements Serializable {

    private Long id;

    @NotNull
    private Long paymentTransactionId;

    private Integer cycle;

    private Instant hitDatetime;

    private Boolean hitStatus;

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

    public Long getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public void setPaymentTransactionId(Long paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public Instant getHitDatetime() {
        return hitDatetime;
    }

    public void setHitDatetime(Instant hitDatetime) {
        this.hitDatetime = hitDatetime;
    }

    public Boolean getHitStatus() {
        return hitStatus;
    }

    public void setHitStatus(Boolean hitStatus) {
        this.hitStatus = hitStatus;
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
        if (!(o instanceof PaymentTransactionCampaignDTO)) {
            return false;
        }

        PaymentTransactionCampaignDTO paymentTransactionCampaignDTO = (PaymentTransactionCampaignDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, paymentTransactionCampaignDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaymentTransactionCampaignDTO{" +
            "id=" + getId() +
            ", paymentTransactionId=" + getPaymentTransactionId() +
            ", cycle=" + getCycle() +
            ", hitDatetime='" + getHitDatetime() + "'" +
            ", hitStatus='" + getHitStatus() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            "}";
    }
}
