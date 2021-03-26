package com.etech.poc.gestion_voiture.contrainte.mapper;

import com.etech.poc.gestion_voiture.donnee.domain.Vehicle;
import com.etech.poc.gestion_voiture.donnee.dto.VehicleDTO;
import com.etech.poc.gestion_voiture.donnee.dto.VehicleVisitorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-26T11:48:15+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
@Component
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public Vehicle toDO(VehicleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setId( dto.getId() );
        vehicle.setProprietaire( dto.getProprietaire() );
        vehicle.setModel( dto.getModel() );
        vehicle.setMark( dto.getMark() );
        vehicle.setImmatriculation( dto.getImmatriculation() );
        vehicle.setUrlImage( dto.getUrlImage() );

        return vehicle;
    }

    @Override
    public VehicleDTO toDTO(Vehicle data) {
        if ( data == null ) {
            return null;
        }

        VehicleDTO vehicleDTO = new VehicleDTO();

        vehicleDTO.setId( data.getId() );
        vehicleDTO.setProprietaire( data.getProprietaire() );
        vehicleDTO.setModel( data.getModel() );
        vehicleDTO.setMark( data.getMark() );
        vehicleDTO.setImmatriculation( data.getImmatriculation() );
        vehicleDTO.setUrlImage( data.getUrlImage() );

        return vehicleDTO;
    }

    @Override
    public VehicleVisitorDTO toVisitorDTO(Vehicle data) {
        if ( data == null ) {
            return null;
        }

        VehicleVisitorDTO vehicleVisitorDTO = new VehicleVisitorDTO();

        vehicleVisitorDTO.setId( data.getId() );
        vehicleVisitorDTO.setModel( data.getModel() );
        vehicleVisitorDTO.setMark( data.getMark() );
        vehicleVisitorDTO.setImmatriculation( data.getImmatriculation() );

        return vehicleVisitorDTO;
    }

    @Override
    public List<VehicleVisitorDTO> toListVehicleVisitorDTO(List<Vehicle> datas) {
        if ( datas == null ) {
            return null;
        }

        List<VehicleVisitorDTO> list = new ArrayList<VehicleVisitorDTO>( datas.size() );
        for ( Vehicle vehicle : datas ) {
            list.add( toVisitorDTO( vehicle ) );
        }

        return list;
    }
}
