package com.etech.poc.gestion_voiture.contrainte.mapper;

import com.etech.poc.gestion_voiture.donnee.domain.Comment;
import com.etech.poc.gestion_voiture.donnee.domain.User;
import com.etech.poc.gestion_voiture.donnee.domain.Vehicle;
import com.etech.poc.gestion_voiture.donnee.dto.CommentDTO;
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
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment toDO(CommentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setId( dto.getId() );
        comment.setData( dto.getData() );

        return comment;
    }

    @Override
    public CommentDTO toDO(Comment data) {
        if ( data == null ) {
            return null;
        }

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setIdUser( dataUserId( data ) );
        commentDTO.setIdVehicle( dataVehicleId( data ) );
        commentDTO.setId( data.getId() );
        commentDTO.setData( data.getData() );

        return commentDTO;
    }

    @Override
    public List<CommentDTO> toListCommentDTO(List<Comment> datas) {
        if ( datas == null ) {
            return null;
        }

        List<CommentDTO> list = new ArrayList<CommentDTO>( datas.size() );
        for ( Comment comment : datas ) {
            list.add( toDO( comment ) );
        }

        return list;
    }

    private String dataUserId(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        User user = comment.getUser();
        if ( user == null ) {
            return null;
        }
        String id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String dataVehicleId(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        Vehicle vehicle = comment.getVehicle();
        if ( vehicle == null ) {
            return null;
        }
        String id = vehicle.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
