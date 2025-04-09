package com.paysgift.notification.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.notification.domain.SendMessage} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SendMessageDTO implements Serializable {

    private Long id;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String message;

    private Instant dateTimeEntry;

    private Instant dateTimeSend;

    private Boolean status;

    private String responseText;

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

    public Instant getDateTimeEntry() {
        return dateTimeEntry;
    }

    public void setDateTimeEntry(Instant dateTimeEntry) {
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

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
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
        if (!(o instanceof SendMessageDTO)) {
            return false;
        }

        SendMessageDTO sendMessageDTO = (SendMessageDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, sendMessageDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SendMessageDTO{" +
            "id=" + getId() +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", message='" + getMessage() + "'" +
            ", dateTimeEntry='" + getDateTimeEntry() + "'" +
            ", dateTimeSend='" + getDateTimeSend() + "'" +
            ", status='" + getStatus() + "'" +
            ", responseText='" + getResponseText() + "'" +
            ", messageId='" + getMessageId() + "'" +
            ", statusMessage='" + getStatusMessage() + "'" +
            ", tableRelation='" + getTableRelation() + "'" +
            ", tableId='" + getTableId() + "'" +
            "}";
    }
}
