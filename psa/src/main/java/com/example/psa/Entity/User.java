package com.example.psa.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;  // Instagram username

    @Column(name = "full_name", nullable = false)
    private String fullName;  // Full name of the user

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "persona")
    private String persona;  // Persona: Casual User, Influencer, Professional, etc.

    @Column(name = "bio")
    private String bio;  // Short bio or description about the user

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;  // URL to the profile picture
}
