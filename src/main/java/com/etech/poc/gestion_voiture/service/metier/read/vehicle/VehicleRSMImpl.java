package com.etech.poc.gestion_voiture.service.metier.read.vehicle;

import com.etech.poc.gestion_voiture.donnee.domain.Vehicle;
import com.etech.poc.gestion_voiture.service.repository.VehicleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author bona
 */
@Service
public class VehicleRSMImpl implements VehicleRSM {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Page<Vehicle> findAll(Pageable page) {
        return vehicleRepository.findAll(page);
    }

    @Override
    public Vehicle findById(String id) {
        Optional<Vehicle> optVehic = vehicleRepository.findById(id);
        if (optVehic.isPresent()) {
            return optVehic.get();
        }
        return null;
    }

    @Override
    public Vehicle findByImmatriculation(String immatriculation) {
        Optional<Vehicle> optVehic = vehicleRepository.findByImmatriculation(immatriculation);
        if (optVehic.isPresent()) {
            return optVehic.get();
        }
        return null;
    }

}
