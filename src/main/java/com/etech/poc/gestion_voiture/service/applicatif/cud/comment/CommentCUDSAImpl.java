package com.etech.poc.gestion_voiture.service.applicatif.cud.comment;

import com.etech.poc.gestion_voiture.contrainte.error.ErrorsEnum;
import com.etech.poc.gestion_voiture.contrainte.error.FunctionalException;
import com.etech.poc.gestion_voiture.contrainte.mapper.CommentMapper;
import com.etech.poc.gestion_voiture.donnee.domain.Comment;
import com.etech.poc.gestion_voiture.donnee.domain.User;
import com.etech.poc.gestion_voiture.donnee.domain.Vehicle;
import com.etech.poc.gestion_voiture.donnee.dto.CommentDTO;
import com.etech.poc.gestion_voiture.service.metier.cud.comment.CommentCUDSM;
import com.etech.poc.gestion_voiture.service.metier.read.comment.CommentRSM;
import com.etech.poc.gestion_voiture.service.metier.read.user.UserRSM;
import com.etech.poc.gestion_voiture.service.metier.read.vehicle.VehicleRSM;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bona
 */
@Service
public class CommentCUDSAImpl implements CommentCUDSA {

    @Autowired
    private CommentCUDSM commentCUDSM;

    @Autowired
    private CommentRSM commentRSM;

    @Autowired
    private UserRSM userRSM;

    @Autowired
    private VehicleRSM vehicleRSM;

    @Autowired
    private CommentMapper mapper;

    @Override
    public CommentDTO add(CommentDTO commentDTO) {
        if (StringUtils.isEmpty(commentDTO.getData())) {
            throw new FunctionalException(ErrorsEnum.ERR_COMMENT_INVALID);
        }

        if (StringUtils.isEmpty(commentDTO.getIdUser())) {
            throw new FunctionalException(ErrorsEnum.ERR_USER_INVALID);
        }
        User user = userRSM.findById(commentDTO.getIdUser());
        if (user == null) {
            throw new FunctionalException(ErrorsEnum.ERR_USER_INVALID);
        }

        if (StringUtils.isEmpty(commentDTO.getIdVehicle())) {
            throw new FunctionalException(ErrorsEnum.ERR_VEHICLE_INVALID);
        }
        Vehicle vehicle = vehicleRSM.findById(commentDTO.getIdVehicle());
        if (vehicle == null) {
            throw new FunctionalException(ErrorsEnum.ERR_VEHICLE_INVALID);
        }

        Comment data = mapper.toDO(commentDTO);
        data.setUser(user);
        data.setVehicle(vehicle);
        Comment comment = commentCUDSM.save(data);
        return mapper.toDO(comment);

    }

    @Override
    public CommentDTO update(CommentDTO commentDTO) {
        if (StringUtils.isEmpty(commentDTO.getData())) {
            throw new FunctionalException(ErrorsEnum.ERR_DATA_COMMENT_INVALID);
        }

        if (StringUtils.isEmpty(commentDTO.getIdUser()) || userRSM.findById(commentDTO.getIdUser()) == null) {
            throw new FunctionalException(ErrorsEnum.ERR_USER_INVALID);
        }

        if (StringUtils.isEmpty(commentDTO.getIdVehicle()) || vehicleRSM.findById(commentDTO.getIdVehicle()) == null) {
            throw new FunctionalException(ErrorsEnum.ERR_VEHICLE_INVALID);
        }

        if (StringUtils.isEmpty(commentDTO.getId()) || commentRSM.findById(commentDTO.getId()) == null) {
            throw new FunctionalException(ErrorsEnum.ERR_COMMENT_INVALID);
        }

        Comment comment = commentCUDSM.save(mapper.toDO(commentDTO));
        return mapper.toDO(comment);
    }

}
