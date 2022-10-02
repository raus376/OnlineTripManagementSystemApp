package app.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.trip.exceptions.FeedbackException;
import app.trip.exceptions.HotelException;
import app.trip.models.Feedback;
import app.trip.models.Hotel;
import app.trip.services.FeedbackService;

@RestController
@CrossOrigin(origins = "*")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	
	@PostMapping("/Feedback/add/{key}")
	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback,@PathVariable("key") String key)throws FeedbackException
	{
		Feedback feedbackReturned=feedbackService.addFeedback(feedback, key);
		return new ResponseEntity<Feedback>(feedbackReturned,HttpStatus.CREATED);
	}
	
	@GetMapping("/Feedback/find/{feedbackId}")
	public ResponseEntity<Feedback> findByFeedbackId(@PathVariable("feedbackId") Integer feedbackId)throws FeedbackException
	{
		Feedback feedbackReturned=feedbackService.findByFeedbackId(feedbackId);
		return new ResponseEntity<Feedback>(feedbackReturned,HttpStatus.CREATED);
	}
	
	@GetMapping("/Feedback/find/{key}/{customerId}")
	public ResponseEntity<List<Feedback>> findByCustomerId(@PathVariable("customerId") Integer customerId,@PathVariable("key") String key) throws FeedbackException
	{
		List<Feedback> feedbackReturned=feedbackService.findByCustomerId(customerId, key);
		return new ResponseEntity<List<Feedback>>(feedbackReturned,HttpStatus.CREATED);
	}
	
	@GetMapping("/Feedback/findAllFeedback/{key}")
	public ResponseEntity<List<Feedback>> viewAllFeedbacks(@PathVariable("key") String key) throws FeedbackException
	{
		List<Feedback> ansList=feedbackService.viewAllFeedbacks(key);
		return new ResponseEntity<List<Feedback>>(ansList,HttpStatus.CREATED);
	}

}
