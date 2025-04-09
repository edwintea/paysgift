package com.paysgift.notification.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.notification.domain.SendEmail} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SendEmailDTO implements Serializable {

    private Long id;

    @NotNull
    private String mailTo;

    @NotNull
    private String mailToName;

    @NotNull
    private String subject;

    @NotNull
    private String body;

    private String attached1;

    private String attachedUnlink1;

    private String attached2;

    private String attachedUnlink2;

    private String attached3;

    private String attachedUnlink3;

    private Instant dateTimeEntry;

    private Instant dateTimeSend;

    @NotNull
    private String mailFrom;

    @NotNull
    private String mailFromName;

    private Boolean status;

    private String info;

    private String mailCc;

    private String mailCcName;

    private String tableRelation;

    private String tableId;

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

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailToName() {
        return mailToName;
    }

    public void setMailToName(String mailToName) {
        this.mailToName = mailToName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttached1() {
        return attached1;
    }

    public void setAttached1(String attached1) {
        this.attached1 = attached1;
    }

    public String getAttachedUnlink1() {
        return attachedUnlink1;
    }

    public void setAttachedUnlink1(String attachedUnlink1) {
        this.attachedUnlink1 = attachedUnlink1;
    }

    public String getAttached2() {
        return attached2;
    }

    public void setAttached2(String attached2) {
        this.attached2 = attached2;
    }

    public String getAttachedUnlink2() {
        return attachedUnlink2;
    }

    public void setAttachedUnlink2(String attachedUnlink2) {
        this.attachedUnlink2 = attachedUnlink2;
    }

    public String getAttached3() {
        return attached3;
    }

    public void setAttached3(String attached3) {
        this.attached3 = attached3;
    }

    public String getAttachedUnlink3() {
        return attachedUnlink3;
    }

    public void setAttachedUnlink3(String attachedUnlink3) {
        this.attachedUnlink3 = attachedUnlink3;
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

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getMailFromName() {
        return mailFromName;
    }

    public void setMailFromName(String mailFromName) {
        this.mailFromName = mailFromName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMailCc() {
        return mailCc;
    }

    public void setMailCc(String mailCc) {
        this.mailCc = mailCc;
    }

    public String getMailCcName() {
        return mailCcName;
    }

    public void setMailCcName(String mailCcName) {
        this.mailCcName = mailCcName;
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
        if (!(o instanceof SendEmailDTO)) {
            return false;
        }

        SendEmailDTO sendEmailDTO = (SendEmailDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, sendEmailDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SendEmailDTO{" +
            "id=" + getId() +
            ", mailTo='" + getMailTo() + "'" +
            ", mailToName='" + getMailToName() + "'" +
            ", subject='" + getSubject() + "'" +
            ", body='" + getBody() + "'" +
            ", attached1='" + getAttached1() + "'" +
            ", attachedUnlink1='" + getAttachedUnlink1() + "'" +
            ", attached2='" + getAttached2() + "'" +
            ", attachedUnlink2='" + getAttachedUnlink2() + "'" +
            ", attached3='" + getAttached3() + "'" +
            ", attachedUnlink3='" + getAttachedUnlink3() + "'" +
            ", dateTimeEntry='" + getDateTimeEntry() + "'" +
            ", dateTimeSend='" + getDateTimeSend() + "'" +
            ", mailFrom='" + getMailFrom() + "'" +
            ", mailFromName='" + getMailFromName() + "'" +
            ", status='" + getStatus() + "'" +
            ", info='" + getInfo() + "'" +
            ", mailCc='" + getMailCc() + "'" +
            ", mailCcName='" + getMailCcName() + "'" +
            ", tableRelation='" + getTableRelation() + "'" +
            ", tableId='" + getTableId() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            "}";
    }
}
