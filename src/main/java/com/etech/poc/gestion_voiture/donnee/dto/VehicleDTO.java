package com.etech.poc.gestion_voiture.donnee.dto;

/**
 *
 * @author bona
 */
public class VehicleDTO {

    private String id;

    private String proprietaire;

    private String model;

    private String mark;

    private String immatriculation;

    private String UrlImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getUrlImage() {
        return UrlImage;
    }

    public void setUrlImage(String UrlImage) {
        this.UrlImage = UrlImage;
    }

}
