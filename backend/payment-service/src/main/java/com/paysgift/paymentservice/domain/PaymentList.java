package com.paysgift.paymentservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A PaymentList.
 */
@Entity
@Table(name = "payment_list")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "type")
    private String type;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "payment_provider_id", nullable = false)
    private Long paymentProviderId;

    @Column(name = "payment_fee_percentage", precision = 21, scale = 2)
    private BigDecimal paymentFeePercentage;

    @Column(name = "payment_fee_nominal", precision = 21, scale = 2)
    private BigDecimal paymentFeeNominal;

    @Column(name = "payment_notes")
    private String paymentNotes;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "how_to_pay")
    private String howToPay;

    @Column(name = "note")
    private String note;

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

    public PaymentList id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public PaymentList status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return this.type;
    }

    public PaymentList type(String type) {
        this.setType(type);
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return this.code;
    }

    public PaymentList code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public PaymentList name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPaymentProviderId() {
        return this.paymentProviderId;
    }

    public PaymentList paymentProviderId(Long paymentProviderId) {
        this.setPaymentProviderId(paymentProviderId);
        return this;
    }

    public void setPaymentProviderId(Long paymentProviderId) {
        this.paymentProviderId = paymentProviderId;
    }

    public BigDecimal getPaymentFeePercentage() {
        return this.paymentFeePercentage;
    }

    public PaymentList paymentFeePercentage(BigDecimal paymentFeePercentage) {
        this.setPaymentFeePercentage(paymentFeePercentage);
        return this;
    }

    public void setPaymentFeePercentage(BigDecimal paymentFeePercentage) {
        this.paymentFeePercentage = paymentFeePercentage;
    }

    public BigDecimal getPaymentFeeNominal() {
        return this.paymentFeeNominal;
    }

    public PaymentList paymentFeeNominal(BigDecimal paymentFeeNominal) {
        this.setPaymentFeeNominal(paymentFeeNominal);
        return this;
    }

    public void setPaymentFeeNominal(BigDecimal paymentFeeNominal) {
        this.paymentFeeNominal = paymentFeeNominal;
    }

    public String getPaymentNotes() {
        return this.paymentNotes;
    }

    public PaymentList paymentNotes(String paymentNotes) {
        this.setPaymentNotes(paymentNotes);
        return this;
    }

    public void setPaymentNotes(String paymentNotes) {
        this.paymentNotes = paymentNotes;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public PaymentList imageUrl(String imageUrl) {
        this.setImageUrl(imageUrl);
        return this;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHowToPay() {
        return this.howToPay;
    }

    public PaymentList howToPay(String howToPay) {
        this.setHowToPay(howToPay);
        return this;
    }

    public void setHowToPay(String howToPay) {
        this.howToPay = howToPay;
    }

    public String getNote() {
        return this.note;
    }

    public PaymentList note(String note) {
        this.setNote(note);
        return this;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public PaymentList createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public PaymentList createdBy(Long createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public PaymentList updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public PaymentList updatedBy(Long updatedBy) {
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
        if (!(o instanceof PaymentList)) {
            return false;
        }
        return getId() != null && getId().equals(((PaymentList) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaymentList{" +
            "id=" + getId() +
            ", status='" + getStatus() + "'" +
            ", type='" + getType() + "'" +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", paymentProviderId=" + getPaymentProviderId() +
            ", paymentFeePercentage=" + getPaymentFeePercentage() +
            ", paymentFeeNominal=" + getPaymentFeeNominal() +
            ", paymentNotes='" + getPaymentNotes() + "'" +
            ", imageUrl='" + getImageUrl() + "'" +
            ", howToPay='" + getHowToPay() + "'" +
            ", note='" + getNote() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", updatedBy=" + getUpdatedBy() +
            "}";
    }
}
