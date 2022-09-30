package app.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.trip.services.ReportService;
import app.trip.services.UserAuthenticationServices;

@RestController("/report")
public class ReportController {

	@Autowired
	UserAuthenticationServices services;
	
	@Autowired
	ReportService repoService;
	
//	@PostMapping("/add")
//	public ResponseEntity<String> addReportHandler(@RequestBody Report report){
//		repoService.addReport(report, null);
//		return new ResponseEntity<String>("Report Created", HttpStatus.CREATED);
//		
//	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello(){
		return new ResponseEntity<String>("Hello", HttpStatus.CHECKPOINT);
	}
	
	@GetMapping("/")
	public String helloHi() {
		return "Welcome";
	}
	
	
}
