package app.trip.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer hotelId;
	private String hotelName;
	private String hotelType;
	private String hotelDescription;
	
	private String address;
	private Integer rent;
	private String status;
	
	
	//
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Packages packages;
	
	
	
	
	
	
	
	
	
	
	

}
