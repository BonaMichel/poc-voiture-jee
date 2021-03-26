package com.etech.poc.gestion_voiture.infrastructure.Comment;

import com.etech.poc.gestion_voiture.donnee.dto.CommentDTO;
import com.etech.poc.gestion_voiture.service.applicatif.cud.comment.CommentCUDSA;
import com.etech.poc.gestion_voiture.service.applicatif.read.comment.CommentRSA;
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
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentRSA commentRSA;

    @Autowired
    private CommentCUDSA commentCUDSA;

    @PreAuthorize("hasRole('ROLE_USER')")
    @ApiOperation(value = "get comments of vehicle", notes = "This web service is used to get all comment pagined of the vehicle ")
    @GetMapping(path = "/{idVehicle}")
    public Page<CommentDTO> getCommentByVehicule(
            @ApiParam(name = "idVehicle", value = "1", required = true) @PathVariable("idVehicle") String idVehicle,
            @PageableDefault(page = 0, size = 10) Pageable page) {
        return commentRSA.findAllByIdVehicle(idVehicle, page);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @ApiOperation(value = "publish comment", notes = "This web service is used to add comment")
    @PostMapping(path = "/add")
    public CommentDTO addComment(
            @ApiParam(name = "CommentDTO", value = "{\"commentDTO\":{\n"
                    + "    \"data\": \"ce ci est une teste de commentaire\",\n"
                    + "    \"idUser\": \"1\",\n"
                    + "    \"idVehicle\": \"1\"\n"
                    + "}}")
            @RequestBody CommentDTO commentDTO) {

        return commentCUDSA.add(commentDTO);
    }
}
