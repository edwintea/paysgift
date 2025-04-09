package com.paysgift.paymentservice.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.paymentservice.domain.PaymentTransaction} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentTransactionDTO implements Serializable {

    private Long id;

    private String status;

    @NotNull
    private Long paymentProviderId;

    @NotNull
    private Long paymentListId;

    @NotNull
    private Long orderId;

    private String orderNo;

    private String invoiceId;

    private String referenceId;

    @NotNull
    private Long clientId;

    private BigDecimal amount;

    private BigDecimal tax;

    private BigDecimal paymentCharge;

    private BigDecimal total;

    private Boolean expiryRequest;

    private Instant expiryTime;

    private ZonedDateTime expiryLink;

    private Boolean processExpired;

    private String paymentCode;

    private String paymentDeeplink;

    private String paymentObj;

    private String notes;

    private String sgiUid;

    private String customerName;

    private String customerEmail;

    private String customerMobileNumber;

    private Boolean isSubscription;

    private Integer totalRecurring;

    private Integer retryTotal;

    private Integer retryInterval;

    private Integer cycleActive;

    private String mode;

    private String modeInterval;

    private Instant nextPayment;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public Boolean getExpiryRequest() {
        return expiryRequest;
    }

    public void setExpiryRequest(Boolean expiryRequest) {
        this.expiryRequest = expiryRequest;
    }

    public Instant getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Instant expiryTime) {
        this.expiryTime = expiryTime;
    }

    public ZonedDateTime getExpiryLink() {
        return expiryLink;
    }

    public void setExpiryLink(ZonedDateTime expiryLink) {
        this.expiryLink = expiryLink;
    }

    public Boolean getProcessExpired() {
        return processExpired;
    }

    public void setProcessExpired(Boolean processExpired) {
        this.processExpired = processExpired;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getPaymentDeeplink() {
        return paymentDeeplink;
    }

    public void setPaymentDeeplink(String paymentDeeplink) {
        this.paymentDeeplink = paymentDeeplink;
    }

    public String getPaymentObj() {
        return paymentObj;
    }

    public void setPaymentObj(String paymentObj) {
        this.paymentObj = paymentObj;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSgiUid() {
        return sgiUid;
    }

    public void setSgiUid(String sgiUid) {
        this.sgiUid = sgiUid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public Boolean getIsSubscription() {
        return isSubscription;
    }

    public void setIsSubscription(Boolean isSubscription) {
        this.isSubscription = isSubscription;
    }

    public Integer getTotalRecurring() {
        return totalRecurring;
    }

    public void setTotalRecurring(Integer totalRecurring) {
        this.totalRecurring = totalRecurring;
    }

    public Integer getRetryTotal() {
        return retryTotal;
    }

    public void setRetryTotal(Integer retryTotal) {
        this.retryTotal = retryTotal;
    }

    public Integer getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(Integer retryInterval) {
        this.retryInterval = retryInterval;
    }

    public Integer getCycleActive() {
        return cycleActive;
    }

    public void setCycleActive(Integer cycleActive) {
        this.cycleActive = cycleActive;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getModeInterval() {
        return modeInterval;
    }

    public void setModeInterval(String modeInterval) {
        this.modeInterval = modeInterval;
    }

    public Instant getNextPayment() {
        return nextPayment;
    }

    public void setNextPayment(Instant nextPayment) {
        this.nextPayment = nextPayment;
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
        if (!(o instanceof PaymentTransactionDTO)) {
            return false;
        }

        PaymentTransactionDTO paymentTransactionDTO = (PaymentTransactionDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, paymentTransactionDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaymentTransactionDTO{" +
            "id=" + getId() +
            ", status='" + getStatus() + "'" +
            ", paymentProviderId=" + getPaymentProviderId() +
            ", paymentListId=" + getPaymentListId() +
            ", orderId=" + getOrderId() +
            ", orderNo='" + getOrderNo() + "'" +
            ", invoiceId='" + getInvoiceId() + "'" +
            ", referenceId='" + getReferenceId() + "'" +
            ", clientId=" + getClientId() +
            ", amount=" + getAmount() +
            ", tax=" + getTax() +
            ", paymentCharge=" + getPaymentCharge() +
            ", total=" + getTotal() +
            ", expiryRequest='" + getExpiryRequest() + "'" +
            ", expiryTime='" + getExpiryTime() + "'" +
            ", expiryLink='" + getExpiryLink() + "'" +
            ", processExpired='" + getProcessExpired() + "'" +
            ", paymentCode='" + getPaymentCode() + "'" +
            ", paymentDeeplink='" + getPaymentDeeplink() + "'" +
            ", paymentObj='" + getPaymentObj() + "'" +
            ", notes='" + getNotes() + "'" +
            ", sgiUid='" + getSgiUid() + "'" +
            ", customerName='" + getCustomerName() + "'" +
            ", customerEmail='" + getCustomerEmail() + "'" +
            ", customerMobileNumber='" + getCustomerMobileNumber() + "'" +
            ", isSubscription='" + getIsSubscription() + "'" +
            ", totalRecurring=" + getTotalRecurring() +
            ", retryTotal=" + getRetryTotal() +
            ", retryInterval=" + getRetryInterval() +
            ", cycleActive=" + getCycleActive() +
            ", mode='" + getMode() + "'" +
            ", modeInterval='" + getModeInterval() + "'" +
            ", nextPayment='" + getNextPayment() + "'" +
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
