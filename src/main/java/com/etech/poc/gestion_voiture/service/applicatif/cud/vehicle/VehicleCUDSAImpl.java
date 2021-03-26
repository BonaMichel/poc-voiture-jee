package com.etech.poc.gestion_voiture.service.applicatif.cud.vehicle;

import com.etech.poc.gestion_voiture.contrainte.mapper.VehicleMapper;
import com.etech.poc.gestion_voiture.donnee.domain.Vehicle;
import com.etech.poc.gestion_voiture.donnee.dto.VehicleDTO;
import com.etech.poc.gestion_voiture.service.metier.cud.vehicle.VehicleCUDSM;
import com.etech.poc.gestion_voiture.service.metier.read.vehicle.VehicleRSM;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bona
 */
@Service
public class VehicleCUDSAImpl implements VehicleCUDSA {

    @Autowired
    private VehicleCUDSM vehicleCUDSM;

    @Autowired
    private VehicleRSM vehicleRSM;

    @Autowired
    private VehicleMapper mapper;

    @PostConstruct
    private void initVehicle() {
        List<Vehicle> vehicles = vehicleRSM.findAll();
        if (vehicles.isEmpty()) {
            vehicles = new ArrayList<>();
            List<String> proprietaire = Arrays.asList("john doe", "julien gaï", "matiace legran", "nathan cary", "marry vial");
            for (String item : proprietaire) {
                Vehicle data = new Vehicle();
                data.setId(UUID.randomUUID().toString());
                data.setImmatriculation("AA-1" + proprietaire.indexOf(item) + "2-BC" + proprietaire.indexOf(item));
                data.setMark("Sprinter");
                data.setModel("31" + proprietaire.indexOf(item) + " CDI");
                data.setProprietaire(item);
                data.setUrlImage("");

                Date now = new Date();
                data.setCreatedAt(now);
                data.setUpdatedAt(now);
                vehicles.add(data);
            }
            vehicleCUDSM.saveAll(vehicles);
        }
    }

    @Override
    public VehicleDTO addVehicule(VehicleDTO dto) {
        Vehicle data = vehicleCUDSM.save(mapper.toDO(dto));
        return mapper.toDTO(data);
    }
}
