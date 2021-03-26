package com.etech.poc.gestion_voiture.service.metier.cud.vehicle;

import com.etech.poc.gestion_voiture.donnee.domain.Vehicle;
import java.util.List;

/**
 *
 * @author bona
 */
public interface VehicleCUDSM {

    public Vehicle save(Vehicle vehicle);

    public List<Vehicle> saveAll(List<Vehicle> Vehicles);
}
