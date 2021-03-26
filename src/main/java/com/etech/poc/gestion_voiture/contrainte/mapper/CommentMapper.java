package com.etech.poc.gestion_voiture.contrainte.mapper;

import com.etech.poc.gestion_voiture.donnee.domain.Comment;
import com.etech.poc.gestion_voiture.donnee.dto.CommentDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author bona
 */
@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment toDO(CommentDTO dto);

    @Mappings({
        @org.mapstruct.Mapping(target = "idUser", source = "user.id"),
        @org.mapstruct.Mapping(target = "idVehicle", source = "vehicle.id"),})
    CommentDTO toDO(Comment data);

    List<CommentDTO> toListCommentDTO(List<Comment> datas);

    default Page<CommentDTO> toPageCommentDTO(Page<Comment> datas, Pageable page) {
        List<CommentDTO> commentsDTO = toListCommentDTO(datas.getContent());
        return new PageImpl<>(commentsDTO, page, datas.getTotalElements());
    }
}
