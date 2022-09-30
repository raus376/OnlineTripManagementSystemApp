package app.trip.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity @Table(name = "User_Session")
public class CurrentUserLoginSession {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private Integer userId;
	private String authKey;
	private LocalDateTime sessionStartTime;
}
