package com.etech.poc.gestion_voiture.donnee.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author bona
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CommentDTO {

    private String id;

    private String data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String idUser;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String idVehicle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

}
