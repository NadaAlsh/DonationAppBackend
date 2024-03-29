package com.nada.DonationApp.service.user;

import com.nada.DonationApp.entity.UserEntity;
import com.nada.DonationApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity updateUserProfile(Long id, String newEmail, String newPhoneNumber, String newUsername, String newPassword) {
        UserEntity user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Donation request not found"));

        if (newEmail != null) {
            user.setEmail(newEmail);
        }

        if (newPhoneNumber != null) {
            user.setPhoneNumber(newPhoneNumber);
        }
        if (newUsername != null) {
            user.setUsername(newUsername);
        }
        if (newPassword != null) {
            user.setPassword(newPassword);
        }

        return userRepository.save(user);
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }
}

//    private final UserRepository userRepository;
//
//    private final DonationStatusRepository donationStatusRepository;
//    private final DonationTypeRepository donationTypeRepository;
//    private final ResearchResultRepository researchResultRepository;
//
//    public UserServiceImpl(UserRepository userRepository, DonationStatusRepository donationStatusRepository, DonationTypeRepository donationTypeRepository, ResearchResultRepository researchResultRepository) {
//        this.userRepository = userRepository;
//        this.donationStatusRepository = donationStatusRepository;
//        this.donationTypeRepository = donationTypeRepository;
//        this.researchResultRepository = researchResultRepository;
//    }
//
//
//    @Override
//    public void saveUser(CreateUserRequest createUserRequest) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setFullName(createUserRequest.getFullName());
//        userEntity.setUsername(createUserRequest.getUsername());
//        userEntity.setEmail(createUserRequest.getEmail());
//        userEntity.setPassword(createUserRequest.getPassword());
//        userEntity.setPhoneNumber(createUserRequest.getPhoneNumber());
//        userEntity.setAge(createUserRequest.getAge());
//        userRepository.save(userEntity);
//    }
//
//    @Override
//    public void updateUserStatus(Long userId, UpdateUserRequest updateUserStatusRequest) {
//        Optional<UserEntity> optionalUser = userRepository.findById(userId);
//        if (optionalUser.isPresent()) {
//            UserEntity userEntity = optionalUser.get();
//            userRepository.save(userEntity);
//        } else {
//            throw new RuntimeException("User not found");
//        }
//    }
//
////    @Override
////    public void updateUserStatus(String bloodType, UpdateUserRequest updateUserRequest) {
////        UserEntity userEntity = userRepository.findByBloodType(bloodType)
////                .orElseThrow();
////        if (!updateUserRequest.getDonationStatus().equals("DONATED") && !updateUserRequest.getDonationStatus().equals("SUPPORT_NEEDED")) {
////            throw new IllegalArgumentException("Status should be written either DONATED or SUPPORT_NEEDED");
////
////        }
////        userEntity.setDonationStatus(DonationStatus.valueOf(updateUserRequest.getDonationStatus()));
////        userRepository.save(userEntity);
////    }
//
//    @Override
//    public void deleteUserById(Long userId) {
//        userRepository.deleteById(userId);
//    }
//
//    @Override
//    public List<String> getALlUsersWithStrongPassword() {
//        return userRepository.findAll().stream()
//                .filter(user -> user.getPassword().length() > 8)
//                .map(UserEntity::getUsername)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<UserProfileResponse> getAllUserProfiles() {
//        return null;
//    }
//
//    @Override
//    public UserProfileResponse getUserInfo(Long userId) {
//        Optional<UserEntity> optionalUser = userRepository.findById(userId);
//        if (optionalUser.isPresent()) {
//            UserEntity userEntity = optionalUser.get();
//            UserProfileResponse userProfileResponse = new UserProfileResponse();
//            userProfileResponse.setEmail(userEntity.getEmail());
//            userProfileResponse.setUsername(userEntity.getUsername());
//            userProfileResponse.setUsername(userEntity.getUsername());
//            userProfileResponse.setFileNumber(userEntity.getFileNumber());
//            return userProfileResponse;
//        } else {
//            throw new RuntimeException("User not found");
//        }
//
//    }
//
//    public Optional<UserEntity> findByBloodType(BloodType bloodType){
//        return userRepository.findByBloodType(bloodType.toString());
//    }


