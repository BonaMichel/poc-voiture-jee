package com.etech.poc.gestion_voiture.service.metier.cud.comment;

import com.etech.poc.gestion_voiture.donnee.domain.Comment;
import com.etech.poc.gestion_voiture.service.repository.CommentRepository;
import java.util.Date;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bona
 */
@Service
public class CommentCUDSMImpl implements CommentCUDSM {
    
    @Autowired
    private CommentRepository commentRepository;
    
    @Override
    public Comment save(Comment comment) {
        if (StringUtils.isEmpty(comment.getId())) {
            String id = UUID.randomUUID().toString();
            comment.setId(id);
        }
        Date now = new Date();
        comment.setCreatedAt(now);
        comment.setUpdatedAt(now);
        return commentRepository.save(comment);
    }
    
}
