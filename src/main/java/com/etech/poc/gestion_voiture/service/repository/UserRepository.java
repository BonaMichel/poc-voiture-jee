package com.etech.poc.gestion_voiture.service.repository;

import com.etech.poc.gestion_voiture.donnee.domain.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bona
 */
public interface UserRepository extends JpaRepository<User, String> {

    public Optional<User> findByUserName(String userName);

    public Page<User> findAll(Pageable page);

}
