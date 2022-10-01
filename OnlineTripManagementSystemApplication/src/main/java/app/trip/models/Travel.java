package app.trip.models;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;


@Entity
@Table(name="Travels")
@Data
public class Travel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer travelId;
	
//	@Size(min=3,max=9,message="length should be atleat 3 character")
	private String travelName;
	
//	@Size(min=3,max=10,message="{name.invalid}")
	private String agentName;
	
	@Embedded
	private Address addr;
	
	private Integer contact;
	
//	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="tDetails",fetch=FetchType.EAGER)
	private Set<Bus> buses;
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Travel other = (Travel) obj;
		return Objects.equals(addr, other.addr) && Objects.equals(agentName, other.agentName)
				&& Objects.equals(contact, other.contact) && Objects.equals(travelId, other.travelId)
				&& Objects.equals(travelName, other.travelName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(addr, agentName, contact, travelId, travelName);
	}
	
	
	
	

}
