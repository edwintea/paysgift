package com.paysgift.notification.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * A SendEmail.
 */
@Entity
@Table(name = "send_email")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SendEmail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "mail_to", nullable = false)
    private String mailTo;

    @NotNull
    @Column(name = "mail_to_name", nullable = false)
    private String mailToName;

    @NotNull
    @Column(name = "subject", nullable = false)
    private String subject;

    @NotNull
    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "attached_1")
    private String attached1;

    @Column(name = "attached_unlink_1")
    private String attachedUnlink1;

    @Column(name = "attached_2")
    private String attached2;

    @Column(name = "attached_unlink_2")
    private String attachedUnlink2;

    @Column(name = "attached_3")
    private String attached3;

    @Column(name = "attached_unlink_3")
    private String attachedUnlink3;

    @Column(name = "date_time_entry")
    private Instant dateTimeEntry;

    @Column(name = "date_time_send")
    private Instant dateTimeSend;

    @NotNull
    @Column(name = "mail_from", nullable = false)
    private String mailFrom;

    @NotNull
    @Column(name = "mail_from_name", nullable = false)
    private String mailFromName;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "info")
    private String info;

    @Column(name = "mail_cc")
    private String mailCc;

    @Column(name = "mail_cc_name")
    private String mailCcName;

    @Column(name = "table_relation")
    private String tableRelation;

    @Column(name = "table_id")
    private String tableId;

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

    public SendEmail id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMailTo() {
        return this.mailTo;
    }

    public SendEmail mailTo(String mailTo) {
        this.setMailTo(mailTo);
        return this;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailToName() {
        return this.mailToName;
    }

    public SendEmail mailToName(String mailToName) {
        this.setMailToName(mailToName);
        return this;
    }

    public void setMailToName(String mailToName) {
        this.mailToName = mailToName;
    }

    public String getSubject() {
        return this.subject;
    }

    public SendEmail subject(String subject) {
        this.setSubject(subject);
        return this;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return this.body;
    }

    public SendEmail body(String body) {
        this.setBody(body);
        return this;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttached1() {
        return this.attached1;
    }

    public SendEmail attached1(String attached1) {
        this.setAttached1(attached1);
        return this;
    }

    public void setAttached1(String attached1) {
        this.attached1 = attached1;
    }

    public String getAttachedUnlink1() {
        return this.attachedUnlink1;
    }

    public SendEmail attachedUnlink1(String attachedUnlink1) {
        this.setAttachedUnlink1(attachedUnlink1);
        return this;
    }

    public void setAttachedUnlink1(String attachedUnlink1) {
        this.attachedUnlink1 = attachedUnlink1;
    }

    public String getAttached2() {
        return this.attached2;
    }

    public SendEmail attached2(String attached2) {
        this.setAttached2(attached2);
        return this;
    }

    public void setAttached2(String attached2) {
        this.attached2 = attached2;
    }

    public String getAttachedUnlink2() {
        return this.attachedUnlink2;
    }

    public SendEmail attachedUnlink2(String attachedUnlink2) {
        this.setAttachedUnlink2(attachedUnlink2);
        return this;
    }

    public void setAttachedUnlink2(String attachedUnlink2) {
        this.attachedUnlink2 = attachedUnlink2;
    }

    public String getAttached3() {
        return this.attached3;
    }

    public SendEmail attached3(String attached3) {
        this.setAttached3(attached3);
        return this;
    }

    public void setAttached3(String attached3) {
        this.attached3 = attached3;
    }

    public String getAttachedUnlink3() {
        return this.attachedUnlink3;
    }

    public SendEmail attachedUnlink3(String attachedUnlink3) {
        this.setAttachedUnlink3(attachedUnlink3);
        return this;
    }

    public void setAttachedUnlink3(String attachedUnlink3) {
        this.attachedUnlink3 = attachedUnlink3;
    }

    public Instant getDateTimeEntry() {
        return this.dateTimeEntry;
    }

    public SendEmail dateTimeEntry(Instant dateTimeEntry) {
        this.setDateTimeEntry(dateTimeEntry);
        return this;
    }

    public void setDateTimeEntry(Instant dateTimeEntry) {
        this.dateTimeEntry = dateTimeEntry;
    }

    public Instant getDateTimeSend() {
        return this.dateTimeSend;
    }

    public SendEmail dateTimeSend(Instant dateTimeSend) {
        this.setDateTimeSend(dateTimeSend);
        return this;
    }

    public void setDateTimeSend(Instant dateTimeSend) {
        this.dateTimeSend = dateTimeSend;
    }

    public String getMailFrom() {
        return this.mailFrom;
    }

    public SendEmail mailFrom(String mailFrom) {
        this.setMailFrom(mailFrom);
        return this;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getMailFromName() {
        return this.mailFromName;
    }

    public SendEmail mailFromName(String mailFromName) {
        this.setMailFromName(mailFromName);
        return this;
    }

    public void setMailFromName(String mailFromName) {
        this.mailFromName = mailFromName;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public SendEmail status(Boolean status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getInfo() {
        return this.info;
    }

    public SendEmail info(String info) {
        this.setInfo(info);
        return this;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMailCc() {
        return this.mailCc;
    }

    public SendEmail mailCc(String mailCc) {
        this.setMailCc(mailCc);
        return this;
    }

    public void setMailCc(String mailCc) {
        this.mailCc = mailCc;
    }

    public String getMailCcName() {
        return this.mailCcName;
    }

    public SendEmail mailCcName(String mailCcName) {
        this.setMailCcName(mailCcName);
        return this;
    }

    public void setMailCcName(String mailCcName) {
        this.mailCcName = mailCcName;
    }

    public String getTableRelation() {
        return this.tableRelation;
    }

    public SendEmail tableRelation(String tableRelation) {
        this.setTableRelation(tableRelation);
        return this;
    }

    public void setTableRelation(String tableRelation) {
        this.tableRelation = tableRelation;
    }

    public String getTableId() {
        return this.tableId;
    }

    public SendEmail tableId(String tableId) {
        this.setTableId(tableId);
        return this;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public SendEmail createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public SendEmail createdBy(Long createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public SendEmail updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public SendEmail updatedBy(Long updatedBy) {
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
        if (!(o instanceof SendEmail)) {
            return false;
        }
        return getId() != null && getId().equals(((SendEmail) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SendEmail{" +
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
