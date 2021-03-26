package com.etech.poc.gestion_voiture.service.metier.read.user;

import com.etech.poc.gestion_voiture.donnee.domain.User;
import com.etech.poc.gestion_voiture.service.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author bona
 */
@Service
public class UserRSMImpl implements UserDetailsService, UserRSM {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserName(String userName) {
        Optional<User> user = userRepository.findByUserName(userName);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findByUserName(userName);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
        }
        throw new UsernameNotFoundException("Error, The username doesn't exist");
    }

    @Override
    public User findById(String id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            return userOpt.get();
        }
        return null;
    }

    @Override
    public Page<User> findAll(Pageable page) {
        return userRepository.findAll(page);
    }

}
