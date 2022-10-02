package app.trip.services;

import java.util.List;

import app.trip.exceptions.ReportException;
import app.trip.models.Report;

public interface ReportService {

	/*
	 * All Functions ->
	 * Administrator Access
	 */
	public Report addReport(Report report, String authKey) throws ReportException;
	public List<Report> viewAllReports(String authKey) throws ReportException;
	public Report deleteReport(Integer reportId, String authKey) throws ReportException;
	
}
