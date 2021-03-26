package com.etech.poc.gestion_voiture.donnee.domain;

import com.etech.poc.gestion_voiture.donnee.commun.AuditModel;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author bona
 */
@Entity
@Table(name = "vehicle")
public class Vehicle extends AuditModel {

    @Id
    private String id;

    private String proprietaire;

    private String model;

    private String mark;

    @Column(unique = true)
    private String immatriculation;

    private String UrlImage;

    @OneToMany(mappedBy = "vehicle")
    private List<Comment> comments;

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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
