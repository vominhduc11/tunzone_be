package com.devwonder.tunzone.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devwonder.tunzone.repository.AccountRepository;

@Service
public class OurUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accRepo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accRepo.findByUsername(username).orElseThrow();
    }
}
