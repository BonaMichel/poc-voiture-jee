package com.etech.poc.gestion_voiture.donnee.domain;

import com.etech.poc.gestion_voiture.donnee.commun.AuditModel;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author bona
 */
@Entity
@Table(name = "comment")
public class Comment extends AuditModel {

    @Id
    private String id;

    private String data;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private User user;

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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
