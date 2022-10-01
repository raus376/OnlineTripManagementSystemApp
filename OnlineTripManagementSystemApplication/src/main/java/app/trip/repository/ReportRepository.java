package app.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.trip.models.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{
	
}
