package com.paysgift.notification.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * A SendWhatsApp.
 */
@Entity
@Table(name = "send_whats_app")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SendWhatsApp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "message")
    private String message;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "date_time_entry")
    private String dateTimeEntry;

    @Column(name = "date_time_send")
    private Instant dateTimeSend;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "response_txt")
    private String responseTxt;

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

    public SendWhatsApp id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public SendWhatsApp countryCode(String countryCode) {
        this.setCountryCode(countryCode);
        return this;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public SendWhatsApp phoneNumber(String phoneNumber) {
        this.setPhoneNumber(phoneNumber);
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return this.message;
    }

    public SendWhatsApp message(String message) {
        this.setMessage(message);
        return this;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public SendWhatsApp imageUrl(String imageUrl) {
        this.setImageUrl(imageUrl);
        return this;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDateTimeEntry() {
        return this.dateTimeEntry;
    }

    public SendWhatsApp dateTimeEntry(String dateTimeEntry) {
        this.setDateTimeEntry(dateTimeEntry);
        return this;
    }

    public void setDateTimeEntry(String dateTimeEntry) {
        this.dateTimeEntry = dateTimeEntry;
    }

    public Instant getDateTimeSend() {
        return this.dateTimeSend;
    }

    public SendWhatsApp dateTimeSend(Instant dateTimeSend) {
        this.setDateTimeSend(dateTimeSend);
        return this;
    }

    public void setDateTimeSend(Instant dateTimeSend) {
        this.dateTimeSend = dateTimeSend;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public SendWhatsApp status(Boolean status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getResponseTxt() {
        return this.responseTxt;
    }

    public SendWhatsApp responseTxt(String responseTxt) {
        this.setResponseTxt(responseTxt);
        return this;
    }

    public void setResponseTxt(String responseTxt) {
        this.responseTxt = responseTxt;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public SendWhatsApp messageId(String messageId) {
        this.setMessageId(messageId);
        return this;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public SendWhatsApp statusMessage(String statusMessage) {
        this.setStatusMessage(statusMessage);
        return this;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getTableRelation() {
        return this.tableRelation;
    }

    public SendWhatsApp tableRelation(String tableRelation) {
        this.setTableRelation(tableRelation);
        return this;
    }

    public void setTableRelation(String tableRelation) {
        this.tableRelation = tableRelation;
    }

    public String getTableId() {
        return this.tableId;
    }

    public SendWhatsApp tableId(String tableId) {
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
        if (!(o instanceof SendWhatsApp)) {
            return false;
        }
        return getId() != null && getId().equals(((SendWhatsApp) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SendWhatsApp{" +
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
