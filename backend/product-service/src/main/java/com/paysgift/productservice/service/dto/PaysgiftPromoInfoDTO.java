package com.paysgift.productservice.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.productservice.domain.PaysgiftPromoInfo} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaysgiftPromoInfoDTO implements Serializable {

    private Long id;

    @NotNull
    private Long paysgiftPromoId;

    @NotNull
    private Long voucherId;

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

    public Long getPaysgiftPromoId() {
        return paysgiftPromoId;
    }

    public void setPaysgiftPromoId(Long paysgiftPromoId) {
        this.paysgiftPromoId = paysgiftPromoId;
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
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
        if (!(o instanceof PaysgiftPromoInfoDTO)) {
            return false;
        }

        PaysgiftPromoInfoDTO paysgiftPromoInfoDTO = (PaysgiftPromoInfoDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, paysgiftPromoInfoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaysgiftPromoInfoDTO{" +
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
