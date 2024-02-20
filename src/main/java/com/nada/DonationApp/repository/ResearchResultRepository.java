package com.nada.DonationApp.repository;

import com.nada.DonationApp.entity.ResearchResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResearchResultRepository extends JpaRepository<ResearchResultEntity, Long> {

    @Query(value = "SELECT * FROM researchResult r where r.title= : title",nativeQuery = true)
    Optional<ResearchResultEntity> findResearchEntityByTitle(String title);
}
