package com.nada.DonationApp.entity;

import com.nada.DonationApp.util.enums.DonationType;

import javax.persistence.*;

@Entity
@Table(name = "donation_type")
public class DonationTypeEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "donation_Type")
    private DonationType donationType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DonationType getDonationType() {
        return donationType;
    }

    public void setDonationType(DonationType donationType) {
        this.donationType = donationType;
    }

}
