package com.etech.poc.gestion_voiture.service.metier.read.user;

import com.etech.poc.gestion_voiture.donnee.domain.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author bona
 */
public interface UserRSM {

    public User findByUserName(String userName);

    public List<User> findAll();

    public User findById(String id);

    public Page<User> findAll(Pageable page);
}
