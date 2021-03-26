package com.etech.poc.gestion_voiture.service.metier.read.comment;

import com.etech.poc.gestion_voiture.donnee.domain.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author bona
 */
public interface CommentRSM {

    public Page<Comment> findAllByIdVehicle(String idVehicle, Pageable page);

    public Comment findById(String id);
}
