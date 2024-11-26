package com.example.psa.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;



@Entity
@Table(name = "interests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "interest_name", nullable = false)
    private String interestName;  // e.g., "Photography", "Cooking", "Music"

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // User associated with the interest
}

