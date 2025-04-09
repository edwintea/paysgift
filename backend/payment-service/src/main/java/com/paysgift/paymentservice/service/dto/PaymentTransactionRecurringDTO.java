package com.paysgift.paymentservice.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.paymentservice.domain.PaymentTransactionRecurring} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentTransactionRecurringDTO implements Serializable {

    private Long id;

    @NotNull
    private Long paymentProviderId;

    @NotNull
    private Long paymentListId;

    @NotNull
    private Long paymentTransactionId;

    @NotNull
    private Long customerId;

    @NotNull
    private Long paymentMethodId;

    @NotNull
    private Long recurringPlanId;

    @NotNull
    private Long cycleId;

    @NotNull
    private Long scheduleId;

    @NotNull
    private Long actionId;

    private Boolean status;

    private Integer cycle;

    private BigDecimal amount;

    private BigDecimal tax;

    private BigDecimal paymentCharge;

    private BigDecimal total;

    private Instant datetimePaid;

    private Integer totalRetry;

    private Integer attemptRetry;

    private Instant datetimeLastRetry;

    private Boolean sendCallback;

    private Integer sendCallbackAttempt;

    private Instant paymentSchedule;

    private String paymentLink;

    private String referenceId;

    private String dataObj;

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

    public Long getPaymentProviderId() {
        return paymentProviderId;
    }

    public void setPaymentProviderId(Long paymentProviderId) {
        this.paymentProviderId = paymentProviderId;
    }

    public Long getPaymentListId() {
        return paymentListId;
    }

    public void setPaymentListId(Long paymentListId) {
        this.paymentListId = paymentListId;
    }

    public Long getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public void setPaymentTransactionId(Long paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Long getRecurringPlanId() {
        return recurringPlanId;
    }

    public void setRecurringPlanId(Long recurringPlanId) {
        this.recurringPlanId = recurringPlanId;
    }

    public Long getCycleId() {
        return cycleId;
    }

    public void setCycleId(Long cycleId) {
        this.cycleId = cycleId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getPaymentCharge() {
        return paymentCharge;
    }

    public void setPaymentCharge(BigDecimal paymentCharge) {
        this.paymentCharge = paymentCharge;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Instant getDatetimePaid() {
        return datetimePaid;
    }

    public void setDatetimePaid(Instant datetimePaid) {
        this.datetimePaid = datetimePaid;
    }

    public Integer getTotalRetry() {
        return totalRetry;
    }

    public void setTotalRetry(Integer totalRetry) {
        this.totalRetry = totalRetry;
    }

    public Integer getAttemptRetry() {
        return attemptRetry;
    }

    public void setAttemptRetry(Integer attemptRetry) {
        this.attemptRetry = attemptRetry;
    }

    public Instant getDatetimeLastRetry() {
        return datetimeLastRetry;
    }

    public void setDatetimeLastRetry(Instant datetimeLastRetry) {
        this.datetimeLastRetry = datetimeLastRetry;
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

    public Instant getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setPaymentSchedule(Instant paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public String getPaymentLink() {
        return paymentLink;
    }

    public void setPaymentLink(String paymentLink) {
        this.paymentLink = paymentLink;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getDataObj() {
        return dataObj;
    }

    public void setDataObj(String dataObj) {
        this.dataObj = dataObj;
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
        if (!(o instanceof PaymentTransactionRecurringDTO)) {
            return false;
        }

        PaymentTransactionRecurringDTO paymentTransactionRecurringDTO = (PaymentTransactionRecurringDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, paymentTransactionRecurringDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaymentTransactionRecurringDTO{" +
            "id=" + getId() +
            ", paymentProviderId=" + getPaymentProviderId() +
            ", paymentListId=" + getPaymentListId() +
            ", paymentTransactionId=" + getPaymentTransactionId() +
            ", customerId=" + getCustomerId() +
            ", paymentMethodId=" + getPaymentMethodId() +
            ", recurringPlanId=" + getRecurringPlanId() +
            ", cycleId=" + getCycleId() +
            ", scheduleId=" + getScheduleId() +
            ", actionId=" + getActionId() +
            ", status='" + getStatus() + "'" +
            ", cycle=" + getCycle() +
            ", amount=" + getAmount() +
            ", tax=" + getTax() +
            ", paymentCharge=" + getPaymentCharge() +
            ", total=" + getTotal() +
            ", datetimePaid='" + getDatetimePaid() + "'" +
            ", totalRetry=" + getTotalRetry() +
            ", attemptRetry=" + getAttemptRetry() +
            ", datetimeLastRetry='" + getDatetimeLastRetry() + "'" +
            ", sendCallback='" + getSendCallback() + "'" +
            ", sendCallbackAttempt=" + getSendCallbackAttempt() +
            ", paymentSchedule='" + getPaymentSchedule() + "'" +
            ", paymentLink='" + getPaymentLink() + "'" +
            ", referenceId='" + getReferenceId() + "'" +
            ", dataObj='" + getDataObj() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            "}";
    }
}
