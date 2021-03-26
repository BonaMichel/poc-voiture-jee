package com.etech.poc.gestion_voiture.service.applicatif.cud.comment;

import com.etech.poc.gestion_voiture.donnee.dto.CommentDTO;

/**
 *
 * @author bona
 */
public interface CommentCUDSA {

    public CommentDTO add(CommentDTO commentDTO);

    public CommentDTO update(CommentDTO commentDTO);
}
