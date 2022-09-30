package app.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.trip.models.Packages;

@Repository
public interface PackageRepository extends JpaRepository<Packages, Integer>{

}
