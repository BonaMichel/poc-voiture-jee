package com.etech.poc.gestion_voiture.service.applicatif.cud.user;

import com.etech.poc.gestion_voiture.donnee.domain.User;
import com.etech.poc.gestion_voiture.service.metier.cud.user.UserCUDSM;
import com.etech.poc.gestion_voiture.service.metier.read.user.UserRSM;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author bona
 */
@Service
public class UserCUDSAImpl implements UserCUDSA {

    @Autowired
    private UserRSM userRSM;

    @Autowired
    private UserCUDSM userCUDSM;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initUser() {
        List<User> users = userRSM.findAll();
        if (users.isEmpty()) {
            for (int i = 0; i < 3; i++) {
                User user = new User();
                user.setPassword(passwordEncoder.encode("userPassword" + i));
                user.setUserName("user" + i);
                user.setId(UUID.randomUUID().toString());
                userCUDSM.save(user);
            }
        }
    }
}
