package com.nada.DonationApp.repository;

import com.nada.DonationApp.entity.DonationRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRequestRepository extends JpaRepository<DonationRequestEntity, Long> {

    //List<DonationRequestEntity> findFinishedDonations();
    //List<DonationEntity> ();
}
