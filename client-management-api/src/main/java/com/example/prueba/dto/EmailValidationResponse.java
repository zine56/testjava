package com.example.prueba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailValidationResponse {

    private String email;
    private String autocorrect;
    private String deliverability;

    @JsonProperty("quality_score")
    private String qualityScore;

    @JsonProperty("is_valid_format")
    private ValidationDetail isValidFormat;

    @JsonProperty("is_free_email")
    private ValidationDetail isFreeEmail;

    @JsonProperty("is_disposable_email")
    private ValidationDetail isDisposableEmail;

    @JsonProperty("is_role_email")
    private ValidationDetail isRoleEmail;

    @JsonProperty("is_catchall_email")
    private ValidationDetail isCatchallEmail;

    @JsonProperty("is_mx_found")
    private ValidationDetail isMxFound;

    @JsonProperty("is_smtp_valid")
    private ValidationDetail isSmtpValid;

    public static class ValidationDetail {
        private boolean value;
        private String text;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAutocorrect() {
        return autocorrect;
    }

    public void setAutocorrect(String autocorrect) {
        this.autocorrect = autocorrect;
    }

    public String getDeliverability() {
        return deliverability;
    }

    public void setDeliverability(String deliverability) {
        this.deliverability = deliverability;
    }

    public String getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(String qualityScore) {
        this.qualityScore = qualityScore;
    }

    public ValidationDetail getIsValidFormat() {
        return isValidFormat;
    }

    public void setIsValidFormat(ValidationDetail isValidFormat) {
        this.isValidFormat = isValidFormat;
    }

    public ValidationDetail getIsFreeEmail() {
        return isFreeEmail;
    }

    public void setIsFreeEmail(ValidationDetail isFreeEmail) {
        this.isFreeEmail = isFreeEmail;
    }

    public ValidationDetail getIsDisposableEmail() {
        return isDisposableEmail;
    }

    public void setIsDisposableEmail(ValidationDetail isDisposableEmail) {
        this.isDisposableEmail = isDisposableEmail;
    }

    public ValidationDetail getIsRoleEmail() {
        return isRoleEmail;
    }

    public void setIsRoleEmail(ValidationDetail isRoleEmail) {
        this.isRoleEmail = isRoleEmail;
    }

    public ValidationDetail getIsCatchallEmail() {
        return isCatchallEmail;
    }

    public void setIsCatchallEmail(ValidationDetail isCatchallEmail) {
        this.isCatchallEmail = isCatchallEmail;
    }

    public ValidationDetail getIsMxFound() {
        return isMxFound;
    }

    public void setIsMxFound(ValidationDetail isMxFound) {
        this.isMxFound = isMxFound;
    }

    public ValidationDetail getIsSmtpValid() {
        return isSmtpValid;
    }

    public void setIsSmtpValid(ValidationDetail isSmtpValid) {
        this.isSmtpValid = isSmtpValid;
    }
}
