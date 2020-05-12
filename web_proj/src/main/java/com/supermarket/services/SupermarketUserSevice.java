package com.supermarket.services;

import com.supermarket.domain.SupermarketUser;
import com.supermarket.domain.enums.Role;
import com.supermarket.repos.SupermarketUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class SupermarketUserSevice implements UserDetailsService {
    @Autowired
    private SupermarketUserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public SupermarketUser registerUser(SupermarketUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        return userRepo.save(user);
    }

    public SupermarketUser registerAdmin(SupermarketUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        roles.add(Role.ADMIN);
        user.setRoles(roles);
        return userRepo.save(user);
    }

    public SupermarketUser findByUsername(String username){
        return userRepo.findByUsername(username);
    }

    public void deleteAll(){
        userRepo.deleteAll();
    }
}
