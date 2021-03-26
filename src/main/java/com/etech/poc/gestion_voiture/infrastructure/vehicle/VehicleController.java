package com.etech.poc.gestion_voiture.infrastructure.vehicle;

import com.etech.poc.gestion_voiture.donnee.dto.VehicleDTO;
import com.etech.poc.gestion_voiture.donnee.dto.VehicleVisitorDTO;
import com.etech.poc.gestion_voiture.service.applicatif.cud.vehicle.VehicleCUDSA;
import com.etech.poc.gestion_voiture.service.applicatif.read.vehicle.VehicleRSA;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bona
 */
@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {

    @Autowired
    private VehicleRSA vehicleRSA;

    @Autowired
    private VehicleCUDSA vehicleCUDSA;

    @PreAuthorize("permitAll()")
    @ApiOperation(value = "get list vehicle", notes = "This web service is used to get list of vehicle pagined")
    @GetMapping(path = "/all")
    public Page<VehicleVisitorDTO> getListVehicle(@PageableDefault(page = 0, size = 10) Pageable page) {
        return vehicleRSA.findAll(page);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @ApiOperation(value = "get information vehicle", notes = "This web service is used to get information of the vehicle ")
    @GetMapping(path = "/{idVehicle}")
    public VehicleDTO getVehicle(@ApiParam(name = "idVehicle", value = "1", required = true) @PathVariable("idVehicle") String idVehicle) {
        return vehicleRSA.findById(idVehicle);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @ApiOperation(value = "add vehicle", notes = "This web service is used to add vehicle")
    @PostMapping(path = "/add")
    public VehicleDTO addVehicle(
            @ApiParam(name = "CommentDTO", value = "{\"commentDTO\":{\n"
                    + "    \"proprietaire\": \"proprietaire\",\n"
                    + "    \"model\": \"e23\",\n"
                    + "    \"mark\": \"BMW\",\n"
                    + "    \"immatriculation\": \"21-AT-87\",\n"
                    + "    \"UrlImage\": \"http://monImage.com\"\n"
                    + "}}")
            @RequestBody VehicleDTO commentvehicleDTO) {

        return vehicleCUDSA.addVehicule(commentvehicleDTO);
    }

}
