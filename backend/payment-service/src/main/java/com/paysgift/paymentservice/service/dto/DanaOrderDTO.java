package com.paysgift.paymentservice.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.paymentservice.domain.DanaOrder} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DanaOrderDTO implements Serializable {

    private Long id;

    private String version;

    private String functionName;

    private Instant reqTime;

    private Instant respTime;

    private Boolean isActive;

    private String reqMsgId;

    private String requestId;

    private String orderId;

    private String code;

    private String status;

    private String message;

    private String productId;

    private String issuanceId;

    private String voucherCode;

    private String voucherPin;

    private Instant issuanceDate;

    private Instant expiredDate;

    private String extendInfo;

    private Instant sendEmailNotif;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public Instant getReqTime() {
        return reqTime;
    }

    public void setReqTime(Instant reqTime) {
        this.reqTime = reqTime;
    }

    public Instant getRespTime() {
        return respTime;
    }

    public void setRespTime(Instant respTime) {
        this.respTime = respTime;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getReqMsgId() {
        return reqMsgId;
    }

    public void setReqMsgId(String reqMsgId) {
        this.reqMsgId = reqMsgId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getIssuanceId() {
        return issuanceId;
    }

    public void setIssuanceId(String issuanceId) {
        this.issuanceId = issuanceId;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getVoucherPin() {
        return voucherPin;
    }

    public void setVoucherPin(String voucherPin) {
        this.voucherPin = voucherPin;
    }

    public Instant getIssuanceDate() {
        return issuanceDate;
    }

    public void setIssuanceDate(Instant issuanceDate) {
        this.issuanceDate = issuanceDate;
    }

    public Instant getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Instant expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(String extendInfo) {
        this.extendInfo = extendInfo;
    }

    public Instant getSendEmailNotif() {
        return sendEmailNotif;
    }

    public void setSendEmailNotif(Instant sendEmailNotif) {
        this.sendEmailNotif = sendEmailNotif;
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
        if (!(o instanceof DanaOrderDTO)) {
            return false;
        }

        DanaOrderDTO danaOrderDTO = (DanaOrderDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, danaOrderDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DanaOrderDTO{" +
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
