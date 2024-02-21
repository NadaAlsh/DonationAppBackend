package com.nada.DonationApp.entity;

import com.nada.DonationApp.util.enums.Gender;
import com.nada.DonationApp.util.enums.ResearchPurposeDonation;

import javax.persistence.*;

@Entity
@Table(name = "donation")
public class DonationRequestEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fileNumber", nullable = false)
    private String fileNumber;

    private String bloodType;

    @Column(name = "researchPurposeDonation", nullable = false)
    @Enumerated(EnumType.STRING)
    private ResearchPurposeDonation researchPurposeDonation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "donation_type_id")
    private DonationTypeEntity donationTypeEntity;

    @OneToOne
    @JoinColumn(name = "donation_status_id")
    private DonationStatusEntity donationStatusEntity;

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public DonationTypeEntity getDonationTypeEntity() {
        return donationTypeEntity;
    }

    public void setDonationTypeEntity(DonationTypeEntity donationTypeEntity) {
        this.donationTypeEntity = donationTypeEntity;
    }

    public DonationStatusEntity getDonationStatusEntity() {
        return donationStatusEntity;
    }

    public void setDonationStatusEntity(DonationStatusEntity donationStatusEntity) {
        this.donationStatusEntity = donationStatusEntity;
    }

    public ResearchPurposeDonation getResearchPurposeDonation() {
        return researchPurposeDonation;
    }

    public void setResearchPurposeDonation(String researchPurposeDonation) {
        this.researchPurposeDonation = ResearchPurposeDonation.valueOf(researchPurposeDonation);
    }

}
