package com.etech.poc.gestion_voiture.donnee.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author bona
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserAuthDTO {

    private String id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userName;

    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserAuthDTO(String token, String userName, String id) {
        this.token = token;
        this.userName = userName;
        this.id = id;
    }
}
