package com.etech.poc.gestion_voiture.service.applicatif.read.vehicle;

import com.etech.poc.gestion_voiture.contrainte.error.ErrorsEnum;
import com.etech.poc.gestion_voiture.contrainte.error.FunctionalException;
import com.etech.poc.gestion_voiture.contrainte.mapper.VehicleMapper;
import com.etech.poc.gestion_voiture.donnee.domain.Vehicle;
import com.etech.poc.gestion_voiture.donnee.dto.VehicleDTO;
import com.etech.poc.gestion_voiture.donnee.dto.VehicleVisitorDTO;
import com.etech.poc.gestion_voiture.service.metier.read.vehicle.VehicleRSM;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author bona
 */
@Service
public class VehicleRSAImpl implements VehicleRSA {

    @Autowired
    private VehicleRSM vehicleRSM;

    @Autowired
    private VehicleMapper mapper;

    @Override
    public Page<VehicleVisitorDTO> findAll(Pageable page) {
        Page<Vehicle> vehicles = vehicleRSM.findAll(page);
        return mapper.toPageVehicleVisitorDTO(vehicles, page);
    }

    @Override
    public VehicleDTO findById(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new FunctionalException(ErrorsEnum.ERR_ID_VEHICLE);
        }
        Vehicle vehicle = vehicleRSM.findById(id);
        return mapper.toDTO(vehicle);
    }

    @Override
    public VehicleDTO findByImmatriculation(String immatriculation) {
        if (StringUtils.isEmpty(immatriculation)) {
            throw new FunctionalException(ErrorsEnum.ERR_IMM_VEHICLE);
        }
        Vehicle vehicle = vehicleRSM.findByImmatriculation(immatriculation);
        return mapper.toDTO(vehicle);
    }

}
