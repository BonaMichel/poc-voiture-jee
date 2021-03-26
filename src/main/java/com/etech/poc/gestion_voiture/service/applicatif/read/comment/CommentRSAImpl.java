package com.etech.poc.gestion_voiture.service.applicatif.read.comment;

import com.etech.poc.gestion_voiture.contrainte.error.ErrorsEnum;
import com.etech.poc.gestion_voiture.contrainte.error.FunctionalException;
import com.etech.poc.gestion_voiture.contrainte.mapper.CommentMapper;
import com.etech.poc.gestion_voiture.donnee.domain.Comment;
import com.etech.poc.gestion_voiture.donnee.dto.CommentDTO;
import com.etech.poc.gestion_voiture.service.metier.read.comment.CommentRSM;
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
public class CommentRSAImpl implements CommentRSA {

    @Autowired
    private CommentRSM commentRSM;

    @Autowired
    private VehicleRSM vehicleRSM;

    @Autowired
    private CommentMapper mapper;

    @Override
    public Page<CommentDTO> findAllByIdVehicle(String idVehicle, Pageable page) {
        if (StringUtils.isEmpty(idVehicle) || vehicleRSM.findById(idVehicle) == null) {
            throw new FunctionalException(ErrorsEnum.ERR_VEHICLE_INVALID);
        }
        Page<Comment> comments = commentRSM.findAllByIdVehicle(idVehicle, page);
        return mapper.toPageCommentDTO(comments, page);
    }

}
