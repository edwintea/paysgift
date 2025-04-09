package com.paysgift.notification.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * A SendMessage.
 */
@Entity
@Table(name = "send_message")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SendMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull
    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "date_time_entry")
    private Instant dateTimeEntry;

    @Column(name = "date_time_send")
    private Instant dateTimeSend;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "response_text")
    private String responseText;

    @Column(name = "message_id")
    private String messageId;

    @Column(name = "status_message")
    private String statusMessage;

    @Column(name = "table_relation")
    private String tableRelation;

    @Column(name = "table_id")
    private String tableId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public SendMessage id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public SendMessage phoneNumber(String phoneNumber) {
        this.setPhoneNumber(phoneNumber);
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return this.message;
    }

    public SendMessage message(String message) {
        this.setMessage(message);
        return this;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getDateTimeEntry() {
        return this.dateTimeEntry;
    }

    public SendMessage dateTimeEntry(Instant dateTimeEntry) {
        this.setDateTimeEntry(dateTimeEntry);
        return this;
    }

    public void setDateTimeEntry(Instant dateTimeEntry) {
        this.dateTimeEntry = dateTimeEntry;
    }

    public Instant getDateTimeSend() {
        return this.dateTimeSend;
    }

    public SendMessage dateTimeSend(Instant dateTimeSend) {
        this.setDateTimeSend(dateTimeSend);
        return this;
    }

    public void setDateTimeSend(Instant dateTimeSend) {
        this.dateTimeSend = dateTimeSend;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public SendMessage status(Boolean status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getResponseText() {
        return this.responseText;
    }

    public SendMessage responseText(String responseText) {
        this.setResponseText(responseText);
        return this;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public SendMessage messageId(String messageId) {
        this.setMessageId(messageId);
        return this;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public SendMessage statusMessage(String statusMessage) {
        this.setStatusMessage(statusMessage);
        return this;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getTableRelation() {
        return this.tableRelation;
    }

    public SendMessage tableRelation(String tableRelation) {
        this.setTableRelation(tableRelation);
        return this;
    }

    public void setTableRelation(String tableRelation) {
        this.tableRelation = tableRelation;
    }

    public String getTableId() {
        return this.tableId;
    }

    public SendMessage tableId(String tableId) {
        this.setTableId(tableId);
        return this;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendMessage)) {
            return false;
        }
        return getId() != null && getId().equals(((SendMessage) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SendMessage{" +
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
