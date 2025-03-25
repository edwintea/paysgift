package com.paysgift.userservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * A User.
 */
@Entity
@Table(name = "user")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "group_id", nullable = false)
    private Long groupId;

    @NotNull
    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "image")
    private String image;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Column(name = "is_internal")
    private Boolean isInternal;

    @Column(name = "by_location")
    private Boolean byLocation;

    @Column(name = "location")
    private String location;

    @Column(name = "google_2_fa_secret")
    private String google2faSecret;

    @Column(name = "otp_number")
    private String otpNumber;

    @Column(name = "otp_status")
    private Boolean otpStatus;

    @Column(name = "otp_expired_date")
    private Instant otpExpiredDate;

    @Column(name = "last_login_at")
    private Instant lastLoginAt;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "is_2_fa")
    private Boolean is2fa;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public User id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return this.groupId;
    }

    public User groupId(Long groupId) {
        this.setGroupId(groupId);
        return this;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getCountryId() {
        return this.countryId;
    }

    public User countryId(Long countryId) {
        this.setCountryId(countryId);
        return this;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public User isActive(Boolean isActive) {
        this.setIsActive(isActive);
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getImage() {
        return this.image;
    }

    public User image(String image) {
        this.setImage(image);
        return this;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return this.username;
    }

    public User username(String username) {
        this.setUsername(username);
        return this;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public User password(String password) {
        this.setPassword(password);
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return this.fullname;
    }

    public User fullname(String fullname) {
        this.setFullname(fullname);
        return this;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return this.email;
    }

    public User email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public User mobileNumber(String mobileNumber) {
        this.setMobileNumber(mobileNumber);
        return this;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Boolean getIsAdmin() {
        return this.isAdmin;
    }

    public User isAdmin(Boolean isAdmin) {
        this.setIsAdmin(isAdmin);
        return this;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsInternal() {
        return this.isInternal;
    }

    public User isInternal(Boolean isInternal) {
        this.setIsInternal(isInternal);
        return this;
    }

    public void setIsInternal(Boolean isInternal) {
        this.isInternal = isInternal;
    }

    public Boolean getByLocation() {
        return this.byLocation;
    }

    public User byLocation(Boolean byLocation) {
        this.setByLocation(byLocation);
        return this;
    }

    public void setByLocation(Boolean byLocation) {
        this.byLocation = byLocation;
    }

    public String getLocation() {
        return this.location;
    }

    public User location(String location) {
        this.setLocation(location);
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGoogle2faSecret() {
        return this.google2faSecret;
    }

    public User google2faSecret(String google2faSecret) {
        this.setGoogle2faSecret(google2faSecret);
        return this;
    }

    public void setGoogle2faSecret(String google2faSecret) {
        this.google2faSecret = google2faSecret;
    }

    public String getOtpNumber() {
        return this.otpNumber;
    }

    public User otpNumber(String otpNumber) {
        this.setOtpNumber(otpNumber);
        return this;
    }

    public void setOtpNumber(String otpNumber) {
        this.otpNumber = otpNumber;
    }

    public Boolean getOtpStatus() {
        return this.otpStatus;
    }

    public User otpStatus(Boolean otpStatus) {
        this.setOtpStatus(otpStatus);
        return this;
    }

    public void setOtpStatus(Boolean otpStatus) {
        this.otpStatus = otpStatus;
    }

    public Instant getOtpExpiredDate() {
        return this.otpExpiredDate;
    }

    public User otpExpiredDate(Instant otpExpiredDate) {
        this.setOtpExpiredDate(otpExpiredDate);
        return this;
    }

    public void setOtpExpiredDate(Instant otpExpiredDate) {
        this.otpExpiredDate = otpExpiredDate;
    }

    public Instant getLastLoginAt() {
        return this.lastLoginAt;
    }

    public User lastLoginAt(Instant lastLoginAt) {
        this.setLastLoginAt(lastLoginAt);
        return this;
    }

    public void setLastLoginAt(Instant lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public User createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public User updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getIs2fa() {
        return this.is2fa;
    }

    public User is2fa(Boolean is2fa) {
        this.setIs2fa(is2fa);
        return this;
    }

    public void setIs2fa(Boolean is2fa) {
        this.is2fa = is2fa;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        return getId() != null && getId().equals(((User) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "User{" +
            "id=" + getId() +
            ", groupId=" + getGroupId() +
            ", countryId=" + getCountryId() +
            ", isActive='" + getIsActive() + "'" +
            ", image='" + getImage() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", fullname='" + getFullname() + "'" +
            ", email='" + getEmail() + "'" +
            ", mobileNumber='" + getMobileNumber() + "'" +
            ", isAdmin='" + getIsAdmin() + "'" +
            ", isInternal='" + getIsInternal() + "'" +
            ", byLocation='" + getByLocation() + "'" +
            ", location='" + getLocation() + "'" +
            ", google2faSecret='" + getGoogle2faSecret() + "'" +
            ", otpNumber='" + getOtpNumber() + "'" +
            ", otpStatus='" + getOtpStatus() + "'" +
            ", otpExpiredDate='" + getOtpExpiredDate() + "'" +
            ", lastLoginAt='" + getLastLoginAt() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", is2fa='" + getIs2fa() + "'" +
            "}";
    }
}
