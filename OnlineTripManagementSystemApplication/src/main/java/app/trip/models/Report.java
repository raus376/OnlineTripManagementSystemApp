package app.trip.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reportId;
	private String reportName;
	private String reportType;
}