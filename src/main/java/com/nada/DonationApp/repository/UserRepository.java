package com.nada.DonationApp.repository;

import com.nada.DonationApp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

   // Optional<UserEntity> findByFileNumber(String fileNumber);
    Optional<UserEntity> findByBloodType(String bloodType);

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByPhoneNumber(String phoneNumber);

    UserEntity save(UserEntity user);

}
