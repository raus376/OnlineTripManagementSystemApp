package app.trip.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Bus")
public class Bus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer busId;
	
	private BusType busType;
	
	private Integer busNo;
	
	private Integer capacity=60;
	
	@ManyToOne(cascade=CascadeType.ALL)
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
