package com.memoire.secerity;

import com.memoire.entity.User;
import com.memoire.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {
    @Autowired
   private AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = accountService.loadUsername(username);
        if(user == null)throw new  UsernameNotFoundException("Invalid user");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(r-> {
            authorities.add(new SimpleGrantedAuthority((r.getRoleName())));
        });
        //objet user de spring poure sercitity verifi si autoriser
            return  new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
        }
    }


