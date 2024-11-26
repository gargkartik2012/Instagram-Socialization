package com.example.psa.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;


import java.time.LocalDateTime;

@Entity
@Table(name = "social_feature_interactions")
@Data // Lombok annotation that generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all fields
@Builder // Adds a builder pattern for object creation
public class SocialFeatureInteraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;  // The user initiating the interaction

    @Column(name = "stranger_id", nullable = false)
    private Long strangerId;  // The stranger with whom interaction is happening

    @Column(name = "interaction_type", nullable = false)
    private String interactionType;  // Chat, Follow, Comment, etc.

    @Column(name = "common_interests")
    private String commonInterests;  // Interests that connect the two users

    @Column(name = "engagement_start_time", nullable = false)
    private LocalDateTime engagementStartTime;  // When the interaction started

    @Column(name = "user_persona", nullable = false)
    private String userPersona;  // User persona (e.g., casual user, influencer)

    @Column(name = "interaction_status", nullable = false)
    private String interactionStatus;  // Active, Blocked, Muted, etc.

    @Column(name = "interaction_frequency")
    private int interactionFrequency;  // Frequency of messages, likes, or other interactions

    @Column(name = "feedback_score")
    private Float feedbackScore;  // Rating of the interaction from the user

    @Column(name = "kpi_value")
    private String kpiValue;  // KPIs like engagement duration, message count



}

