package app.trip.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.trip.exceptions.ReportException;
import app.trip.models.Report;
import app.trip.services.ReportService;
import app.trip.services.UserAuthenticationServices;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class ReportController {

	@Autowired
	UserAuthenticationServices services;
	
	@Autowired
	ReportService repoService;
	
	/*
	 * Show all reports
	 */
	
	@GetMapping("/reports")
	public ResponseEntity<List<Report>> getAllReports(@RequestParam(required = false) Integer reportId,@RequestParam(required = false) String authKey) throws ReportException {
		List<Report> reports = null;
		
		reports = repoService.viewAllReports(authKey);
				
		return new ResponseEntity<List<Report>>(reports,HttpStatus.FOUND);
	}
	/*
	 * Create a report
	 */
	
	@PostMapping("/addReport")
	public ResponseEntity<Report> createReport(@Valid @RequestBody Report report,  @RequestParam String authKey) throws ReportException {
		Report createdReport = null;
		
		createdReport = repoService.addReport(report, authKey);
		
		return new ResponseEntity<Report>(createdReport,HttpStatus.CREATED);
	}
	
	/*
	 * Delete a report
	 */
	@DeleteMapping("/removeReport")
	public ResponseEntity<Report> deleteTicket(@RequestParam Integer reportId,  @RequestParam String authKey) throws ReportException {
		Report report = null;
		
		report = repoService.deleteReport(reportId, authKey);
		
		return new ResponseEntity<Report>(report,HttpStatus.OK);
	}
}
