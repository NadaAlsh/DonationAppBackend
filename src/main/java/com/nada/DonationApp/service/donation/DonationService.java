package com.nada.DonationApp.service.donation;

import com.nada.DonationApp.bo.donation.CreateDonationRequest;
import com.nada.DonationApp.entity.DonationRequestEntity;
import com.nada.DonationApp.util.enums.BloodType;
import com.nada.DonationApp.util.enums.DonationStatus;
import com.nada.DonationApp.util.enums.DonationType;

import java.util.List;
import java.util.Optional;

public interface DonationService {

    void save(CreateDonationRequest donationRequest);

    List<DonationRequestEntity> getAllDonationRequests();

    Optional<DonationRequestEntity> getDonationRequestById(Long id);

//    DonationRequestEntity updateDonationRequest(Long id, DonationStatus status);

    void deleteDonationRequest(Long id);

    List<DonationRequestEntity> filterDonations(String bloodType, String donationType, String donationStatus);


    void donationStatusChange(Long id);

}
