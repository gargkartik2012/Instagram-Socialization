package com.example.psa.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity
@Table(name = "feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "interaction_id", nullable = false)
    private SocialFeatureInteraction interaction;  // Reference to the interaction

    @Column(name = "feedback_text")
    private String feedbackText;  // User feedback text

    @Column(name = "feedback_score", nullable = false)
    private Float feedbackScore;  // Rating score, e.g., 1 to 5

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;  // When feedback was provided
}

