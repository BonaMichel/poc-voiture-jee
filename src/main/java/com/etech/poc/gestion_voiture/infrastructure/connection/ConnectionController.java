package com.etech.poc.gestion_voiture.infrastructure.connection;

import com.etech.poc.gestion_voiture.commun.config.security.jwt.JwtProperties;
import com.etech.poc.gestion_voiture.commun.config.security.jwt.JwtUtil;
import com.etech.poc.gestion_voiture.donnee.dto.UserAuthDTO;
import com.etech.poc.gestion_voiture.donnee.dto.UserDTO;
import com.etech.poc.gestion_voiture.service.applicatif.read.user.UserRSA;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bona
 */
@RestController
@RequestMapping(value = "user/")
public class ConnectionController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRSA userRSA;

    @PreAuthorize("permitAll()")
    @ApiOperation(value = "login", notes = "ws to connect and getting access token")
    @PostMapping("/signIn")
    public ResponseEntity<UserAuthDTO> login(@RequestBody UserAuthDTO userAuth, HttpServletResponse response) throws Exception {
        try {
            Authentication result = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAuth.getUserName(), userAuth.getPassword()));
            if (result.isAuthenticated()) {
                UserDTO user = userRSA.findByUserName(userAuth.getUserName());
                String token = jwtUtil.generateToken(userAuth.getUserName());
                response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + token);
                return new ResponseEntity<>(new UserAuthDTO(JwtProperties.TOKEN_PREFIX + token, user.getUserName(), user.getId()), HttpStatus.OK);

            } else {
                return new ResponseEntity<>(new UserAuthDTO(null, userAuth.getUserName(), null), HttpStatus.FORBIDDEN);
            }
        } catch (AuthenticationException e) {
            throw new Exception("Invalid username or password");
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @ApiOperation(value = "get list vehicle", notes = "This web service is used to get list of vehicle pagined")
    @GetMapping(path = "/all")
    public Page<UserDTO> getListVehicle(@PageableDefault(page = 0, size = 10) Pageable page) {
        return userRSA.findAll(page);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @ApiOperation(value = "logout", notes = "ws to revoke access token")
    @DeleteMapping("/signOut")
    public void logout() throws Exception {

    }

}
