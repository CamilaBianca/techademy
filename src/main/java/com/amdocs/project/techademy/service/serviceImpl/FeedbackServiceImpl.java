package com.amdocs.project.techademy.service.serviceImpl;

import com.amdocs.project.techademy.exception.ResourceNotFoundException;
import com.amdocs.project.techademy.model.Feedback;
import com.amdocs.project.techademy.repository.FeedbackRepository;
import com.amdocs.project.techademy.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback getFeedbackById(int id) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Feedback not found with id " +id));

        return feedback;
    }


    @Override
    public Feedback updateByWithNewFeedback(int id, Feedback feedbackDetails) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Feedback not found with id " +id));

        feedback.setFeedback(feedbackDetails.getFeedback());
        feedback.setName(feedbackDetails.getName());
        feedback.setUser(feedbackDetails.getUser());
        feedback.setEmail(feedbackDetails.getEmail());

        Feedback feedbackUpdate = feedbackRepository.save(feedback);
        return feedbackUpdate;
    }

    @Override
    public boolean deleteFeedback(int id) {
        boolean isDeleted = true;

        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Feedback not found with id " +id));

        feedbackRepository.delete(feedback);
        if(feedback == null){
            isDeleted = false;
        }
        return isDeleted;
    }

}
