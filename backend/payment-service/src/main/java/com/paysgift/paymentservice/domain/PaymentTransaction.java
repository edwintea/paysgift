package com.paysgift.paymentservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * A PaymentTransaction.
 */
@Entity
@Table(name = "payment_transaction")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private String status;

    @NotNull
    @Column(name = "payment_provider_id", nullable = false)
    private Long paymentProviderId;

    @NotNull
    @Column(name = "payment_list_id", nullable = false)
    private Long paymentListId;

    @NotNull
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "order_no")
    private String orderNo;

    @Column(name = "invoice_id")
    private String invoiceId;

    @Column(name = "reference_id")
    private String referenceId;

    @NotNull
    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "amount", precision = 21, scale = 2)
    private BigDecimal amount;

    @Column(name = "tax", precision = 21, scale = 2)
    private BigDecimal tax;

    @Column(name = "payment_charge", precision = 21, scale = 2)
    private BigDecimal paymentCharge;

    @Column(name = "total", precision = 21, scale = 2)
    private BigDecimal total;

    @Column(name = "expiry_request")
    private Boolean expiryRequest;

    @Column(name = "expiry_time")
    private Instant expiryTime;

    @Column(name = "expiry_link")
    private ZonedDateTime expiryLink;

    @Column(name = "process_expired")
    private Boolean processExpired;

    @Column(name = "payment_code")
    private String paymentCode;

    @Column(name = "payment_deeplink")
    private String paymentDeeplink;

    @Column(name = "payment_obj")
    private String paymentObj;

    @Column(name = "notes")
    private String notes;

    @Column(name = "sgi_uid")
    private String sgiUid;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_mobile_number")
    private String customerMobileNumber;

    @Column(name = "is_subscription")
    private Boolean isSubscription;

    @Column(name = "total_recurring")
    private Integer totalRecurring;

    @Column(name = "retry_total")
    private Integer retryTotal;

    @Column(name = "retry_interval")
    private Integer retryInterval;

    @Column(name = "cycle_active")
    private Integer cycleActive;

    @Column(name = "mode")
    private String mode;

    @Column(name = "mode_interval")
    private String modeInterval;

    @Column(name = "next_payment")
    private Instant nextPayment;

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

    public PaymentTransaction id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public PaymentTransaction status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPaymentProviderId() {
        return this.paymentProviderId;
    }

    public PaymentTransaction paymentProviderId(Long paymentProviderId) {
        this.setPaymentProviderId(paymentProviderId);
        return this;
    }

    public void setPaymentProviderId(Long paymentProviderId) {
        this.paymentProviderId = paymentProviderId;
    }

    public Long getPaymentListId() {
        return this.paymentListId;
    }

    public PaymentTransaction paymentListId(Long paymentListId) {
        this.setPaymentListId(paymentListId);
        return this;
    }

    public void setPaymentListId(Long paymentListId) {
        this.paymentListId = paymentListId;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public PaymentTransaction orderId(Long orderId) {
        this.setOrderId(orderId);
        return this;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public PaymentTransaction orderNo(String orderNo) {
        this.setOrderNo(orderNo);
        return this;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getInvoiceId() {
        return this.invoiceId;
    }

    public PaymentTransaction invoiceId(String invoiceId) {
        this.setInvoiceId(invoiceId);
        return this;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public PaymentTransaction referenceId(String referenceId) {
        this.setReferenceId(referenceId);
        return this;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public PaymentTransaction clientId(Long clientId) {
        this.setClientId(clientId);
        return this;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public PaymentTransaction amount(BigDecimal amount) {
        this.setAmount(amount);
        return this;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTax() {
        return this.tax;
    }

    public PaymentTransaction tax(BigDecimal tax) {
        this.setTax(tax);
        return this;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getPaymentCharge() {
        return this.paymentCharge;
    }

    public PaymentTransaction paymentCharge(BigDecimal paymentCharge) {
        this.setPaymentCharge(paymentCharge);
        return this;
    }

    public void setPaymentCharge(BigDecimal paymentCharge) {
        this.paymentCharge = paymentCharge;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public PaymentTransaction total(BigDecimal total) {
        this.setTotal(total);
        return this;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getExpiryRequest() {
        return this.expiryRequest;
    }

    public PaymentTransaction expiryRequest(Boolean expiryRequest) {
        this.setExpiryRequest(expiryRequest);
        return this;
    }

    public void setExpiryRequest(Boolean expiryRequest) {
        this.expiryRequest = expiryRequest;
    }

    public Instant getExpiryTime() {
        return this.expiryTime;
    }

    public PaymentTransaction expiryTime(Instant expiryTime) {
        this.setExpiryTime(expiryTime);
        return this;
    }

    public void setExpiryTime(Instant expiryTime) {
        this.expiryTime = expiryTime;
    }

    public ZonedDateTime getExpiryLink() {
        return this.expiryLink;
    }

    public PaymentTransaction expiryLink(ZonedDateTime expiryLink) {
        this.setExpiryLink(expiryLink);
        return this;
    }

    public void setExpiryLink(ZonedDateTime expiryLink) {
        this.expiryLink = expiryLink;
    }

    public Boolean getProcessExpired() {
        return this.processExpired;
    }

    public PaymentTransaction processExpired(Boolean processExpired) {
        this.setProcessExpired(processExpired);
        return this;
    }

    public void setProcessExpired(Boolean processExpired) {
        this.processExpired = processExpired;
    }

    public String getPaymentCode() {
        return this.paymentCode;
    }

    public PaymentTransaction paymentCode(String paymentCode) {
        this.setPaymentCode(paymentCode);
        return this;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getPaymentDeeplink() {
        return this.paymentDeeplink;
    }

    public PaymentTransaction paymentDeeplink(String paymentDeeplink) {
        this.setPaymentDeeplink(paymentDeeplink);
        return this;
    }

    public void setPaymentDeeplink(String paymentDeeplink) {
        this.paymentDeeplink = paymentDeeplink;
    }

    public String getPaymentObj() {
        return this.paymentObj;
    }

    public PaymentTransaction paymentObj(String paymentObj) {
        this.setPaymentObj(paymentObj);
        return this;
    }

    public void setPaymentObj(String paymentObj) {
        this.paymentObj = paymentObj;
    }

    public String getNotes() {
        return this.notes;
    }

    public PaymentTransaction notes(String notes) {
        this.setNotes(notes);
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSgiUid() {
        return this.sgiUid;
    }

    public PaymentTransaction sgiUid(String sgiUid) {
        this.setSgiUid(sgiUid);
        return this;
    }

    public void setSgiUid(String sgiUid) {
        this.sgiUid = sgiUid;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public PaymentTransaction customerName(String customerName) {
        this.setCustomerName(customerName);
        return this;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public PaymentTransaction customerEmail(String customerEmail) {
        this.setCustomerEmail(customerEmail);
        return this;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerMobileNumber() {
        return this.customerMobileNumber;
    }

    public PaymentTransaction customerMobileNumber(String customerMobileNumber) {
        this.setCustomerMobileNumber(customerMobileNumber);
        return this;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public Boolean getIsSubscription() {
        return this.isSubscription;
    }

    public PaymentTransaction isSubscription(Boolean isSubscription) {
        this.setIsSubscription(isSubscription);
        return this;
    }

    public void setIsSubscription(Boolean isSubscription) {
        this.isSubscription = isSubscription;
    }

    public Integer getTotalRecurring() {
        return this.totalRecurring;
    }

    public PaymentTransaction totalRecurring(Integer totalRecurring) {
        this.setTotalRecurring(totalRecurring);
        return this;
    }

    public void setTotalRecurring(Integer totalRecurring) {
        this.totalRecurring = totalRecurring;
    }

    public Integer getRetryTotal() {
        return this.retryTotal;
    }

    public PaymentTransaction retryTotal(Integer retryTotal) {
        this.setRetryTotal(retryTotal);
        return this;
    }

    public void setRetryTotal(Integer retryTotal) {
        this.retryTotal = retryTotal;
    }

    public Integer getRetryInterval() {
        return this.retryInterval;
    }

    public PaymentTransaction retryInterval(Integer retryInterval) {
        this.setRetryInterval(retryInterval);
        return this;
    }

    public void setRetryInterval(Integer retryInterval) {
        this.retryInterval = retryInterval;
    }

    public Integer getCycleActive() {
        return this.cycleActive;
    }

    public PaymentTransaction cycleActive(Integer cycleActive) {
        this.setCycleActive(cycleActive);
        return this;
    }

    public void setCycleActive(Integer cycleActive) {
        this.cycleActive = cycleActive;
    }

    public String getMode() {
        return this.mode;
    }

    public PaymentTransaction mode(String mode) {
        this.setMode(mode);
        return this;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getModeInterval() {
        return this.modeInterval;
    }

    public PaymentTransaction modeInterval(String modeInterval) {
        this.setModeInterval(modeInterval);
        return this;
    }

    public void setModeInterval(String modeInterval) {
        this.modeInterval = modeInterval;
    }

    public Instant getNextPayment() {
        return this.nextPayment;
    }

    public PaymentTransaction nextPayment(Instant nextPayment) {
        this.setNextPayment(nextPayment);
        return this;
    }

    public void setNextPayment(Instant nextPayment) {
        this.nextPayment = nextPayment;
    }

    public Boolean getSendCallback() {
        return this.sendCallback;
    }

    public PaymentTransaction sendCallback(Boolean sendCallback) {
        this.setSendCallback(sendCallback);
        return this;
    }

    public void setSendCallback(Boolean sendCallback) {
        this.sendCallback = sendCallback;
    }

    public Integer getSendCallbackAttempt() {
        return this.sendCallbackAttempt;
    }

    public PaymentTransaction sendCallbackAttempt(Integer sendCallbackAttempt) {
        this.setSendCallbackAttempt(sendCallbackAttempt);
        return this;
    }

    public void setSendCallbackAttempt(Integer sendCallbackAttempt) {
        this.sendCallbackAttempt = sendCallbackAttempt;
    }

    public Boolean getSendEmail() {
        return this.sendEmail;
    }

    public PaymentTransaction sendEmail(Boolean sendEmail) {
        this.setSendEmail(sendEmail);
        return this;
    }

    public void setSendEmail(Boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public Integer getSendEmailAttempt() {
        return this.sendEmailAttempt;
    }

    public PaymentTransaction sendEmailAttempt(Integer sendEmailAttempt) {
        this.setSendEmailAttempt(sendEmailAttempt);
        return this;
    }

    public void setSendEmailAttempt(Integer sendEmailAttempt) {
        this.sendEmailAttempt = sendEmailAttempt;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public PaymentTransaction createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public PaymentTransaction createdBy(Long createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public PaymentTransaction updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public PaymentTransaction updatedBy(Long updatedBy) {
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
        if (!(o instanceof PaymentTransaction)) {
            return false;
        }
        return getId() != null && getId().equals(((PaymentTransaction) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaymentTransaction{" +
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
