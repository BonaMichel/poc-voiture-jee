package com.etech.poc.gestion_voiture.service.metier.read.vehicle;

import com.etech.poc.gestion_voiture.donnee.domain.Vehicle;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author bona
 */
public interface VehicleRSM {

    public List<Vehicle> findAll();

    public Page<Vehicle> findAll(Pageable page);

    public Vehicle findById(String id);

    public Vehicle findByImmatriculation(String immatriculation);
}
