package com.nada.DonationApp.bo.donation;

public class CreateDonationRequest {

    private String fileNumber;

    private String donationType;

    private String researchPurposeDonation;

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public String getResearchPurposeDonation() {
        return researchPurposeDonation;
    }

    public void setResearchPurposeDonation(String researchPurposeDonation) {
        this.researchPurposeDonation = researchPurposeDonation;
    }
}
