package com.etech.poc.gestion_voiture.commun.config.security.jwt;

import io.jsonwebtoken.SignatureAlgorithm;

/**
 *
 * @author bona
 */
public class JwtProperties {

    public static final String SECRET = "JwtBonaMiSecret001";
    public static final int EXPIRATION_TIME = 864_000_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
}
