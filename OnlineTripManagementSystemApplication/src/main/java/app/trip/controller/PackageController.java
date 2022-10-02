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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.trip.exceptions.PackageException;
import app.trip.models.Packages;
import app.trip.services.PackageServiceProvider;

@RestController
@RequestMapping("/packages")
@CrossOrigin(origins = "*")
public class PackageController {
	
	@Autowired
	PackageServiceProvider pkgService;
	
	@GetMapping("")
	public ResponseEntity<List<Packages>> getAllPackages()throws PackageException{
		List<Packages> pkgList = pkgService.getAllPackages();
		return new ResponseEntity<List<Packages>>(pkgList,HttpStatus.OK);
	}
	@PostMapping("/createPackage")
	public ResponseEntity<Packages> addNewPackage(@Valid @RequestBody Packages pkg, @RequestParam("Authentication Key") String authKey) throws PackageException{
		Packages crePkg = pkgService.createPackage(pkg, authKey);
		return new ResponseEntity<Packages>(crePkg,HttpStatus.CREATED);
	}
	
	@PutMapping("/updatePackage")
	public ResponseEntity<Packages> updatePackage(@Valid @RequestBody Packages pkg, @RequestParam("Authentication Key") String authKey)throws PackageException{
		Packages updtPkg = pkgService.updatePackage(pkg, authKey);
		return new ResponseEntity<Packages>(updtPkg,HttpStatus.OK);
	}
	
	@DeleteMapping("/removePackage")
	public ResponseEntity<Packages> deletePackage(@RequestParam("Package ID") Integer pkdId, @RequestParam("Authentication Key") String authKey)throws PackageException{
		Packages pkg = pkgService.deletePackage(pkdId, authKey);
		return new ResponseEntity<Packages>(pkg,HttpStatus.OK);
	}
}
