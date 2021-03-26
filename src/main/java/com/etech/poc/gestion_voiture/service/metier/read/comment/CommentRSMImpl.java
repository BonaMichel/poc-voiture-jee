package com.etech.poc.gestion_voiture.service.metier.read.comment;

import com.etech.poc.gestion_voiture.donnee.domain.Comment;
import com.etech.poc.gestion_voiture.service.repository.CommentRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author bona
 */
@Service
public class CommentRSMImpl implements CommentRSM {

    @Autowired
    private CommentRepository commentReopository;

    @Override
    public Page<Comment> findAllByIdVehicle(String idVehicle, Pageable page) {
        return commentReopository.findAllByIdVehicle(idVehicle, page);
    }

    @Override
    public Comment findById(String id) {
        Optional<Comment> comOpt = commentReopository.findById(id);
        if (comOpt.isPresent()) {
            return comOpt.get();
        }
        return null;
    }

}
