package com.paysgift.paymentservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * A PaymentTransactionRetrying.
 */
@Entity
@Table(name = "payment_transaction_retrying")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentTransactionRetrying implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "payment_transaction_recurring_id", nullable = false)
    private Long paymentTransactionRecurringId;

    @Column(name = "status")
    private String status;

    @Column(name = "attempt_retry")
    private Integer attemptRetry;

    @Column(name = "datetime_retry")
    private Instant datetimeRetry;

    @Column(name = "datetime_next_retry")
    private Instant datetimeNextRetry;

    @Column(name = "send_callback")
    private Boolean sendCallback;

    @Column(name = "send_callback_attempt")
    private Integer sendCallbackAttempt;

    @Column(name = "send_email")
    private Boolean sendEmail;

    @Column(name = "send_email_attempt")
    private Integer sendEmailAttempt;

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

    public PaymentTransactionRetrying id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaymentTransactionRecurringId() {
        return this.paymentTransactionRecurringId;
    }

    public PaymentTransactionRetrying paymentTransactionRecurringId(Long paymentTransactionRecurringId) {
        this.setPaymentTransactionRecurringId(paymentTransactionRecurringId);
        return this;
    }

    public void setPaymentTransactionRecurringId(Long paymentTransactionRecurringId) {
        this.paymentTransactionRecurringId = paymentTransactionRecurringId;
    }

    public String getStatus() {
        return this.status;
    }

    public PaymentTransactionRetrying status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAttemptRetry() {
        return this.attemptRetry;
    }

    public PaymentTransactionRetrying attemptRetry(Integer attemptRetry) {
        this.setAttemptRetry(attemptRetry);
        return this;
    }

    public void setAttemptRetry(Integer attemptRetry) {
        this.attemptRetry = attemptRetry;
    }

    public Instant getDatetimeRetry() {
        return this.datetimeRetry;
    }

    public PaymentTransactionRetrying datetimeRetry(Instant datetimeRetry) {
        this.setDatetimeRetry(datetimeRetry);
        return this;
    }

    public void setDatetimeRetry(Instant datetimeRetry) {
        this.datetimeRetry = datetimeRetry;
    }

    public Instant getDatetimeNextRetry() {
        return this.datetimeNextRetry;
    }

    public PaymentTransactionRetrying datetimeNextRetry(Instant datetimeNextRetry) {
        this.setDatetimeNextRetry(datetimeNextRetry);
        return this;
    }

    public void setDatetimeNextRetry(Instant datetimeNextRetry) {
        this.datetimeNextRetry = datetimeNextRetry;
    }

    public Boolean getSendCallback() {
        return this.sendCallback;
    }

    public PaymentTransactionRetrying sendCallback(Boolean sendCallback) {
        this.setSendCallback(sendCallback);
        return this;
    }

    public void setSendCallback(Boolean sendCallback) {
        this.sendCallback = sendCallback;
    }

    public Integer getSendCallbackAttempt() {
        return this.sendCallbackAttempt;
    }

    public PaymentTransactionRetrying sendCallbackAttempt(Integer sendCallbackAttempt) {
        this.setSendCallbackAttempt(sendCallbackAttempt);
        return this;
    }

    public void setSendCallbackAttempt(Integer sendCallbackAttempt) {
        this.sendCallbackAttempt = sendCallbackAttempt;
    }

    public Boolean getSendEmail() {
        return this.sendEmail;
    }

    public PaymentTransactionRetrying sendEmail(Boolean sendEmail) {
        this.setSendEmail(sendEmail);
        return this;
    }

    public void setSendEmail(Boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public Integer getSendEmailAttempt() {
        return this.sendEmailAttempt;
    }

    public PaymentTransactionRetrying sendEmailAttempt(Integer sendEmailAttempt) {
        this.setSendEmailAttempt(sendEmailAttempt);
        return this;
    }

    public void setSendEmailAttempt(Integer sendEmailAttempt) {
        this.sendEmailAttempt = sendEmailAttempt;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public PaymentTransactionRetrying createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public PaymentTransactionRetrying createdBy(Long createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public PaymentTransactionRetrying updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public PaymentTransactionRetrying updatedBy(Long updatedBy) {
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
        if (!(o instanceof PaymentTransactionRetrying)) {
            return false;
        }
        return getId() != null && getId().equals(((PaymentTransactionRetrying) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaymentTransactionRetrying{" +
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
