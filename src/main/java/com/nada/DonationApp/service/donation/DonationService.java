package com.nada.DonationApp.service.donation;

import com.nada.DonationApp.bo.donation.CreateDonationRequest;
import com.nada.DonationApp.entity.DonationRequestEntity;
import com.nada.DonationApp.util.enums.DonationStatus;

import java.util.List;
import java.util.Optional;

public interface DonationService {

    void save(CreateDonationRequest donationRequest);

    List<DonationRequestEntity> getAllDonationRequests();

    Optional<DonationRequestEntity> getDonationRequestById(Long id);

    DonationRequestEntity updateDonationRequest(Long id, DonationStatus status);

    void deleteDonationRequest(Long id);
}
