package app.trip.services.package_services;

import java.util.List;

import app.trip.exceptions.package_exceptions.PackageException;
import app.trip.models.travelpackages.Packages;

public interface PackageServices {
	
	// Admin functionality
	public Packages createPackage(Packages pkg,String authKey)throws PackageException;
	// Admin functionality
	public Packages updatePackage(Packages pkg,String authKey)throws PackageException;
	
	public List<Packages> getAllPackages()throws PackageException;
}
