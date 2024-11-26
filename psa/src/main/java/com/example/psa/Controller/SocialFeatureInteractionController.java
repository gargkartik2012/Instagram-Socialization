package com.example.psa.Controller;


import com.example.psa.Entity.FeedBack;
import com.example.psa.Entity.SocialFeatureInteraction;
import com.example.psa.Service.SocialFeatureInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/social-feature")  // Base URL for this feature
public class SocialFeatureInteractionController {

    @Autowired
    private SocialFeatureInteractionService interactionService;

    // Create a new social interaction between two users
    @PostMapping("/interactions")
    public ResponseEntity<SocialFeatureInteraction> createInteraction(@RequestBody SocialFeatureInteraction interaction) {
        SocialFeatureInteraction createdInteraction = interactionService.createInteraction(interaction);
        return ResponseEntity.ok(createdInteraction);
    }

    // Get all interactions of a specific user
    @GetMapping("/interactions/{userId}")
    public ResponseEntity<List<SocialFeatureInteraction>> getInteractionsByUser(@PathVariable Long userId) {
        List<SocialFeatureInteraction> interactions = interactionService.getInteractionsByUser(userId);
        return ResponseEntity.ok(interactions);
    }

    // Get a specific interaction by interaction ID
    @GetMapping("/interaction/{id}")
    public ResponseEntity<Optional<SocialFeatureInteraction>> getInteractionById(@PathVariable Long id) {
        Optional<SocialFeatureInteraction> interaction = interactionService.getInteractionById(id);
        return ResponseEntity.ok(interaction);
    }

    // Update interaction feedback
    @PostMapping("/interactions/{id}/feedback")
    public ResponseEntity<SocialFeatureInteraction> addFeedback(
            @PathVariable Long id,
            @RequestBody FeedBack feedback) {
        SocialFeatureInteraction updatedInteraction = interactionService.addFeedbackToInteraction(id, feedback);
        return ResponseEntity.ok(updatedInteraction);
    }

    // Get feedback for an interaction
    @GetMapping("/interactions/{id}/feedback")
    public ResponseEntity<FeedBack> getFeedback(@PathVariable Long id) {
        FeedBack feedback = interactionService.getFeedbackByInteractionId(id);
        return ResponseEntity.ok(feedback);
    }

    // Delete an interaction
    @DeleteMapping("/interactions/{id}")
    public ResponseEntity<Void> deleteInteraction(@PathVariable Long id) {
        interactionService.deleteInteraction(id);
        return ResponseEntity.noContent().build();
    }
}

