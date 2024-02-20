package com.nada.DonationApp.controller.donation;

import com.nada.DonationApp.bo.donation.CreateDonationRequest;
import com.nada.DonationApp.entity.DonationRequestEntity;
import com.nada.DonationApp.util.enums.DonationStatus;
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

    public DonationRequestController(DonationServiceImpl donationService) {
        this.donationService = donationService;
    }

    @GetMapping
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

    //@PutMapping("/update")
    @PutMapping("/{id}/status")
    public ResponseEntity<DonationRequestEntity> updateDonationRequest(@PathVariable("id") Long id, @RequestParam("Donation Status")DonationStatus status){
        DonationRequestEntity updatedRequest = donationService.updateDonationRequest(id, status);
        return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteDonationRequest(@PathVariable("id") Long id){
        donationService.deleteDonationRequest(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
