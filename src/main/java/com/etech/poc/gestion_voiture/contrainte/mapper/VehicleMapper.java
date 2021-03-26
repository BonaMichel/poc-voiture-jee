package com.etech.poc.gestion_voiture.contrainte.mapper;

import com.etech.poc.gestion_voiture.donnee.domain.Vehicle;
import com.etech.poc.gestion_voiture.donnee.dto.VehicleDTO;
import com.etech.poc.gestion_voiture.donnee.dto.VehicleVisitorDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author bona
 */
@Mapper(componentModel = "spring")
public interface VehicleMapper {

    Vehicle toDO(VehicleDTO dto);

    VehicleDTO toDTO(Vehicle data);

    VehicleVisitorDTO toVisitorDTO(Vehicle data);

    List<VehicleVisitorDTO> toListVehicleVisitorDTO(List<Vehicle> datas);

    default Page<VehicleVisitorDTO> toPageVehicleVisitorDTO(Page<Vehicle> datas, Pageable page) {
        List<VehicleVisitorDTO> vehiclesDTO = toListVehicleVisitorDTO(datas.getContent());
        return new PageImpl<>(vehiclesDTO, page, datas.getTotalElements());
    }
}
