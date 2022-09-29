package app.trip.repository.package_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.trip.models.travelpackages.Packages;

@Repository
public interface PackageRepository extends JpaRepository<Packages, Integer>{

}
