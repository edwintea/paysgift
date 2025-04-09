package com.paysgift.paymentservice.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.paymentservice.domain.PaymentTransactionRetrying} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentTransactionRetryingDTO implements Serializable {

    private Long id;

    @NotNull
    private Long paymentTransactionRecurringId;

    private String status;

    private Integer attemptRetry;

    private Instant datetimeRetry;

    private Instant datetimeNextRetry;

    private Boolean sendCallback;

    private Integer sendCallbackAttempt;

    private Boolean sendEmail;

    private Integer sendEmailAttempt;

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

    public Long getPaymentTransactionRecurringId() {
        return paymentTransactionRecurringId;
    }

    public void setPaymentTransactionRecurringId(Long paymentTransactionRecurringId) {
        this.paymentTransactionRecurringId = paymentTransactionRecurringId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAttemptRetry() {
        return attemptRetry;
    }

    public void setAttemptRetry(Integer attemptRetry) {
        this.attemptRetry = attemptRetry;
    }

    public Instant getDatetimeRetry() {
        return datetimeRetry;
    }

    public void setDatetimeRetry(Instant datetimeRetry) {
        this.datetimeRetry = datetimeRetry;
    }

    public Instant getDatetimeNextRetry() {
        return datetimeNextRetry;
    }

    public void setDatetimeNextRetry(Instant datetimeNextRetry) {
        this.datetimeNextRetry = datetimeNextRetry;
    }

    public Boolean getSendCallback() {
        return sendCallback;
    }

    public void setSendCallback(Boolean sendCallback) {
        this.sendCallback = sendCallback;
    }

    public Integer getSendCallbackAttempt() {
        return sendCallbackAttempt;
    }

    public void setSendCallbackAttempt(Integer sendCallbackAttempt) {
        this.sendCallbackAttempt = sendCallbackAttempt;
    }

    public Boolean getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(Boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public Integer getSendEmailAttempt() {
        return sendEmailAttempt;
    }

    public void setSendEmailAttempt(Integer sendEmailAttempt) {
        this.sendEmailAttempt = sendEmailAttempt;
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
        if (!(o instanceof PaymentTransactionRetryingDTO)) {
            return false;
        }

        PaymentTransactionRetryingDTO paymentTransactionRetryingDTO = (PaymentTransactionRetryingDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, paymentTransactionRetryingDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaymentTransactionRetryingDTO{" +
            "id=" + getId() +
            ", paymentTransactionRecurringId=" + getPaymentTransactionRecurringId() +
            ", status='" + getStatus() + "'" +
            ", attemptRetry=" + getAttemptRetry() +
            ", datetimeRetry='" + getDatetimeRetry() + "'" +
            ", datetimeNextRetry='" + getDatetimeNextRetry() + "'" +
            ", sendCallback='" + getSendCallback() + "'" +
            ", sendCallbackAttempt=" + getSendCallbackAttempt() +
            ", sendEmail='" + getSendEmail() + "'" +
            ", sendEmailAttempt=" + getSendEmailAttempt() +
            ", createdAt='" + getCreatedAt() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            "}";
    }
}
