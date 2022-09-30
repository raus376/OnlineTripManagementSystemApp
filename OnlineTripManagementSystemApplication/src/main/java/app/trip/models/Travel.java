package app.trip.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Travels")
public class Travel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer travelId;
	
	private String travelName;
	
	private String agentName;
	
	@Embedded
	private Address addr;
	
	private Integer contact;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Bus> buses;
	
	

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Travel other = (Travel) obj;
//		return Objects.equals(addr, other.addr) && Objects.equals(agentName, other.agentName)
//				&& Objects.equals(contact, other.contact) && Objects.equals(travelId, other.travelId)
//				&& Objects.equals(travelName, other.travelName);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(addr, agentName, contact, travelId, travelName);
//	}
	
	
	
	

}
