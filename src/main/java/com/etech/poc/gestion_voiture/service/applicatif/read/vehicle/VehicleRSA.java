package com.etech.poc.gestion_voiture.service.applicatif.read.vehicle;

import com.etech.poc.gestion_voiture.donnee.dto.VehicleDTO;
import com.etech.poc.gestion_voiture.donnee.dto.VehicleVisitorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author bona
 */
public interface VehicleRSA {

    public Page<VehicleVisitorDTO> findAll(Pageable page);

    public VehicleDTO findById(String id);

    public VehicleDTO findByImmatriculation(String immatriculation);
}
