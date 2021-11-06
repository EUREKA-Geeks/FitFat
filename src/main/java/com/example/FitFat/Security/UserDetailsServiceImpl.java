package com.example.FitFat.Security;

import com.example.FitFat.Models.GymAdmin;
import com.example.FitFat.Repositories.GymAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    GymAdminRepository applicationUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GymAdmin applicationUser= applicationUserRepository.findByUsername(username);
        if(applicationUser==null){
            throw new UsernameNotFoundException("the user name "+username+"not found");
        }
        return applicationUser;
    }

}
