package com.nada.DonationApp.entity;

import com.nada.DonationApp.util.enums.DonationStatus;

import javax.persistence.*;

@Entity
@Table(name = "Donation_Status")
public class DonationStatusEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DonationStatus donationStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DonationStatus getDonationStatus() {
        return donationStatus;
    }

    public void setDonationStatus(DonationStatus donationStatus) {
        this.donationStatus = donationStatus;
    }
}

