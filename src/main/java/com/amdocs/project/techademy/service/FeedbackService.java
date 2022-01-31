package com.amdocs.project.techademy.service;

import com.amdocs.project.techademy.model.Feedback;

import java.util.List;

public interface FeedbackService {

    /**
     * @return list of all feedback
     */
    List<Feedback> getAllFeedback();

    /**
     * @param id
     * @return true if feedback with input id is deleted
     */
    boolean deleteFeedback(int id);

    /**
     * @param id
     * @param feedback
     * @return
     */
    Feedback updateByWithNewFeedback(int id, Feedback feedback);

    /**
     * @param id
     * @return
     */
    Feedback getFeedbackById(int id);

    /**
     * @param feedback
     * @return
     */
    Feedback createFeedback(Feedback feedback);
}
