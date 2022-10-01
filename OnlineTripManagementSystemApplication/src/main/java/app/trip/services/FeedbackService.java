package app.trip.services;

import java.util.List;

import app.trip.exceptions.FeedbackException;
import app.trip.models.Feedback;


public interface FeedbackService {
	
	public Feedback addFeedback(Feedback feedback,String authKey) throws FeedbackException;
	
	public Feedback findByFeedbackId(Integer feedbackId) throws FeedbackException;
	
	public List<Feedback> findByCustomerId(Integer customerId,String authKey) throws FeedbackException;
	
	public List<Feedback> viewAllFeedbacks(String authKey) throws FeedbackException;
	
	

}
