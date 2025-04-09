package com.paysgift.notification.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.notification.domain.SendWhatsApp} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SendWhatsAppDTO implements Serializable {

    private Long id;

    private String countryCode;

    private String phoneNumber;

    private String message;

    private String imageUrl;

    private String dateTimeEntry;

    private Instant dateTimeSend;

    private Boolean status;

    private String responseTxt;

    private String messageId;

    private String statusMessage;

    private String tableRelation;

    private String tableId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDateTimeEntry() {
        return dateTimeEntry;
    }

    public void setDateTimeEntry(String dateTimeEntry) {
        this.dateTimeEntry = dateTimeEntry;
    }

    public Instant getDateTimeSend() {
        return dateTimeSend;
    }

    public void setDateTimeSend(Instant dateTimeSend) {
        this.dateTimeSend = dateTimeSend;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getResponseTxt() {
        return responseTxt;
    }

    public void setResponseTxt(String responseTxt) {
        this.responseTxt = responseTxt;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getTableRelation() {
        return tableRelation;
    }

    public void setTableRelation(String tableRelation) {
        this.tableRelation = tableRelation;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendWhatsAppDTO)) {
            return false;
        }

        SendWhatsAppDTO sendWhatsAppDTO = (SendWhatsAppDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, sendWhatsAppDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SendWhatsAppDTO{" +
            "id=" + getId() +
            ", countryCode='" + getCountryCode() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", message='" + getMessage() + "'" +
            ", imageUrl='" + getImageUrl() + "'" +
            ", dateTimeEntry='" + getDateTimeEntry() + "'" +
            ", dateTimeSend='" + getDateTimeSend() + "'" +
            ", status='" + getStatus() + "'" +
            ", responseTxt='" + getResponseTxt() + "'" +
            ", messageId='" + getMessageId() + "'" +
            ", statusMessage='" + getStatusMessage() + "'" +
            ", tableRelation='" + getTableRelation() + "'" +
            ", tableId='" + getTableId() + "'" +
            "}";
    }
}
