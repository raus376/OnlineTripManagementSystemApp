package app.trip.models;

import java.sql.Date;

import jakarta.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedbackId;
	private String feedbackString;
	private double rating;
	private Date date;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

}
