package com.etech.poc.gestion_voiture.service.applicatif.read.comment;

import com.etech.poc.gestion_voiture.donnee.dto.CommentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author bona
 */
public interface CommentRSA {

    public Page<CommentDTO> findAllByIdVehicle(String idVehicle, Pageable page);

}
