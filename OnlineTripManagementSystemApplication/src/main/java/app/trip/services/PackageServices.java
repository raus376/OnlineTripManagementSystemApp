package app.trip.services;

import java.util.List;

import app.trip.exceptions.PackageException;
import app.trip.models.Packages;

public interface PackageServices {
	
	// Admin functionality
	public Packages createPackage(Packages pkg,String authKey)throws PackageException;
	// Admin functionality
	public Packages updatePackage(Packages pkg,String authKey)throws PackageException;
	// Admin functionality
	public Packages deletePackage(Integer pkgId,String authKey)throws PackageException;
	public List<Packages> getAllPackages()throws PackageException;
	
}
