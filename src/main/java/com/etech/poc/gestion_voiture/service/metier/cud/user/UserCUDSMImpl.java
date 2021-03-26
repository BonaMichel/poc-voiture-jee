package com.etech.poc.gestion_voiture.service.metier.cud.user;

import com.etech.poc.gestion_voiture.donnee.domain.User;
import com.etech.poc.gestion_voiture.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bona
 */
@Service
public class UserCUDSMImpl implements UserCUDSM {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}
