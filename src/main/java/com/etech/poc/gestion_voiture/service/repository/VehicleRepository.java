package com.etech.poc.gestion_voiture.service.repository;

import com.etech.poc.gestion_voiture.donnee.domain.Vehicle;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bona
 */
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    Page<Vehicle> findAll(Pageable page);

    Optional<Vehicle> findByImmatriculation(String immatriculation);

}
