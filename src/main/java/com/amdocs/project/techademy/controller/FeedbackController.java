package com.amdocs.project.techademy.controller;

import com.amdocs.project.techademy.model.Feedback;
import com.amdocs.project.techademy.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    // get all feedback
    @GetMapping(value = "/feedback")
    public ResponseEntity<?> getAllFeedback(){
        return new ResponseEntity(feedbackService.getAllFeedback(), HttpStatus.ACCEPTED);
    }

    // create feedback rest api
    @PostMapping("/feedback")
    public ResponseEntity<?> createFeedback(@RequestBody Feedback feedback) {
        return new ResponseEntity(feedbackService.createFeedback(feedback), HttpStatus.CREATED);
    }

    // get feedback by id rest api
    @GetMapping("/feedback/{id}")
    public ResponseEntity<?> getFeedbackById(@PathVariable int id) {
        return new ResponseEntity(feedbackService.getFeedbackById(id), HttpStatus.ACCEPTED);
    }

    // update feedback rest api
    @PutMapping("/feedback/{id}")
    public ResponseEntity<?> updateFeedback(@PathVariable int id, @RequestBody Feedback newFeedbackDetails) {
        return new ResponseEntity(feedbackService.updateByWithNewFeedback(id, newFeedbackDetails), HttpStatus.ACCEPTED);
    }

    // delete feedback rest api
    @DeleteMapping("/feedback/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable int id){
        return new ResponseEntity(feedbackService.deleteFeedback(id), HttpStatus.GONE);
    }
}
