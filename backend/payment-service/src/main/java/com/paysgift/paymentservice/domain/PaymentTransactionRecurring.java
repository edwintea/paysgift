package com.paysgift.paymentservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A PaymentTransactionRecurring.
 */
@Entity
@Table(name = "payment_transaction_recurring")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentTransactionRecurring implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "payment_provider_id", nullable = false)
    private Long paymentProviderId;

    @NotNull
    @Column(name = "payment_list_id", nullable = false)
    private Long paymentListId;

    @NotNull
    @Column(name = "payment_transaction_id", nullable = false)
    private Long paymentTransactionId;

    @NotNull
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @NotNull
    @Column(name = "payment_method_id", nullable = false)
    private Long paymentMethodId;

    @NotNull
    @Column(name = "recurring_plan_id", nullable = false)
    private Long recurringPlanId;

    @NotNull
    @Column(name = "cycle_id", nullable = false)
    private Long cycleId;

    @NotNull
    @Column(name = "schedule_id", nullable = false)
    private Long scheduleId;

    @NotNull
    @Column(name = "action_id", nullable = false)
    private Long actionId;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "cycle")
    private Integer cycle;

    @Column(name = "amount", precision = 21, scale = 2)
    private BigDecimal amount;

    @Column(name = "tax", precision = 21, scale = 2)
    private BigDecimal tax;

    @Column(name = "payment_charge", precision = 21, scale = 2)
    private BigDecimal paymentCharge;

    @Column(name = "total", precision = 21, scale = 2)
    private BigDecimal total;

    @Column(name = "datetime_paid")
    private Instant datetimePaid;

    @Column(name = "total_retry")
    private Integer totalRetry;

    @Column(name = "attempt_retry")
    private Integer attemptRetry;

    @Column(name = "datetime_last_retry")
    private Instant datetimeLastRetry;

    @Column(name = "send_callback")
    private Boolean sendCallback;

    @Column(name = "send_callback_attempt")
    private Integer sendCallbackAttempt;

    @Column(name = "payment_schedule")
    private Instant paymentSchedule;

    @Column(name = "payment_link")
    private String paymentLink;

    @Column(name = "reference_id")
    private String referenceId;

    @Column(name = "data_obj")
    private String dataObj;

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

    public PaymentTransactionRecurring id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaymentProviderId() {
        return this.paymentProviderId;
    }

    public PaymentTransactionRecurring paymentProviderId(Long paymentProviderId) {
        this.setPaymentProviderId(paymentProviderId);
        return this;
    }

    public void setPaymentProviderId(Long paymentProviderId) {
        this.paymentProviderId = paymentProviderId;
    }

    public Long getPaymentListId() {
        return this.paymentListId;
    }

    public PaymentTransactionRecurring paymentListId(Long paymentListId) {
        this.setPaymentListId(paymentListId);
        return this;
    }

    public void setPaymentListId(Long paymentListId) {
        this.paymentListId = paymentListId;
    }

    public Long getPaymentTransactionId() {
        return this.paymentTransactionId;
    }

    public PaymentTransactionRecurring paymentTransactionId(Long paymentTransactionId) {
        this.setPaymentTransactionId(paymentTransactionId);
        return this;
    }

    public void setPaymentTransactionId(Long paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public PaymentTransactionRecurring customerId(Long customerId) {
        this.setCustomerId(customerId);
        return this;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getPaymentMethodId() {
        return this.paymentMethodId;
    }

    public PaymentTransactionRecurring paymentMethodId(Long paymentMethodId) {
        this.setPaymentMethodId(paymentMethodId);
        return this;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Long getRecurringPlanId() {
        return this.recurringPlanId;
    }

    public PaymentTransactionRecurring recurringPlanId(Long recurringPlanId) {
        this.setRecurringPlanId(recurringPlanId);
        return this;
    }

    public void setRecurringPlanId(Long recurringPlanId) {
        this.recurringPlanId = recurringPlanId;
    }

    public Long getCycleId() {
        return this.cycleId;
    }

    public PaymentTransactionRecurring cycleId(Long cycleId) {
        this.setCycleId(cycleId);
        return this;
    }

    public void setCycleId(Long cycleId) {
        this.cycleId = cycleId;
    }

    public Long getScheduleId() {
        return this.scheduleId;
    }

    public PaymentTransactionRecurring scheduleId(Long scheduleId) {
        this.setScheduleId(scheduleId);
        return this;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getActionId() {
        return this.actionId;
    }

    public PaymentTransactionRecurring actionId(Long actionId) {
        this.setActionId(actionId);
        return this;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public PaymentTransactionRecurring status(Boolean status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCycle() {
        return this.cycle;
    }

    public PaymentTransactionRecurring cycle(Integer cycle) {
        this.setCycle(cycle);
        return this;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public PaymentTransactionRecurring amount(BigDecimal amount) {
        this.setAmount(amount);
        return this;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTax() {
        return this.tax;
    }

    public PaymentTransactionRecurring tax(BigDecimal tax) {
        this.setTax(tax);
        return this;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getPaymentCharge() {
        return this.paymentCharge;
    }

    public PaymentTransactionRecurring paymentCharge(BigDecimal paymentCharge) {
        this.setPaymentCharge(paymentCharge);
        return this;
    }

    public void setPaymentCharge(BigDecimal paymentCharge) {
        this.paymentCharge = paymentCharge;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public PaymentTransactionRecurring total(BigDecimal total) {
        this.setTotal(total);
        return this;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Instant getDatetimePaid() {
        return this.datetimePaid;
    }

    public PaymentTransactionRecurring datetimePaid(Instant datetimePaid) {
        this.setDatetimePaid(datetimePaid);
        return this;
    }

    public void setDatetimePaid(Instant datetimePaid) {
        this.datetimePaid = datetimePaid;
    }

    public Integer getTotalRetry() {
        return this.totalRetry;
    }

    public PaymentTransactionRecurring totalRetry(Integer totalRetry) {
        this.setTotalRetry(totalRetry);
        return this;
    }

    public void setTotalRetry(Integer totalRetry) {
        this.totalRetry = totalRetry;
    }

    public Integer getAttemptRetry() {
        return this.attemptRetry;
    }

    public PaymentTransactionRecurring attemptRetry(Integer attemptRetry) {
        this.setAttemptRetry(attemptRetry);
        return this;
    }

    public void setAttemptRetry(Integer attemptRetry) {
        this.attemptRetry = attemptRetry;
    }

    public Instant getDatetimeLastRetry() {
        return this.datetimeLastRetry;
    }

    public PaymentTransactionRecurring datetimeLastRetry(Instant datetimeLastRetry) {
        this.setDatetimeLastRetry(datetimeLastRetry);
        return this;
    }

    public void setDatetimeLastRetry(Instant datetimeLastRetry) {
        this.datetimeLastRetry = datetimeLastRetry;
    }

    public Boolean getSendCallback() {
        return this.sendCallback;
    }

    public PaymentTransactionRecurring sendCallback(Boolean sendCallback) {
        this.setSendCallback(sendCallback);
        return this;
    }

    public void setSendCallback(Boolean sendCallback) {
        this.sendCallback = sendCallback;
    }

    public Integer getSendCallbackAttempt() {
        return this.sendCallbackAttempt;
    }

    public PaymentTransactionRecurring sendCallbackAttempt(Integer sendCallbackAttempt) {
        this.setSendCallbackAttempt(sendCallbackAttempt);
        return this;
    }

    public void setSendCallbackAttempt(Integer sendCallbackAttempt) {
        this.sendCallbackAttempt = sendCallbackAttempt;
    }

    public Instant getPaymentSchedule() {
        return this.paymentSchedule;
    }

    public PaymentTransactionRecurring paymentSchedule(Instant paymentSchedule) {
        this.setPaymentSchedule(paymentSchedule);
        return this;
    }

    public void setPaymentSchedule(Instant paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public String getPaymentLink() {
        return this.paymentLink;
    }

    public PaymentTransactionRecurring paymentLink(String paymentLink) {
        this.setPaymentLink(paymentLink);
        return this;
    }

    public void setPaymentLink(String paymentLink) {
        this.paymentLink = paymentLink;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public PaymentTransactionRecurring referenceId(String referenceId) {
        this.setReferenceId(referenceId);
        return this;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getDataObj() {
        return this.dataObj;
    }

    public PaymentTransactionRecurring dataObj(String dataObj) {
        this.setDataObj(dataObj);
        return this;
    }

    public void setDataObj(String dataObj) {
        this.dataObj = dataObj;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public PaymentTransactionRecurring createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public PaymentTransactionRecurring createdBy(Long createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public PaymentTransactionRecurring updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public PaymentTransactionRecurring updatedBy(Long updatedBy) {
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
        if (!(o instanceof PaymentTransactionRecurring)) {
            return false;
        }
        return getId() != null && getId().equals(((PaymentTransactionRecurring) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaymentTransactionRecurring{" +
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
