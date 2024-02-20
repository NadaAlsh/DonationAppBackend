package com.nada.DonationApp.repository;

import com.nada.DonationApp.entity.DonationStatusEntity;
import com.nada.DonationApp.entity.DonationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationStatusRepository extends JpaRepository<DonationStatusEntity, Long> {

    @Query(value = "SELECT * FROM Donation_Status r where r.Donation_Status = :donationStatus",nativeQuery = true)
    DonationStatusEntity findByDonationStatus(String donationStatus);
}
