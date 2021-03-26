package com.etech.poc.gestion_voiture.service.applicatif.read.user;

import com.etech.poc.gestion_voiture.contrainte.mapper.UserMapper;
import com.etech.poc.gestion_voiture.donnee.domain.User;
import com.etech.poc.gestion_voiture.donnee.dto.UserAuthDTO;
import com.etech.poc.gestion_voiture.donnee.dto.UserDTO;
import com.etech.poc.gestion_voiture.service.metier.read.user.UserRSM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author bona
 */
@Service
public class UserRSAImpl implements UserRSA {

    @Autowired
    private UserRSM userRSM;

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDTO findByUserName(String userName) {
        User user = userRSM.findByUserName(userName);
        return mapper.toDTO(user);
    }

    @Override
    public Page<UserDTO> findAll(Pageable page) {
        Page<User> users = userRSM.findAll(page);
        return mapper.toPageUserDTO(users, page);
    }

}
