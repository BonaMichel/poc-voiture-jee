package com.etech.poc.gestion_voiture.service.metier.cud.vehicle;

import com.etech.poc.gestion_voiture.donnee.domain.Vehicle;
import com.etech.poc.gestion_voiture.service.repository.VehicleRepository;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bona
 */
@Service
public class VehicleCUDSMImpl implements VehicleCUDSM {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle save(Vehicle vehicle) {
        if (StringUtils.isEmpty(vehicle.getId())) {
            String id = UUID.randomUUID().toString();
            vehicle.setId(id);
        }
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> saveAll(List<Vehicle> Vehicles) {
        return vehicleRepository.saveAll(Vehicles);
    }
}
