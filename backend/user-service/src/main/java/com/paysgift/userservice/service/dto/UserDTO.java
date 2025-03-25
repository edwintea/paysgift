package com.paysgift.userservice.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.paysgift.userservice.domain.User} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UserDTO implements Serializable {

    private Long id;

    @NotNull
    private Long groupId;

    @NotNull
    private Long countryId;

    @NotNull
    private Boolean isActive;

    private String image;

    private String username;

    private String password;

    private String fullname;

    @NotNull
    private String email;

    @NotNull
    private String mobileNumber;

    private Boolean isAdmin;

    private Boolean isInternal;

    private Boolean byLocation;

    private String location;

    private String google2faSecret;

    private String otpNumber;

    private Boolean otpStatus;

    private Instant otpExpiredDate;

    private Instant lastLoginAt;

    private Instant createdAt;

    private Instant updatedAt;

    private Boolean is2fa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(Boolean isInternal) {
        this.isInternal = isInternal;
    }

    public Boolean getByLocation() {
        return byLocation;
    }

    public void setByLocation(Boolean byLocation) {
        this.byLocation = byLocation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGoogle2faSecret() {
        return google2faSecret;
    }

    public void setGoogle2faSecret(String google2faSecret) {
        this.google2faSecret = google2faSecret;
    }

    public String getOtpNumber() {
        return otpNumber;
    }

    public void setOtpNumber(String otpNumber) {
        this.otpNumber = otpNumber;
    }

    public Boolean getOtpStatus() {
        return otpStatus;
    }

    public void setOtpStatus(Boolean otpStatus) {
        this.otpStatus = otpStatus;
    }

    public Instant getOtpExpiredDate() {
        return otpExpiredDate;
    }

    public void setOtpExpiredDate(Instant otpExpiredDate) {
        this.otpExpiredDate = otpExpiredDate;
    }

    public Instant getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(Instant lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getIs2fa() {
        return is2fa;
    }

    public void setIs2fa(Boolean is2fa) {
        this.is2fa = is2fa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserDTO)) {
            return false;
        }

        UserDTO userDTO = (UserDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, userDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserDTO{" +
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
