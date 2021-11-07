package com.example.FitFat.Security;


import com.example.FitFat.Models.Users;
import com.example.FitFat.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users applicationUser = usersRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException("the user name " + username + "not found");
        }
        return applicationUser;
    }

}
