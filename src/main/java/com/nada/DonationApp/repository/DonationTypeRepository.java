package com.nada.DonationApp.repository;

import com.nada.DonationApp.entity.DonationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationTypeRepository extends JpaRepository<DonationTypeEntity, Long> {

    @Query(value = "SELECT * FROM donation_type r where r.donation_type = :donationType",nativeQuery = true)
    DonationTypeEntity findByDonationType(String donationType);
}
