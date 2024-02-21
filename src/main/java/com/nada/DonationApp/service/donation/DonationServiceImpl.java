package com.nada.DonationApp.service.donation;

import com.nada.DonationApp.bo.donation.CreateDonationRequest;
import com.nada.DonationApp.entity.DonationRequestEntity;
import com.nada.DonationApp.entity.DonationStatusEntity;
import com.nada.DonationApp.entity.DonationTypeEntity;
import com.nada.DonationApp.entity.UserEntity;
import com.nada.DonationApp.util.enums.BloodType;
import com.nada.DonationApp.util.enums.DonationStatus;
import com.nada.DonationApp.repository.DonationRequestRepository;
import com.nada.DonationApp.repository.DonationStatusRepository;
import com.nada.DonationApp.repository.DonationTypeRepository;
import com.nada.DonationApp.repository.UserRepository;
import com.nada.DonationApp.service.auth.UserDetailUtil;
import com.nada.DonationApp.util.enums.DonationType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DonationServiceImpl implements DonationService{

    private final DonationRequestRepository donationRequestRepository;

    private final DonationTypeRepository donationTypeRepository;

    private final DonationStatusRepository donationStatusRepository;

    private final UserRepository userRepository;
    public DonationServiceImpl(DonationRequestRepository donationRequestRepository, DonationTypeRepository donationTypeRepository, DonationStatusRepository donationStatusRepository, UserRepository userRepository) {
        this.donationRequestRepository = donationRequestRepository;
        this.donationTypeRepository = donationTypeRepository;
        this.donationStatusRepository = donationStatusRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void save(CreateDonationRequest donationRequest) {
        DonationTypeEntity donationTypeEntity=donationTypeRepository
                .findByDonationType(donationRequest.getDonationType());
        DonationStatusEntity donationStatusEntity= donationStatusRepository
                .findByDonationStatus(DonationStatus.SUPPORT_NEEDED.name());
        UserEntity userEntity=userRepository.findById(UserDetailUtil.userDetails().getId())
                .orElseThrow();
        DonationRequestEntity donationRequestEntity= new DonationRequestEntity();
        donationRequestEntity.setFileNumber(donationRequest.getFileNumber());
        donationRequestEntity.setDonationTypeEntity(donationTypeEntity);
        donationRequestEntity.setDonationStatusEntity(donationStatusEntity);
        donationRequestEntity.setUserEntity(userEntity);
        donationRequestEntity.setResearchPurposeDonation(donationRequest.getResearchPurposeDonation());
        donationRequestEntity.setBloodType(String.valueOf(userEntity.getBloodType()));
        //donationRequestEntity.setGender(String.valueOf(userEntity.getGender()));
        donationRequestRepository.save(donationRequestEntity);
    }

    @Override
    public List<DonationRequestEntity> getAllDonationRequests() {

        return donationRequestRepository.findAll();
    }

    @Override
    public Optional<DonationRequestEntity> getDonationRequestById(Long id) {
        return Optional.empty();
    }



    @Override
    public void deleteDonationRequest(Long id) {
        donationRequestRepository.deleteById(id);
    }




    public void donationStatusChange(Long id){
        Optional<DonationStatusEntity> donationStatus = donationStatusRepository.findById(id);
        if (donationStatus.isPresent()){
            DonationStatusEntity donationStatusEntity = donationStatus.get();
            donationStatusEntity.setDonationStatus(DonationStatus.DONATED);
            donationStatusRepository.save(donationStatusEntity);
        } else {
            throw new EntityNotFoundException("Donation not found");
        }
    }
  @Override
    public List<DonationRequestEntity> filterDonations(String bloodType, String donationType, String donationStatus){

        Specification<DonationRequestEntity> specification = Specification.where(null);
        if (bloodType != null){
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("bloodType"), bloodType));
        }
        if (donationType != null){
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("donationType"), donationType));
        }
        if (donationStatus != null){
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("donationStatus"), donationStatus));
        }
        return donationRequestRepository.findAll((Sort) specification);
    }


}
