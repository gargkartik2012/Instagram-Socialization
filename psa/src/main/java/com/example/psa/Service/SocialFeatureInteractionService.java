package com.example.psa.Service;

import com.example.psa.Entity.FeedBack;
import com.example.psa.Entity.SocialFeatureInteraction;
import com.example.psa.Repository.SocialFeatureInteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocialFeatureInteractionService {

    @Autowired
    private SocialFeatureInteractionRepository interactionRepository;

    @Autowired
   private com.example.psa.Repository.feedbackRepository feedbackRepository;
    public SocialFeatureInteraction createInteraction(SocialFeatureInteraction interaction) {
        return interactionRepository.save(interaction);
    }

    public List<SocialFeatureInteraction> getInteractionsByUser(Long userId) {
        return interactionRepository.findByUserId(userId);
    }

    public Optional<SocialFeatureInteraction> getInteractionById(Long id) {
        return interactionRepository.findById(id);
    }

    public SocialFeatureInteraction addFeedbackToInteraction(Long interactionId, FeedBack feedback) {
        Optional<SocialFeatureInteraction> interaction = interactionRepository.findById(interactionId);
        if (interaction.isPresent()) {
            feedback.setInteraction(interaction.get());
            feedbackRepository.save(feedback);
            return interactionRepository.save(interaction.get());
        }
        return null;
    }

    public FeedBack getFeedbackByInteractionId(Long interactionId) {
        return feedbackRepository.findByInteractionId(interactionId);
    }

    public void deleteInteraction(Long id) {
        interactionRepository.deleteById(id);
    }
}

