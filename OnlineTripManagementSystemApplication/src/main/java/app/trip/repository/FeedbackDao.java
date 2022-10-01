package app.trip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.trip.exceptions.FeedbackException;
import app.trip.models.Feedback;


@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer>{

	@Query("select f from Feedback f")
	public List<Feedback> getAllFeedbacks() throws FeedbackException;
}
