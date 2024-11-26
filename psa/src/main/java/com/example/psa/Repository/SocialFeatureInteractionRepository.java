package com.example.psa.Repository;

import com.example.psa.Entity.SocialFeatureInteraction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialFeatureInteractionRepository extends JpaRepository<SocialFeatureInteraction, Long> {
    List<SocialFeatureInteraction> findByUserId(Long userId);
}

