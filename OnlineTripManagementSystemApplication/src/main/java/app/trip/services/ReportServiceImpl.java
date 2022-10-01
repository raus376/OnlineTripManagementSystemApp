package app.trip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.trip.exceptions.InvalidTicketException;
import app.trip.exceptions.PackageException;
import app.trip.exceptions.ReportException;
import app.trip.models.CurrentUserLoginSession;
import app.trip.models.Packages;
import app.trip.models.Report;
import app.trip.models.Ticket;
import app.trip.repository.PackageRepository;
import app.trip.repository.ReportRepository;
import app.trip.repository.SessionRepository;
import app.trip.repository.UserRepository;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	PackageRepository pkgRepo;
	
	@Autowired
	SessionRepository sessionRepo;
	
	@Autowired
	ReportRepository reportRepo;
	
	@Autowired
	UserRepository userRepo;

	@Override
	public Report addReport(Report report, String authKey) throws ReportException {
		Optional<CurrentUserLoginSession> curUser = sessionRepo.findByAuthkey(authKey);
		String userType = userRepo.findById(curUser.get().getUserId()).get().getUserType();
		if(userType.equalsIgnoreCase("user")) {
			throw new ReportException("Unauthorized Request...");
		}
		else {
			return reportRepo.save(report);
		}
	}

	@Override
	public Report deleteReport(Integer reportId, String authKey) throws ReportException {
		Optional<CurrentUserLoginSession> curUser = sessionRepo.findByAuthkey(authKey);
		String userType = userRepo.findById(curUser.get().getUserId()).get().getUserType();
		if(userType.equalsIgnoreCase("user")) {
			throw new ReportException("Unauthorized Request...");
		}
		Optional<Report> reportOpt =  reportRepo.findById(reportId);
		if(!reportOpt.isPresent()) {
			throw new ReportException("Report not exist...");
		}
		reportRepo.deleteById(reportId);
		return reportOpt.get();
	}
	

	@Override
	public List<Report> viewAllReports(String authKey) throws ReportException {
		Optional<CurrentUserLoginSession> curUser = sessionRepo.findByAuthkey(authKey);
		String userType = userRepo.findById(curUser.get().getUserId()).get().getUserType();
		if(userType.equalsIgnoreCase("user")) {
			throw new ReportException("Unauthorized Request...");
		}
		else {
			return reportRepo.findAll();
		}
	
	}

}
