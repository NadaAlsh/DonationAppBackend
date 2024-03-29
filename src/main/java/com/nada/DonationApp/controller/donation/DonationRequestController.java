package com.nada.DonationApp.controller.donation;

import com.nada.DonationApp.bo.donation.CreateDonationRequest;
import com.nada.DonationApp.entity.DonationRequestEntity;
import com.nada.DonationApp.entity.UserEntity;
import com.nada.DonationApp.service.user.UserServiceImpl;
import com.nada.DonationApp.service.donation.DonationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/donation")
public class DonationRequestController {

    @Autowired
    private DonationServiceImpl donationService;

    private UserServiceImpl userService;

    public DonationRequestController(DonationServiceImpl donationService, UserServiceImpl userService) {
        this.userService = userService;
        this.donationService = donationService;
    }

    @GetMapping("/getAllRequests")
    public ResponseEntity<List<DonationRequestEntity>> getAllDonationRequests(){
        List<DonationRequestEntity> donationRequests = donationService.getAllDonationRequests();
        return new ResponseEntity<>(donationRequests, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createDonationRequest(@RequestBody CreateDonationRequest donation){
        donationService.save(donation);
        return ResponseEntity.ok("Donation Request successfully created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonationRequestEntity> getDonationRequestById(@PathVariable("id") Long id){
        return donationService.getDonationRequestById(id)
                .map(donationEntity -> new ResponseEntity<>(donationEntity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
       // Optional<DonationEntity> request = donationRequestService.getDonationRequestById(id);
    }


    @PutMapping("/{id}/updateProfile")
    public ResponseEntity<UserEntity> updateUserProfile(@PathVariable("id") Long id, @RequestParam String newEmail, String newPhoneNumber, String newUsername, String newPassword){
        UserEntity updatedRequest = userService.updateUserProfile(id, newEmail, newPhoneNumber, newUsername, newPassword);
        return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
    }


    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteDonationRequest(@PathVariable("id") Long id){
        donationService.deleteDonationRequest(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}/update-status")
    public ResponseEntity<?> donationStatusChange(@PathVariable Long id){
        donationService.donationStatusChange(id);
        return ResponseEntity.ok("Donation Status Updated");
    }

    @GetMapping("/filter")
    public List<DonationRequestEntity> filterDonations(
            @RequestParam(required = false) String bloodType,
            @RequestParam(required = false) String donationType,
            @RequestParam(required = false) String donationStatus) {

        return donationService.filterDonations(bloodType, donationType, donationStatus);
    }
}
