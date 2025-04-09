package com.paysgift.paymentservice.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DanaOrder.
 */
@Entity
@Table(name = "dana_order")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DanaOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "version")
    private String version;

    @Column(name = "function_name")
    private String functionName;

    @Column(name = "req_time")
    private Instant reqTime;

    @Column(name = "resp_time")
    private Instant respTime;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "req_msg_id")
    private String reqMsgId;

    @Column(name = "request_id")
    private String requestId;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "code")
    private String code;

    @Column(name = "status")
    private String status;

    @Column(name = "message")
    private String message;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "issuance_id")
    private String issuanceId;

    @Column(name = "voucher_code")
    private String voucherCode;

    @Column(name = "voucher_pin")
    private String voucherPin;

    @Column(name = "issuance_date")
    private Instant issuanceDate;

    @Column(name = "expired_date")
    private Instant expiredDate;

    @Column(name = "extend_info")
    private String extendInfo;

    @Column(name = "send_email_notif")
    private Instant sendEmailNotif;

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

    public DanaOrder id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return this.version;
    }

    public DanaOrder version(String version) {
        this.setVersion(version);
        return this;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public DanaOrder functionName(String functionName) {
        this.setFunctionName(functionName);
        return this;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public Instant getReqTime() {
        return this.reqTime;
    }

    public DanaOrder reqTime(Instant reqTime) {
        this.setReqTime(reqTime);
        return this;
    }

    public void setReqTime(Instant reqTime) {
        this.reqTime = reqTime;
    }

    public Instant getRespTime() {
        return this.respTime;
    }

    public DanaOrder respTime(Instant respTime) {
        this.setRespTime(respTime);
        return this;
    }

    public void setRespTime(Instant respTime) {
        this.respTime = respTime;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public DanaOrder isActive(Boolean isActive) {
        this.setIsActive(isActive);
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getReqMsgId() {
        return this.reqMsgId;
    }

    public DanaOrder reqMsgId(String reqMsgId) {
        this.setReqMsgId(reqMsgId);
        return this;
    }

    public void setReqMsgId(String reqMsgId) {
        this.reqMsgId = reqMsgId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public DanaOrder requestId(String requestId) {
        this.setRequestId(requestId);
        return this;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public DanaOrder orderId(String orderId) {
        this.setOrderId(orderId);
        return this;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCode() {
        return this.code;
    }

    public DanaOrder code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return this.status;
    }

    public DanaOrder status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public DanaOrder message(String message) {
        this.setMessage(message);
        return this;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProductId() {
        return this.productId;
    }

    public DanaOrder productId(String productId) {
        this.setProductId(productId);
        return this;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getIssuanceId() {
        return this.issuanceId;
    }

    public DanaOrder issuanceId(String issuanceId) {
        this.setIssuanceId(issuanceId);
        return this;
    }

    public void setIssuanceId(String issuanceId) {
        this.issuanceId = issuanceId;
    }

    public String getVoucherCode() {
        return this.voucherCode;
    }

    public DanaOrder voucherCode(String voucherCode) {
        this.setVoucherCode(voucherCode);
        return this;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getVoucherPin() {
        return this.voucherPin;
    }

    public DanaOrder voucherPin(String voucherPin) {
        this.setVoucherPin(voucherPin);
        return this;
    }

    public void setVoucherPin(String voucherPin) {
        this.voucherPin = voucherPin;
    }

    public Instant getIssuanceDate() {
        return this.issuanceDate;
    }

    public DanaOrder issuanceDate(Instant issuanceDate) {
        this.setIssuanceDate(issuanceDate);
        return this;
    }

    public void setIssuanceDate(Instant issuanceDate) {
        this.issuanceDate = issuanceDate;
    }

    public Instant getExpiredDate() {
        return this.expiredDate;
    }

    public DanaOrder expiredDate(Instant expiredDate) {
        this.setExpiredDate(expiredDate);
        return this;
    }

    public void setExpiredDate(Instant expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getExtendInfo() {
        return this.extendInfo;
    }

    public DanaOrder extendInfo(String extendInfo) {
        this.setExtendInfo(extendInfo);
        return this;
    }

    public void setExtendInfo(String extendInfo) {
        this.extendInfo = extendInfo;
    }

    public Instant getSendEmailNotif() {
        return this.sendEmailNotif;
    }

    public DanaOrder sendEmailNotif(Instant sendEmailNotif) {
        this.setSendEmailNotif(sendEmailNotif);
        return this;
    }

    public void setSendEmailNotif(Instant sendEmailNotif) {
        this.sendEmailNotif = sendEmailNotif;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public DanaOrder createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public DanaOrder createdBy(Long createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public DanaOrder updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public DanaOrder updatedBy(Long updatedBy) {
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
        if (!(o instanceof DanaOrder)) {
            return false;
        }
        return getId() != null && getId().equals(((DanaOrder) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DanaOrder{" +
            "id=" + getId() +
            ", version='" + getVersion() + "'" +
            ", functionName='" + getFunctionName() + "'" +
            ", reqTime='" + getReqTime() + "'" +
            ", respTime='" + getRespTime() + "'" +
            ", isActive='" + getIsActive() + "'" +
            ", reqMsgId='" + getReqMsgId() + "'" +
            ", requestId='" + getRequestId() + "'" +
            ", orderId='" + getOrderId() + "'" +
            ", code='" + getCode() + "'" +
            ", status='" + getStatus() + "'" +
            ", message='" + getMessage() + "'" +
            ", productId='" + getProductId() + "'" +
            ", issuanceId='" + getIssuanceId() + "'" +
            ", voucherCode='" + getVoucherCode() + "'" +
            ", voucherPin='" + getVoucherPin() + "'" +
            ", issuanceDate='" + getIssuanceDate() + "'" +
            ", expiredDate='" + getExpiredDate() + "'" +
            ", extendInfo='" + getExtendInfo() + "'" +
            ", sendEmailNotif='" + getSendEmailNotif() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            "}";
    }
}
