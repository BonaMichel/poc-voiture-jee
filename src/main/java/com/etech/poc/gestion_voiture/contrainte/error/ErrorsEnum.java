package com.etech.poc.gestion_voiture.contrainte.error;

/**
 *
 * @author bona
 */
public enum ErrorsEnum {

    ERR_ID_VEHICLE("ERR_ID_VEHICLE", "Id vehicle can not be null.", Boolean.TRUE),
    ERR_IMM_VEHICLE("ERR_IMM_VEHICLE", "Immatriculation vehicle can not be null.", Boolean.TRUE),
    

    ERR_USER_INVALID("ERR_USER_INVALID", "User not valid.", Boolean.TRUE),
    ERR_VEHICLE_INVALID("ERR_VEHICLE_INVALID", "Vehicle not valid.", Boolean.TRUE), 
    ERR_COMMENT_INVALID("ERR_ID_COMMENT_INVALID", "Comment not valid.", Boolean.TRUE),
    ERR_DATA_COMMENT_INVALID("ERR_DATA_COMMENT_INVALID", "Comment can not be null.", Boolean.TRUE),;

    private final String errorCode;
    private final String errorMessage;
    private final Boolean error;

    ErrorsEnum(String errorCode, String errorMessage, Boolean error) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.error = error;
    }

    @Override
    public String toString() {
        return "ErrorCode : " + errorCode + " errorMessage : " + errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Boolean getError() {
        return error;
    }
}
