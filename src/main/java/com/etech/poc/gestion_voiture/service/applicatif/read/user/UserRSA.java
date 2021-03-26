package com.etech.poc.gestion_voiture.service.applicatif.read.user;

import com.etech.poc.gestion_voiture.donnee.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author bona
 */
public interface UserRSA {

    public UserDTO findByUserName(String userName);

    public Page<UserDTO> findAll(Pageable page);
}
