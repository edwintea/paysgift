package com.paysgift.paymentservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * A PaymentTransactionCampaign.
 */
@Entity
@Table(name = "payment_transaction_campaign")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentTransactionCampaign implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "payment_transaction_id", nullable = false)
    private Long paymentTransactionId;

    @Column(name = "cycle")
    private Integer cycle;

    @Column(name = "hit_datetime")
    private Instant hitDatetime;

    @Column(name = "hit_status")
    private Boolean hitStatus;

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

    public PaymentTransactionCampaign id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaymentTransactionId() {
        return this.paymentTransactionId;
    }

    public PaymentTransactionCampaign paymentTransactionId(Long paymentTransactionId) {
        this.setPaymentTransactionId(paymentTransactionId);
        return this;
    }

    public void setPaymentTransactionId(Long paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

    public Integer getCycle() {
        return this.cycle;
    }

    public PaymentTransactionCampaign cycle(Integer cycle) {
        this.setCycle(cycle);
        return this;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public Instant getHitDatetime() {
        return this.hitDatetime;
    }

    public PaymentTransactionCampaign hitDatetime(Instant hitDatetime) {
        this.setHitDatetime(hitDatetime);
        return this;
    }

    public void setHitDatetime(Instant hitDatetime) {
        this.hitDatetime = hitDatetime;
    }

    public Boolean getHitStatus() {
        return this.hitStatus;
    }

    public PaymentTransactionCampaign hitStatus(Boolean hitStatus) {
        this.setHitStatus(hitStatus);
        return this;
    }

    public void setHitStatus(Boolean hitStatus) {
        this.hitStatus = hitStatus;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public PaymentTransactionCampaign createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public PaymentTransactionCampaign createdBy(Long createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public PaymentTransactionCampaign updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public PaymentTransactionCampaign updatedBy(Long updatedBy) {
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
        if (!(o instanceof PaymentTransactionCampaign)) {
            return false;
        }
        return getId() != null && getId().equals(((PaymentTransactionCampaign) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaymentTransactionCampaign{" +
            "id=" + getId() +
            ", paymentTransactionId=" + getPaymentTransactionId() +
            ", cycle=" + getCycle() +
            ", hitDatetime='" + getHitDatetime() + "'" +
            ", hitStatus='" + getHitStatus() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            "}";
    }
}
