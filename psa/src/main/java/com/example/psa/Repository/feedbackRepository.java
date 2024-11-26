package com.example.psa.Repository;


import com.example.psa.Entity.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface feedbackRepository extends JpaRepository<FeedBack, Long> {
    FeedBack findByInteractionId(Long interactionId);
}



