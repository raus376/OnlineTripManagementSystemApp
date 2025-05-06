package app.trip.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "Bus")
@Data
@ToString
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busId;

	@Enumerated(EnumType.STRING)
	private BusType busType;

	private Integer busNo;

	private Integer capacity;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Travel tDetails;


//	public Integer getBusId() {
//		return busId;
//	}
//
//	public void setBusId(Integer busId) {
//		this.busId = busId;
//	}
//
//	public BusType getBusType() {
//		return busType;
//	}
//
//	public void setBusType(BusType busType) {
//		this.busType = busType;
//	}
//
//	public Integer getBusNo() {
//		return busNo;
//	}
//
//	public void setBusNo(Integer busNo) {
//		this.busNo = busNo;
//	}
//
//	public Integer getCapacity() {
//		return capacity;
//	}
//
//	public void setCapacity(Integer capacity) {
//		this.capacity = capacity;
//	}
//
//	public Travel gettDetails() {
//		return tDetails;
//	}
//
//	public void settDetails(Travel tDetails) {
//		this.tDetails = tDetails;
//	}
//    
//    

}
