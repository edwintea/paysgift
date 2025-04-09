package com.paysgift.productservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * A PaysgiftPromoInfo.
 */
@Entity
@Table(name = "paysgift_promo_info")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaysgiftPromoInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "paysgift_promo_id", nullable = false)
    private Long paysgiftPromoId;

    @NotNull
    @Column(name = "voucher_id", nullable = false)
    private Long voucherId;

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

    public PaysgiftPromoInfo id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaysgiftPromoId() {
        return this.paysgiftPromoId;
    }

    public PaysgiftPromoInfo paysgiftPromoId(Long paysgiftPromoId) {
        this.setPaysgiftPromoId(paysgiftPromoId);
        return this;
    }

    public void setPaysgiftPromoId(Long paysgiftPromoId) {
        this.paysgiftPromoId = paysgiftPromoId;
    }

    public Long getVoucherId() {
        return this.voucherId;
    }

    public PaysgiftPromoInfo voucherId(Long voucherId) {
        this.setVoucherId(voucherId);
        return this;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public PaysgiftPromoInfo createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public PaysgiftPromoInfo createdBy(Long createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public PaysgiftPromoInfo updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public PaysgiftPromoInfo updatedBy(Long updatedBy) {
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
        if (!(o instanceof PaysgiftPromoInfo)) {
            return false;
        }
        return getId() != null && getId().equals(((PaysgiftPromoInfo) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaysgiftPromoInfo{" +
            "id=" + getId() +
            ", paysgiftPromoId=" + getPaysgiftPromoId() +
            ", voucherId=" + getVoucherId() +
            ", createdAt='" + getCreatedAt() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            "}";
    }
}
